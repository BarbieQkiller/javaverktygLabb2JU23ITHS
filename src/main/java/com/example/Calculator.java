package com.example;

import java.util.Arrays;

/**
 * @author Angela Gustafsson, anggus-1
 */
/*Step 2
Allow the Add method to handle an unknown amount of numbers.
*/
public class Calculator {
    static int add(String numbers) {
        String[] split = numbers.split(",");
        return Arrays.stream(split).filter(s -> !s.isEmpty()).map(Integer::parseInt).reduce(0,Integer::sum);

    }
}
