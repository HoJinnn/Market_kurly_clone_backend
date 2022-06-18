package com.marketkurly.clone.domain;

import com.marketkurly.clone.dto.UserRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String address;

    public User(UserRequestDto userRequestDto) {

        this.username = userRequestDto.getUsername();
        this.password = userRequestDto.getPassword();
        this.name = userRequestDto.getName();
        this.email = userRequestDto.getEmail();
        this.address = userRequestDto.getAddress();
    }
        public void encryptPassword(PasswordEncoder passwordEncoder) {
            password = passwordEncoder.encode(password);
        }

}
