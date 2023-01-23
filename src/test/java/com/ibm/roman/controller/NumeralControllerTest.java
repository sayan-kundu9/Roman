package com.ibm.roman.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NumeralControllerTest {

    @InjectMocks
    NumeralController numeralController;

    @Mock
    Converter converter;

    @Test
    void numeralToNumeric1() {
        when(converter.convertNumeral("V")).thenReturn(5);
        assertEquals("V converted to number, result : 5", numeralController.numeralToNumeric("V"));
    }

    @Test
    void numeralToNumeric2() {
        when(converter.convertNumeral("Z")).thenReturn(0);
        assertEquals("Invalid input", numeralController.numeralToNumeric("Z"));
    }

    @Test
    void numericToNumeral1() {
        when(converter.convertNumeric("5")).thenReturn("V");
        assertEquals("5 converted to roman numeral, result : V", numeralController.numericToNumeral("5"));
    }

    @Test
    void numericToNumeral2() {
        when(converter.convertNumeric("-5")).thenReturn(null);
        assertEquals("Invalid input", numeralController.numericToNumeral("-5"));
    }
}