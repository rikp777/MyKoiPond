package com.api.mykoipond.controllers;

import static org.springframework.http.ResponseEntity.ok;

import com.api.mykoipond.dao.UserRepository;
import com.api.mykoipond.domain.RoleEntity;
import com.api.mykoipond.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository users;

    @SuppressWarnings("rawtypes")
    @PostMapping("/signin")
    public ResponseEntity login(@RequestBody AuthBody data) {
        try {
            String username = data.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));


            Set<RoleEntity> roleEntitySet = this.users.findByEmail(username).getRoles();
            String token = jwtTokenProvider.createToken(username, roleEntitySet);

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (Exception e) {
            throw e;
        }
    }

//    @SuppressWarnings("rawtypes")
//    @PostMapping("/register")
//    public ResponseEntity register(@RequestBody UserEntity userEntity) {
//        UserEntity userEntityExists = userService.findUserByEmail(userEntity.getEmail());
//        if (userEntityExists != null) {
//            throw new BadCredentialsException("User with username: " + userEntity.getEmail() + " already exists");
//        }
//        userService.saveUser(userEntity);
//        Map<Object, Object> model = new HashMap<>();
//        model.put("message", "User registered successfully");
//        return ok(model);
//    }
}
