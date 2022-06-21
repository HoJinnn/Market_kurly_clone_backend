package com.marketkurly.clone.controller;


import com.marketkurly.clone.dto.JwtResponseDto;
import com.marketkurly.clone.dto.UserLoginRequestDto;
import com.marketkurly.clone.dto.UserRequestDto;
import com.marketkurly.clone.security.UserDetailsImpl;
import com.marketkurly.clone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    //회원가입
    @PostMapping("/user/signup")
    public String  signupUser(@RequestBody UserRequestDto singUpData){
        return userService.signupUser(singUpData);
    }
    //아이디 중복체크
    @GetMapping("/user/idCheck/{username}")
    public boolean signupUseridCheck(@PathVariable String username){
        return userService.signupUsernameCheck(username);
    }
    //로그인
    @PostMapping("/user/login")
    public JwtResponseDto loginUser(@RequestBody UserLoginRequestDto loginData){
        return userService.loginUser(loginData);
    }

    @GetMapping("/user/info")
    public String GetUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return userService.GetUserInfo(userDetails);
    }
}
