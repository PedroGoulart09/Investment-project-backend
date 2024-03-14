package com.invest.investpg.src.login.service;

import com.invest.investpg.src.erros.errorHandler.ResourceNotFoundException;
import com.invest.investpg.src.erros.errorHandler.ResourceUserAlreadyExistException;
import com.invest.investpg.src.infra.security.TokenService;
import com.invest.investpg.src.login.dto.LoginDto;
import com.invest.investpg.src.login.dto.RegisterDto;
import com.invest.investpg.src.login.dto.TokenDto;
import com.invest.investpg.src.login.entity.LoginEntity;
import com.invest.investpg.src.login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public TokenDto login(LoginDto loginDto, TokenDto tokenDto) {
        try {
            UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(loginDto.getLogin(), loginDto.getPassword());
            Authentication auth = authenticationManager.authenticate(usernamePassword);
            String token = tokenService.generateToken((LoginEntity) auth.getPrincipal());
            tokenDto.setToken(token);
            return tokenDto;
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(loginDto.getLogin());
        }
    }


    public LoginEntity register(RegisterDto registerDto) {
        try {
            if (loginRepository.findByLogin(registerDto.getLogin()) != null) {
                throw new ResourceUserAlreadyExistException();
            }
            String encryptedPassword = new BCryptPasswordEncoder().encode(registerDto.getPassword());
            LoginEntity loginEntity = new LoginEntity(registerDto.getLogin(), encryptedPassword, registerDto.getRole());
            return loginRepository.save(loginEntity);
        } catch (ResourceNotFoundException e) {
            throw new ResourceUserAlreadyExistException();
        }
    }

    public List<LoginEntity> getAllUsers(){
        return loginRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loginRepository.findByLogin(username);
    }
}
