package com.invest.investpg.src.login.controller.response;

import com.invest.investpg.src.login.loginEnum.LoginEnum;
import lombok.Data;

@Data
public class LoginResponse {
    private Long id;
    private String login;
    private String password;
    private LoginEnum role;
}
