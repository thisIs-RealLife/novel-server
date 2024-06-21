package com.soa.novelcreatorcore.helper;

import jakarta.annotation.Nonnull;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.stream.Collectors;

public class TgHelper {
    private static final String CONSTANT_STRING = "WebAppData";

    public static void validateRequired(@Nonnull Map<String, String> params, @Nonnull String algorithm, @Nonnull String token) throws NoSuchAlgorithmException, InvalidKeyException {
       if (!validateTgData(params, algorithm, token)) {
           throw new RuntimeException("Data not validation");
       }
    }

    public static boolean validateTgData(@Nonnull Map<String, String> params, @Nonnull String algorithm, @Nonnull String token) throws NoSuchAlgorithmException, InvalidKeyException {
        String hash = params.remove("hash");
        String dataCheckString = params.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("\n"));
        Mac mac = Mac.getInstance(algorithm);
        SecretKeySpec secretKeyForToken = new SecretKeySpec(CONSTANT_STRING.getBytes(StandardCharsets.UTF_8), algorithm);
        mac.init(secretKeyForToken);
        byte[] key = mac.doFinal(token.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec secretKeyForData = new SecretKeySpec(key, algorithm);
        mac.init(secretKeyForData);
        byte[] hmacData = mac.doFinal(dataCheckString.getBytes(StandardCharsets.UTF_8));
        StringBuilder result = new StringBuilder();
        for (byte b : hmacData) {
            result.append(String.format("%02x", b));
        }
        String hmacHex = result.toString();
        return hmacHex.equals(hash);
    }

}
