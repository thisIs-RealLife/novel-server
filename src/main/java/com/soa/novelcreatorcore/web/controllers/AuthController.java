package com.soa.novelcreatorcore.web.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Value("${tg.algorithm}")
    private String HMAC_SHA256;
    @Value("${tg.api-key}")
    private String BOT_TOKEN;
    private static final String CONSTANT_STRING = "WebAppData";


    @PostMapping("/tg")
    public ResponseEntity<String> authenticate(@RequestParam Map<String, String> params) throws NoSuchAlgorithmException, InvalidKeyException {
        boolean b = validateTelegramAuth(params);
        System.out.println("b: " + b);
        return ResponseEntity.ok("OK");
    }

    private boolean validateTelegramAuth(Map<String, String> params) throws NoSuchAlgorithmException, InvalidKeyException {
        String hash = params.remove("hash");

        // Step 1: Sort params by key
        String dataCheckString = params.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("\n"));
        // Step 2: Compute HMAC-SHA256 of the data check string
        Mac mac = Mac.getInstance(HMAC_SHA256);
        SecretKeySpec secretKeyForToken = new SecretKeySpec(CONSTANT_STRING.getBytes(StandardCharsets.UTF_8), HMAC_SHA256);
        mac.init(secretKeyForToken);
        byte[] key = mac.doFinal(BOT_TOKEN.getBytes(StandardCharsets.UTF_8));

        // Step 3: Compute HMAC-SHA256 of the data check string using the generated key
        SecretKeySpec secretKeyForData = new SecretKeySpec(key, HMAC_SHA256);
        mac.init(secretKeyForData);
        byte[] hmacData = mac.doFinal(dataCheckString.getBytes(StandardCharsets.UTF_8));

        // Step 4: Compare the result with the hash from params
        String hmacHex = bytesToHex(hmacData);
        return hmacHex.equals(hash);
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}
