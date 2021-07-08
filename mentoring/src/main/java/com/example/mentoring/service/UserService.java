package com.example.mentoring.service;

import com.example.mentoring.domain.entity.User;
import com.example.mentoring.domain.repository.UserRepository;
import com.example.mentoring.dto.request.JoinRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void join(JoinRequest joinRequest) {
        String password = passwordEncoder.encode(joinRequest.getPassword());

        userRepository.save(User.builder()
                .email(joinRequest.getEmail())
                .password(password)
                .sex(joinRequest.getSex().toString())
                .name(joinRequest.getName())
                .age(joinRequest.getAge())
                .build());
    }
}
