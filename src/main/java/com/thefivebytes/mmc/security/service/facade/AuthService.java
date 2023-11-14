package com.thefivebytes.mmc.security.service.facade;


import com.thefivebytes.mmc.security.dto.LoginDto;
import com.thefivebytes.mmc.security.dto.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
