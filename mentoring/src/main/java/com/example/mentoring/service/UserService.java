package com.example.mentoring.service;

import com.example.mentoring.domain.entity.User;
import com.example.mentoring.domain.repository.UserRepository;
import com.example.mentoring.dto.request.JoinRequest;
import com.example.mentoring.dto.request.LoginRequest;
import com.example.mentoring.dto.response.TokenResponse;
import com.example.mentoring.exception.error.UserNotFoundException;
import com.example.mentoring.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Join;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

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

    public TokenResponse login(LoginRequest loginRequest) {
        //findByEmail의 반환 타입이 Optional<User>일 때
        userRepository.findByEmail(loginRequest.getEmail())
                .filter(u -> passwordEncoder.matches(loginRequest.getPassword(), u.getPassword()))
                .orElseThrow(UserNotFoundException::new);
        /*
        //findByEmail의 반환 타입이 User일 떄
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if(!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new UserNotFoundException();
        }*/

        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(loginRequest.getEmail()))
                .refreshToken(jwtTokenProvider.generateRefreshToken(loginRequest.getEmail()))
                .tokenType("Bearer")
                .build();
    }
}
