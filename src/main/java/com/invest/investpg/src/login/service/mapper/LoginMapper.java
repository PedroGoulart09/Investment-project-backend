package com.invest.investpg.src.login.service.mapper;

import com.invest.investpg.src.login.controller.request.LoginRequest;
import com.invest.investpg.src.login.controller.response.LoginResponse;
import com.invest.investpg.src.login.dto.LoginDto;
import com.invest.investpg.src.login.dto.RegisterDto;
import com.invest.investpg.src.login.entity.LoginEntity;

import java.util.List;
import java.util.stream.Collectors;

public class LoginMapper {


    public static LoginEntity entityToDto(LoginDto loginDto) {
        LoginEntity loginEntity = new LoginEntity(loginDto.getLogin(), loginDto.getPassword(), loginDto.getRole());
        loginEntity.setId(loginDto.getId());
        loginEntity.setLogin(loginDto.getLogin());
        loginEntity.setPassword(loginDto.getPassword());
        loginEntity.setRole(loginDto.getRole());
        return loginEntity;
    }

    public static LoginResponse entityToResponse(LoginEntity loginEntity) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setId(loginEntity.getId());
        loginResponse.setLogin(loginEntity.getLogin());
        loginResponse.setPassword(loginEntity.getPassword());
        loginResponse.setRole(loginEntity.getRole());
        return loginResponse;
    }

    public static RegisterDto requestToDtoRegister(LoginRequest loginRequest) {
        RegisterDto registerDto = new RegisterDto();
        registerDto.setLogin(loginRequest.getLogin());
        registerDto.setPassword(loginRequest.getPassword());
        registerDto.setRole(loginRequest.getRole());
        return registerDto;
    }

    public static LoginDto requestToDtoLogin(LoginRequest loginRequest) {
        LoginDto loginDto = new LoginDto();
        loginDto.setLogin(loginRequest.getLogin());
        loginDto.setPassword(loginRequest.getPassword());
        loginDto.setRole(loginRequest.getRole());
        return loginDto;
    }

    public static List<LoginResponse> entityToResponse(List<LoginEntity> loginEntities) {
        return loginEntities.stream().map(LoginMapper::entityToResponse).collect(Collectors.toList());
    }
}
