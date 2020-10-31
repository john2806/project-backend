package com.backend.apiserver.security;

import com.backend.apiserver.entity.Status;
import com.backend.apiserver.entity.User;
import com.backend.apiserver.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    /**
     * Default method using to validate username and password of spring security
     *
     * @param username
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameAndStatus(username, Status.ACTIVE);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("Not found any user with given username" + username);
        }
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole().getName());
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singleton(grantedAuthority)
        );
    }

}
