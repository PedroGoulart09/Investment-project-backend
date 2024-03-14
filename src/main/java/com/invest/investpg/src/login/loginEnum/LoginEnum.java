package com.invest.investpg.src.login.loginEnum;

public enum LoginEnum {
    ADMIN("admin"),
    USER("user");

    private final String role;

    LoginEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
