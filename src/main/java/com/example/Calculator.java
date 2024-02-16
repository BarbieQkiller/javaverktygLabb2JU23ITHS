package com.example;

import java.util.Arrays;

/**
 * @author Angela Gustafsson, anggus-1
 */
/*Create a simple String calculator with a method signature:

int Add(string numbers)
The method can take up to two numbers, separated by commas, and will return their sum.

For example “” or “1” or “1,2” as inputs.

For an empty string it will return 0.
*/
public class Calculator {
    static int add(String numbers) {
        String[] split = numbers.split(",");
        return Arrays.stream(split).filter(s -> !s.isEmpty()).map(Integer::parseInt).reduce(0,Integer::sum);

    }
}
