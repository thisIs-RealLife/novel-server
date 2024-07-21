package com.soa.novelcreatorcore.config.security.service;

import com.soa.novelcreatorcore.config.security.jwt.JwtService;
import com.soa.novelcreatorcore.repository.model.User;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GenerateJwtService {
    public final JwtService jwtService;
    public final CustomUserDetailService customUserDetailService;

    public String generateToken(@NonNull User user) {
        UserDetails userDetails = customUserDetailService.mapUser(user);
        return jwtService.generateToken(userDetails);
    }
}
