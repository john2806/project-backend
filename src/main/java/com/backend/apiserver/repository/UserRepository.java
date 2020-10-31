package com.backend.apiserver.repository;

import com.backend.apiserver.entity.Status;
import com.backend.apiserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * find an user with username and status
     *
     * @param username
     * @param status
     * @return User
     */
    User findByUsernameAndStatus(String username, Status status);

    /**
     * find an user with username or email
     *
     * @param username
     * @return User
     */
    User findByUsername(String username);

    /**
     * find an user with id and status
     *
     * @param id
     * @return User
     */
    User findByIdAndStatus(Long id, Status status);
}
