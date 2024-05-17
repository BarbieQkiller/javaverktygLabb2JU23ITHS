package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Angela Gustafsson, anggus-1
 */
class CalculatorTest {

    @Test
    void step1() {

        assertEquals(0, Calculator.add(""));
        assertEquals(1, Calculator.add("1"));
        assertEquals(3, Calculator.add("1,2"));

    }
    @Test
    void step2() {

        assertEquals(12, Calculator.add("3,4,5"));
    }
    @Test
    void step3() {

        assertEquals(6, Calculator.add("1\n2,3"));

    }
    @Test
    void step4() {
        assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    void step5() {
        String input = "5,-1,6,-3";
        CalculatorException exception = assertThrows(CalculatorException.class, () -> {
            Calculator.add(input);
        });

        assertTrue(exception.getMessage().contains("Negatives not allowed"));
        assertTrue(exception.getMessage().contains("-1"));
        assertTrue(exception.getMessage().contains("-3"));
    }
    @Test
    void step6() {
        String input = "2,1001,6,1000";
        try {
            int result = Calculator.add(input);
            assertEquals(1008, result);
        } catch (CalculatorException e) {
            fail("Exception should not be thrown for this test.");
        }
    }
    @Test
    void step7() {
        String input = "//[***]\n1***2***3";
        assertEquals(6, Calculator.add(input));
    }
    @Test
    void step8() {
        String input = "//[*][%]\n1*2%3";
        assertEquals(6, Calculator.add(input));
    }
    @Test
    void step9() {
        String input = "//[***][%%][:::][!!]\n1***2%%3:::4!!5";
        assertEquals(15, Calculator.add(input), "Should sum up to 15 with ***, %%, :::, and !! as delimiters.");
    }

}