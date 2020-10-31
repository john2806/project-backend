package com.backend.apiserver.service;

import com.backend.apiserver.request.AuthRequest;
import com.backend.apiserver.response.TokenInfoResponse;
import org.springframework.security.core.AuthenticationException;

public interface AuthenticateService {

    /**
     *
     * @param authRequest
     * @return
     * @throws AuthenticationException
     */
    TokenInfoResponse performAuthentication(AuthRequest authRequest) throws AuthenticationException;
}
