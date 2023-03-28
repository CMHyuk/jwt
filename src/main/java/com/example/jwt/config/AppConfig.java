package com.example.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Base64;

@Data
@ConfigurationProperties(prefix = "jwt")
public class AppConfig {

    private byte[] jwtKey;

    public void setJwtKey(String jwtKey) {
        Base64.getDecoder().decode(jwtKey);
    }

    public byte[] getJwtKey() {
        return jwtKey;
    }
}
