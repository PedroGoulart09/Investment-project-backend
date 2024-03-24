package com.invest.investpg.src.infra.security;

import com.invest.investpg.src.login.entity.LoginEntity;
import com.invest.investpg.src.login.repository.LoginRepository;
import com.invest.investpg.src.login.service.AuthenticationService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired(required = false)
    private TokenService tokenService;

    @Autowired(required = false)
    private LoginRepository loginRepository;

    @Autowired(required = false)
    private AuthenticationService authenticationService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recoverToken(request);
        if(token != null) {
            try {
                String login = tokenService.decodeToken(token);
                LoginEntity user = loginRepository.findByLogin(login);

                Authentication authentication = authenticationService.authenticate(user);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (RuntimeException e) {
                System.out.println("Failed to authenticate user: " + e.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }

    public String recoverToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.replace("Bearer ", "");
    }
}