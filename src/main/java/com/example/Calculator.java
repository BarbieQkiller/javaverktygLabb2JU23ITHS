package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Angela Gustafsson, anggus-1
 */
public class Calculator {
    static int add(String numbers) {
        String defaultDelimiter = ",|\n";
        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf('\n');
            defaultDelimiter = numbers.substring(2, delimiterEnd).trim();
            if (defaultDelimiter.startsWith("[")) {
                defaultDelimiter = defaultDelimiter.substring(1, defaultDelimiter.length() - 1);
                defaultDelimiter = Arrays.stream(defaultDelimiter.split(Pattern.quote("]["))).map(Pattern::quote).collect(Collectors.joining("|"));
            }
            numbers = numbers.substring(delimiterEnd + 1);
        }
        String[] split = numbers.split(defaultDelimiter);
        List<Integer> integers = Arrays.stream(split).filter(s -> !s.isEmpty()).map(Integer::parseInt).toList();

        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (int number : integers) {
            if (number < 0) {
                negatives.add(number);
            } else if (number <= 1000) {
                sum += number;
            }
        }

        if (!negatives.isEmpty()) {
            throw new CalculatorException("Negatives not allowed: " + negatives);
        }

        return sum;
    }

}
