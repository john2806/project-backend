package com.backend.apiserver.service.impl;

import com.backend.apiserver.entity.User;
import com.backend.apiserver.repository.UserRepository;
import com.backend.apiserver.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {



    private UserRepository userRepository;

    @Override
    public List<User> getAllListUser() {
        return userRepository.findAll();
    }
}
