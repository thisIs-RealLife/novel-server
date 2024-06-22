package com.soa.novelcreatorcore.web.controllers;

import com.soa.novelcreatorcore.web.model.rp.TgInitDataRp;
import com.soa.novelcreatorcore.web.model.rq.TgInitDataRq;
import com.soa.novelcreatorcore.web.sevice.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/tg")
    public ResponseEntity<TgInitDataRp> authenticate(@RequestParam Map<String, String> params) throws NoSuchAlgorithmException, InvalidKeyException {
        return ResponseEntity.ok(authenticationService.authenticate(new TgInitDataRq(params)));
    }
}
