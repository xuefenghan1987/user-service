package com.example.userservice.security;

import com.example.userservice.entity.UserAuthEntity;
import com.example.userservice.repository.UserAuthRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserAuthDetailsService implements UserDetailsService {

    private final UserAuthRepository userAuthRepo;

    public CustomUserAuthDetailsService(UserAuthRepository userAuthRepo) {
        this.userAuthRepo = userAuthRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuthEntity user = userAuthRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}
