package com.example;

import java.util.Arrays;

/**
 * @author Angela Gustafsson, anggus-1
 */

public class Calculator {
    static int add(String numbers) {
        String[] split = numbers.split(",|\n");
        return Arrays.stream(split).filter(s -> !s.isEmpty()).map(Integer::parseInt).reduce(0,Integer::sum);

    }
}
