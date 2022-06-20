package com.marketkurly.clone.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserRequestDto {
    private String username;
    private String password;
    private String name;
    private String email;
}
