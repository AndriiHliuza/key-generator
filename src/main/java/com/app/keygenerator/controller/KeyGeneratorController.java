package com.app.keygenerator.controller;

import com.app.keygenerator.service.KeyGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KeyGeneratorController {
    private final KeyGeneratorService keyGeneratorService;

    @GetMapping("/key/aes")
    public String generateAESKey() {
        return keyGeneratorService.generateAESKey();
    }

    @GetMapping("/key/hmac")
    public String generateHMACSHA256CodeForJwt() { //hmac sha-256 code
        return keyGeneratorService.generateHMACSHA256CodeForJwt();
    }
}
