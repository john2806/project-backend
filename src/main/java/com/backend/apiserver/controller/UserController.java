package com.backend.apiserver.controller;

import com.backend.apiserver.entity.User;
import com.backend.apiserver.response.ResponseWrapper;
import com.backend.apiserver.service.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @GetMapping("api/v1/list/user")
    public ResponseWrapper getAllListUser() {
        LOG.info("Start to find all user");
        List<User> userShortDesResponses = userService.getAllListUser();
        LOG.info("End to find all user");
        return new ResponseWrapper(userShortDesResponses);
    }
}
