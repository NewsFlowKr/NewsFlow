package com.example.demo.service;

import com.example.demo.advice.exception.CUserNotFoundException;
import com.example.demo.repo.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserJpaRepo userJpaRepo;
    public UserDetails loadUserByUsername(String userPk){
        return userJpaRepo.findById(Integer.parseInt(userPk)).orElseThrow(CUserNotFoundException::new);
    }
}
