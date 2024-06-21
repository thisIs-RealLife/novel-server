package com.soa.novelcreatorcore.repository.service;

import com.soa.novelcreatorcore.helper.PasswordUtil;
import com.soa.novelcreatorcore.repository.mapper.UserMapper;
import com.soa.novelcreatorcore.repository.model.Role;
import com.soa.novelcreatorcore.repository.model.RoleName;
import com.soa.novelcreatorcore.repository.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserRepository {

    private final UserMapper userMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User createNewUser(User user) {
        Role role = roleRepository.getRoleByRoleName(RoleName.ROLE_USER);
        user.setRoleId(role.getId());
        String password = user.getPassword();
        if (password == null) {
            user.setPassword(passwordEncoder.encode(PasswordUtil.generatePassword(PasswordUtil.PasswordDifficulty.DIFFICULTY_USER)));
        }
        insert(user);
        return user;
    }

    public Optional<User> getByLoginOrEmail(String login) {
        return Optional.of(Optional.ofNullable(getUserByEmail(login))
                        .or(() -> Optional.ofNullable(getUserByLogin(login))))
                .orElse(Optional.empty());
    }

    public void insert(User user) {
        userMapper.insert(user);
    }

    public boolean userExist(String login) {
        return userMapper.userExist(login);
    }

    public User getUserByLogin(String login) {
        return userMapper.getUserByLogin(login);
    }

    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }
}
