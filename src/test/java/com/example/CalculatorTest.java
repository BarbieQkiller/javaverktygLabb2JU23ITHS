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
    void step4newlineAndcomma() {
        assertEquals(3, Calculator.add("//;\n1;2"));
    }
}