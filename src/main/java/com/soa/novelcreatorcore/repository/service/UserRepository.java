package com.soa.novelcreatorcore.repository.service;

import com.soa.novelcreatorcore.repository.mapper.UserMapper;
import com.soa.novelcreatorcore.repository.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserRepository {

    private final UserMapper userMapper;

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
