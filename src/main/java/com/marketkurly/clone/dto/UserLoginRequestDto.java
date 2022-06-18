package com.marketkurly.clone.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserLoginRequestDto {
    private String username;
    private String password;
}
