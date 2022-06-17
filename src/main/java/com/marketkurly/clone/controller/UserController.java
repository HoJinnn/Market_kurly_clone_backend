package com.marketkurly.clone.controller;


import com.marketkurly.clone.dto.UserRequestDto;
import com.marketkurly.clone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;


    @PostMapping("/user/signup")
    public String  signupUser(@RequestBody UserRequestDto singUpData){
        return userService.signupUser(singUpData);
    }

}
