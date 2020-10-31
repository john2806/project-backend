package com.backend.apiserver.service.impl;

import com.backend.apiserver.entity.Role;
import com.backend.apiserver.entity.Status;
import com.backend.apiserver.entity.User;
import com.backend.apiserver.exception.DataDuplicatedException;
import com.backend.apiserver.exception.NotFoundException;
import com.backend.apiserver.repository.RoleRepository;
import com.backend.apiserver.repository.UserRepository;
import com.backend.apiserver.request.RegisterRequest;
import com.backend.apiserver.service.RegisterService;
import com.backend.apiserver.utils.Constants;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Objects;

@Service
@AllArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private static final Logger LOG = LoggerFactory.getLogger(RegisterServiceImpl.class);

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;


    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void registerUser(RegisterRequest registerRequest) throws DataDuplicatedException, NotFoundException {

        User result = userRepository.findByUsername(registerRequest.getUsername());
        if (Objects.nonNull(result)) {
            if (result.getUsername().equalsIgnoreCase(registerRequest.getUsername())) {
                throw new DataDuplicatedException("User with this username already exists: " + registerRequest.getUsername());
            }
        }

        Role role = roleRepository.findByName(Constants.ROLE_USER);
        if (Objects.isNull(role)) {
            throw new NotFoundException("Not found role with name: " + Constants.ROLE_USER);
        }

        User user = new User();

        BeanUtils.copyProperties(registerRequest, user);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(Status.ACTIVE);
        user.setRole(role);

        //save user to database
        userRepository.saveAndFlush(user);

//        //also create default user summary and save
//        UserSummary userSummary = new UserSummary();
//        userSummary.setUser(user);
//        userSummary.setStatus(Status.ACTIVE);
//
//        //save user summary to database
//        userSummaryRepository.saveAndFlush(userSummary);
    }
}
