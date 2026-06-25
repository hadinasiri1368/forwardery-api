package com.forwardery.tokenManager;

public interface TokenManager {

    String generateToken(String userId, Object user);

    boolean isTokenValid(String token, String userId);

    void revokeToken(String userId);

    Object getTokenData(String userId, String token);

    String refreshToken(String oldToken);
}

