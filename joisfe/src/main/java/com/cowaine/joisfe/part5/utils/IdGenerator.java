package com.cowaine.joisfe.part5.utils;

import java.util.Random;

public class IdGenerator {

    private static final Integer bound = 1000;

    public static Long create() {
        Random random = new Random();
        return System.currentTimeMillis() * bound + random.nextInt(bound);
    }
}
