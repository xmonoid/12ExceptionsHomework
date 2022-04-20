package com.tsystems.autotestuni.basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.tsystems.autotestuni.basic.BasicExceptions.convertStringToDoubleInPosition;
import static com.tsystems.autotestuni.basic.BasicExceptions.thousandToParameter;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicExceptionsTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void thousandToParameterTest() {
        Throwable throwable = assertThrows(AssertionError.class, () -> thousandToParameter(-1));
        assertEquals("Parameter should be positive", throwable.getMessage());
        throwable = assertThrows(IllegalArgumentException.class, () -> thousandToParameter(1_001));
        assertEquals("Parameter should be less than 1000", throwable.getMessage());
        throwable = assertThrows(ArithmeticException.class, () -> thousandToParameter(0));
        assertEquals("/ by zero", throwable.getMessage());
        assertEquals(1, thousandToParameter(1000));
        assertEquals(10, thousandToParameter(100));
        assertEquals(333, thousandToParameter(3));
        assertEquals(500, thousandToParameter(2));
        assertEquals(1000, thousandToParameter(1));
    }

    @Test
    void convertStringToDoubleInPositionTest() {
        outputStreamCaptor.reset();
        String[] strings = {};
        assertTrue(Double.valueOf(convertStringToDoubleInPosition(strings, 1)).isNaN());
        assertEquals("There is no such position in the passed array" + System.lineSeparator() +
                "Method has finished its job" + System.lineSeparator(), outputStreamCaptor.toString());

        outputStreamCaptor.reset();
        var strings2 = new String[] {"0.0", "a.a", "2.0"};
        assertTrue(Double.valueOf(convertStringToDoubleInPosition(strings2, 1)).isNaN());
        assertEquals("The string in the specified position cannot be converted to double" + System.lineSeparator() +
                "Method has finished its job" + System.lineSeparator(), outputStreamCaptor.toString());

        outputStreamCaptor.reset();
        var strings3 = new String[] {"a.a", "b.b", "2.2"};
        assertEquals(2.2, convertStringToDoubleInPosition(strings3, 2));
        assertEquals("Method has finished its job" + System.lineSeparator(), outputStreamCaptor.toString());
    }
}