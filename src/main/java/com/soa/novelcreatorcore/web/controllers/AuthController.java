package com.soa.novelcreatorcore.web.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.soa.novelcreatorcore.web.model.rp.TgInitDataRp;
import com.soa.novelcreatorcore.web.model.rq.TgInitDataRq;
import com.soa.novelcreatorcore.web.sevice.AuthenticationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/tg")
    public ResponseEntity<TgInitDataRp> authenticate(@RequestParam Map<String, String> params) throws NoSuchAlgorithmException, InvalidKeyException, JsonProcessingException {
       return ResponseEntity.ok(authenticationService.authenticate(new TgInitDataRq(params)));
    }
}
