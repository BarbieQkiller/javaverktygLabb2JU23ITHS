package com.example;

import java.util.Arrays;

/**
 * @author Angela Gustafsson, anggus-1
 */

/**
  Support different delimiters:

 To change a delimiter, the beginning of the string will contain a separate line that looks like this:
 “//[delimiter]\n[numbers…]” for example “//;\n1;2” should return three where the default delimiter is ‘;’.

  The first line is optional. All existing scenarios should still be supported.
 */
public class Calculator {
    static int add(String numbers) {
        String defaultDelimiter =",|\n";
        if (numbers.startsWith("//")){
            defaultDelimiter = numbers.substring(2).split("\n")[0];
            numbers = numbers.split("\n", 2)[1];
        }
        String[] split = numbers.split(defaultDelimiter);
        return Arrays.stream(split).filter(s -> !s.isEmpty()).map(Integer::parseInt).reduce(0,Integer::sum);

    }
}
