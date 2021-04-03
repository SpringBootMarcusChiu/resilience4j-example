package com.marcuschiu.resilience4jexample.util;

import java.util.Arrays;

public class Util {
    public static void printStackTrace() {
        Arrays.stream(Thread.currentThread().getStackTrace()).forEach(ste -> {
            System.out.println(ste.toString());
        });
    }
}
