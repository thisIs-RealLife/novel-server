package com.soa.novelcreatorcore.security.service;

import com.soa.novelcreatorcore.repository.model.User;
import com.soa.novelcreatorcore.security.jwt.JwtService;
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
