package com.invest.investpg.src.login.controller.request;

import com.invest.investpg.src.login.loginEnum.LoginEnum;
import lombok.Data;

@Data
public class LoginRequest {
    private String login;
    private String password;
    private LoginEnum role;
}
