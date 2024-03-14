package com.invest.investpg.src.login.dto;

import com.invest.investpg.src.login.loginEnum.LoginEnum;
import lombok.Data;

@Data
public class RegisterDto {
    private Long id;
    private String login;
    private String password;
    private LoginEnum role;
}
