package com.backend.apiserver.controller;

import com.backend.apiserver.exception.UnauthorizedException;
import com.backend.apiserver.request.AuthRequest;
import com.backend.apiserver.response.ResponseMessage;
import com.backend.apiserver.response.TokenInfoResponse;
import com.backend.apiserver.service.AuthenticateService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private AuthenticateService authenticateService;

    @PostMapping("api/v1/auth")
    public TokenInfoResponse authenticate(@Valid @RequestBody final AuthRequest authRequest) throws UnauthorizedException {
        try {
            LOG.info("Start to authenticate login request with information: " + authRequest);
            TokenInfoResponse tokenInfoResponse = authenticateService.performAuthentication(authRequest);
            LOG.info("End to authenticate login request with information: " + authRequest);
            return tokenInfoResponse;
        } catch (AuthenticationException e) {
            throw new UnauthorizedException(ResponseMessage.AuthenticateUserFailed);
        }
    }
}
