package com.backend.apiserver.service.impl;

import com.backend.apiserver.request.AuthRequest;
import com.backend.apiserver.response.TokenInfoResponse;
import com.backend.apiserver.service.AuthenticateService;
import com.backend.apiserver.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticateServiceImpl implements AuthenticateService {

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticateServiceImpl.class);

    private JwtUtils jwtUtils;

    private AuthenticationManager authenticationManager;

    @Override
    public TokenInfoResponse performAuthentication(AuthRequest authRequest) throws AuthenticationException {

        // authenticate username and password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getUsername(),
                        authRequest.getPassword()
                )
        );

        // if there's not exception thrown, mean that user information is valid
        // set authentication information to Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //generate jwt token after user valid
        String jwt = jwtUtils.generateToken(authentication);

        //get information from UserDetailService
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        //Get all the roles of user
        Optional<String> optionalRole = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst();

        //create response entity
        TokenInfoResponse tokenInfoResponse = TokenInfoResponse.builder()
                .username(userDetails.getUsername())
                .token(jwt)
                .role(optionalRole.get())
                .build();

        return tokenInfoResponse;
    }
}
