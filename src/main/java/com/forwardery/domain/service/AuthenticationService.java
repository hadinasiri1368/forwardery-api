package com.forwardery.domain.service;

import com.forwardery.config.security.RequestContext;
import com.forwardery.constants.Consts;
import com.forwardery.domain.dto.LoginDto;
import com.forwardery.domain.repository.UsersRepository;
import com.forwardery.exceptions.AuthenticationExceptionType;
import com.forwardery.exceptions.BaseException;
import com.forwardery.model.Users;
import com.forwardery.tokenManager.TokenManager;
import com.forwardery.util.AppUtils;
import com.forwardery.util.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UsersRepository usersRepository;
    private final TokenManager tokenService;
    private final JwtUtil jwtUtil;
    @Value("${spring.profiles.active:main}")
    private String activeProfile;

    public AuthenticationService(UsersRepository usersRepository,
                                 TokenManager tokenService,
                                 JwtUtil jwtUtil) {
        this.usersRepository = usersRepository;
        this.tokenService = tokenService;
        this.jwtUtil = jwtUtil;
    }

    public String login(LoginDto loginDto) throws Exception {
        Users user = getUser(loginDto.getUsername(), loginDto.getPassword());
        user.setInsertedDateTime(null);
        user.setUpdatedDateTime(null);
        return tokenService.generateToken(String.valueOf(user.getId()), user);
    }

    public String refreshToken() throws Exception {
        String token = RequestContext.getToken();
        Object user = JwtUtil.getTokenData(token, Consts.CLAIMS_USER_KEY);
        logout(token);
        return tokenService.generateToken(String.valueOf(((Users) user).getId()), user);
    }

    private Users getUser(String username, String password) {
        Optional<Users> user = usersRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new BaseException(AuthenticationExceptionType.USERNAME_PASSWORD_INVALID);
        }
        if (!activeProfile.equals("dev")) {
            boolean validated = password.equalsIgnoreCase(user.get().getPassword());
            if (!validated) {
                throw new BaseException(AuthenticationExceptionType.USERNAME_PASSWORD_INVALID);
            }
            if (!user.get().getIsActive()) {
                throw new BaseException(AuthenticationExceptionType.USER_IS_NOT_ACTIVE);
            }
        }
        return user.get();

    }

    public void logout(String token) throws Exception {
        if (AppUtils.isNull(token))
            throw new BaseException(AuthenticationExceptionType.TOKEN_IS_NULL);
        Object object = JwtUtil.getTokenData(token, Consts.CLAIMS_USER_KEY);
        if (object == null)
            throw new BaseException(AuthenticationExceptionType.TOKEN_IS_NULL);

        tokenService.revokeToken(String.valueOf(((Users) object).getId()));
    }

}
