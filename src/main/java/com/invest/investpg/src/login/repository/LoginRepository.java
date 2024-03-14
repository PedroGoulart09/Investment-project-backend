package com.invest.investpg.src.login.repository;

import com.invest.investpg.src.login.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {
    UserDetails findByLogin(String email);
}
