package com.marketkurly.clone.domain;

import com.marketkurly.clone.dto.UserRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "users")
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "user_id")
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;

    public User(UserRequestDto userRequestDto) {

        this.username = userRequestDto.getUsername();
        this.password = userRequestDto.getPassword();
        this.name = userRequestDto.getName();
        this.email = userRequestDto.getEmail();
    }
        public void encryptPassword(PasswordEncoder passwordEncoder) {
            password = passwordEncoder.encode(password);
        }

}
