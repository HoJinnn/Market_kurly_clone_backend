package com.marketkurly.clone.service;

import com.marketkurly.clone.domain.User;
import com.marketkurly.clone.dto.JwtResponseDto;
import com.marketkurly.clone.dto.UserLoginRequestDto;
import com.marketkurly.clone.dto.UserRequestDto;
import com.marketkurly.clone.repository.UserRepository;
import com.marketkurly.clone.security.JwtTokenProvider;
import com.marketkurly.clone.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;


    //회원가입
    public String signupUser(UserRequestDto singUpData){


        User beforeSaveUser = new User(singUpData);
        beforeSaveUser.encryptPassword(passwordEncoder);

        User saveUser = userRepository.save(beforeSaveUser);
        User checkUser = userRepository.findById(saveUser.getId()).orElse(null);

        if(saveUser.equals(checkUser)){
            return "회원가입이 완료되었습니다";
        }
        return "회원가입에 실패했습니다";
    }

    //아이디 중복체크
    public boolean signupUsernameCheck(String username){
        Optional<User> found = userRepository.findByUsername(username);
        return (!found.isPresent());
    }
    //로그인
    public JwtResponseDto loginUser(UserLoginRequestDto loginData){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginData.getUsername(), loginData.getPassword()));
        return createJwtToken(authentication);
    }

    //JWT 토큰생성
    private JwtResponseDto createJwtToken(Authentication authentication){
        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
        String token = jwtTokenProvider.generateToken(principal);
        return new JwtResponseDto(token);
    }


}
