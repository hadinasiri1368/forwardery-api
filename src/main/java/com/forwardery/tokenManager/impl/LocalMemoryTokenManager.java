package com.forwardery.tokenManager.impl;

import com.forwardery.constants.Consts;
import com.forwardery.exceptions.AuthenticationExceptionType;
import com.forwardery.exceptions.BaseException;
import com.forwardery.exceptions.GeneralExceptionType;
import com.forwardery.tokenManager.TokenManager;
import com.forwardery.util.AppUtils;
import com.forwardery.util.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LocalMemoryTokenManager implements TokenManager {
    private Map<String, String> localMemory;

    public LocalMemoryTokenManager() {
        localMemory = new HashMap<>();
    }

    @Override
    public String generateToken(String userId, Object user) {
        validateIds(userId);

        String key = sessionKey(userId);

        String newToken = JwtUtil.createToken(user);

        localMemory.put(key, newToken);
        return newToken;
    }

    @Override
    public boolean isTokenValid(String token, String userId) {

        if (!JwtUtil.validateToken(token)) {
            return false;
        }

        String storedToken = localMemory.get(sessionKey(userId));

        return !AppUtils.isNull(storedToken);
    }

    @Override
    public void revokeToken(String userId) {
        validateIds(userId);

        localMemory.remove(sessionKey(userId));
    }

    @Override
    public Object getTokenData(String userId, String token) {
        if (!isTokenValid(token, userId)) {
            throw new BaseException(AuthenticationExceptionType.TOKEN_IS_NULL);
        }

        return JwtUtil.getTokenData(token, Consts.CLAIMS_USER_KEY);
    }

    @Override
    public String refreshToken(String oldToken) {
        throw new UnsupportedOperationException("Refresh not implemented");
    }

    private void validateIds(String userId) {
        if (userId == null || userId.isBlank())
            throw new BaseException(GeneralExceptionType.FIELD_NOT_VALID, new Object[]{"userId"});
    }

    private String sessionKey(String userId) {
        return "session_token:" + userId;
    }
}
