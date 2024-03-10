package com.revelup.user.model.service;

import com.revelup.user.model.dao.UserMapper;
import com.revelup.user.model.dto.LoginUserDTO;
import com.revelup.user.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.print.DocFlavor;
import java.util.Objects;

@Service
//@RequiredArgsConstructor  -> (final 이 대상임) 초기화하는 생성자 자동으로 해줌
public class UserService {

    @Autowired
    private UserMapper userMapper;
//    private final UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    /** 로그인 시 아이디 비교 */
    public LoginUserDTO findByUserId(String userId) {

        LoginUserDTO login = userMapper.findByUserId(userId);

        if (!Objects.isNull(login)) {
            return login;
        } else {
            return null;
        }

    }

    /** 회원가입 */
    public int signup(UserDTO userDTO) {
        userDTO.setUserPw(passwordEncoder.encode(userDTO.getUserPw()));

        int result = 0;

        try {
          result = userMapper.signup(userDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
   }

    /** 로그인 후 정보 조회 후 정보 출력 */
    public LoginUserDTO findByLoginId(String loginUserId) {

        return userMapper.findByLoginId(loginUserId);

    }

    /** 아이디 중복 체크 */
    public boolean checkUserId(String userId) {

        UserDTO check = userMapper.checkUserId(userId);

        return check == null;

    }
}