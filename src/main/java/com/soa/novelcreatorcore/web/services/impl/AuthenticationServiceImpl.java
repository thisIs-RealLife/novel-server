package com.soa.novelcreatorcore.web.services.impl;

import com.soa.novelcreatorcore.helper.TgHelper;
import com.soa.novelcreatorcore.repository.model.User;
import com.soa.novelcreatorcore.repository.service.UserRepository;
import com.soa.novelcreatorcore.config.security.service.GenerateJwtService;
import com.soa.novelcreatorcore.web.model.auth.rp.TgInitDataRp;
import com.soa.novelcreatorcore.web.model.auth.rq.TgInitDataRq;
import com.soa.novelcreatorcore.web.model.auth.rq.tg.WebAppUser;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl {

    @Value("${tg.algorithm}")
    private String HMAC_SHA256;
    @Value("${tg.api-key}")
    private String BOT_TOKEN;
    private final GenerateJwtService generateJwtService;
    private final UserRepository userRepository;

    public TgInitDataRp authenticate(@Nonnull TgInitDataRq tgInitDataRq) throws NoSuchAlgorithmException, InvalidKeyException {
        TgHelper.validateRequired(tgInitDataRq.getRowInitData(), HMAC_SHA256, BOT_TOKEN);

        final WebAppUser webAppUser = tgInitDataRq.getUser();

        boolean exist = userRepository.userExist(webAppUser.getUsername());

        if (exist) {
            User user = userRepository.getByLoginOrEmail(webAppUser.getUsername()).orElseThrow(() -> new RuntimeException("UserNot found"));
            return new TgInitDataRp(generateJwtService.generateToken(user));
        } else {
            User newUser = userRepository.createNewUser(User.builder()
                    .login(webAppUser.getUsername())
                    .build()
            );
            return new TgInitDataRp(generateJwtService.generateToken(newUser));
        }
    }
}
