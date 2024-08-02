package com.example.dischord.global.security;

import com.example.dischord.global.exception.BadRequestException;
import com.example.dischord.global.exception.ExceptionCode;
import com.example.dischord.user.repository.UserRepository;
import com.example.dischord.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("로그인 실패"));

        return new CustomUserDetails(user);
    }
}
