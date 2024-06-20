package com.soa.novelcreatorcore.security.service;

import com.soa.novelcreatorcore.repository.model.Role;
import com.soa.novelcreatorcore.repository.model.User;
import com.soa.novelcreatorcore.repository.service.RoleRepository;
import com.soa.novelcreatorcore.repository.service.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getByLoginOrEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        Role role = roleRepository.getRoleById(user.getRoleId());

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles(role.getRoleName().name())
                .build();
    }
}
