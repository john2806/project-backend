package com.backend.apiserver.controller;

import com.backend.apiserver.exception.BadRequestException;
import com.backend.apiserver.exception.DataDuplicatedException;
import com.backend.apiserver.exception.NotFoundException;
import com.backend.apiserver.request.RegisterRequest;
import com.backend.apiserver.response.Response;
import com.backend.apiserver.response.ResponseMessage;
import com.backend.apiserver.service.RegisterService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class RegisterController {

    private static final Logger LOG = LoggerFactory.getLogger(RegisterController.class);

    private RegisterService registerService;

    @PostMapping("api/v1/register")
    public Response register(@Valid @RequestBody final RegisterRequest registerRequest) throws BadRequestException {
        try {
            LOG.info("Start to create user with username: ", registerRequest.getUsername());
            registerService.registerUser(registerRequest);
            LOG.info("End to create user with username: ", registerRequest.getUsername());
            return new Response(ResponseMessage.RegisterUserSuccessfully);
        } catch (DataDuplicatedException e) {
            throw new BadRequestException(ResponseMessage.DuplicatedUsername, registerRequest.getUsername());
        } catch (NotFoundException e) {
            throw new BadRequestException(ResponseMessage.UserRoleNotFound);
        }
    }
}
