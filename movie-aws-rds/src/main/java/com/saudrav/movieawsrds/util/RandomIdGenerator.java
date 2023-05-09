package com.saudrav.movieawsrds.util;

import java.util.UUID;

public class RandomIdGenerator {
    public static int generateId() {
        return Math.abs(UUID.randomUUID().hashCode());
    }
}
