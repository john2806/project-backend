package com.backend.apiserver.service;

import com.backend.apiserver.exception.DataDuplicatedException;
import com.backend.apiserver.exception.NotFoundException;
import com.backend.apiserver.request.RegisterRequest;

public interface RegisterService {

    /**
     * Register new user with given information
     *
     * @param registerRequest
     * @throws DataDuplicatedException
     * @throws NotFoundException
     */
    void registerUser(RegisterRequest registerRequest) throws DataDuplicatedException, NotFoundException;
}
