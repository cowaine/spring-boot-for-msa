package com.cowaine.corock.chapter05.util;

import com.cowaine.corock.chapter05.NumberGenerationAlgorithm;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class IdGenerator {

    private static final Integer BOUND = 10_000;

    public static Long create() {
        SecureRandom secureRandom = null;
        try {
            secureRandom = SecureRandom.getInstance(NumberGenerationAlgorithm.PKCS11.getAlgorithmName());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        return System.currentTimeMillis() * BOUND + secureRandom.nextInt(BOUND);
    }

}
