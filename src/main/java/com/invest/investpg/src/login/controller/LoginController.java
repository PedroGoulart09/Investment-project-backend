package com.invest.investpg.src.login.controller;

import com.invest.investpg.src.login.controller.request.LoginRequest;
import com.invest.investpg.src.login.controller.response.LoginResponse;
import com.invest.investpg.src.login.dto.RegisterDto;
import com.invest.investpg.src.login.dto.TokenDto;
import com.invest.investpg.src.login.entity.LoginEntity;
import com.invest.investpg.src.login.service.LoginService;
import com.invest.investpg.src.login.service.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/")
    @CrossOrigin(origins = "*")
    public ResponseEntity<TokenDto> loginUser(@RequestBody LoginRequest loginRequest, TokenDto tokenDto) {
        TokenDto auth = loginService.login(LoginMapper.requestToDtoLogin(loginRequest), tokenDto);
        return ResponseEntity.ok(auth);
    }

    @PostMapping("/register")
    @CrossOrigin(origins = "*")
    public ResponseEntity<LoginResponse> registerUser(@RequestBody  LoginRequest loginRequest) {
        RegisterDto registerDto = LoginMapper.requestToDtoRegister(loginRequest);
        LoginEntity loginEntity = loginService.register(registerDto);
        return ResponseEntity.status(201).body(LoginMapper.entityToResponse(loginEntity));
    }

    @GetMapping("/users")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<LoginResponse>> getAllUsers() {
        List<LoginEntity> loginEntities = loginService.getAllUsers();
        return ResponseEntity.status(200).body(LoginMapper.entityToResponse(loginEntities));
    }
}
