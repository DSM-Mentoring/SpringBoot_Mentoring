package com.example.mentoring.controller;

import com.example.mentoring.dto.request.JoinRequest;
import com.example.mentoring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //rest가 붙은 controller
@RequestMapping("/user") //request : 요청, response : 반환 // 즉 RequestMapping은 뒤에 붙는 주소
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;  //final : 상수를 의미함

    @PostMapping("/join")
    public void join(@RequestBody JoinRequest joinRequest) {
        userService.join(joinRequest);
    }
}
