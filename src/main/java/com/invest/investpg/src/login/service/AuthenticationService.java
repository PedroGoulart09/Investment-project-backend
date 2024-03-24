package com.invest.investpg.src.login.service;

import com.invest.investpg.src.login.entity.LoginEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired(required = false)
    private AuthenticationManager authenticationManager;

    public Authentication authenticate(LoginEntity user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        return authenticationManager.authenticate(authenticationToken);
    }
}