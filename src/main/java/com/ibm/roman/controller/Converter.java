package com.ibm.roman.controller;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * this utility class converts a number to roman numerals and vice versa
 */
@Service
public class Converter {

    private final Map<Character, Integer> roman = new HashMap<Character, Integer>()
    {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    private final int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    private final String[] romanLiterals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

    /**
     * accepts a roman numeral string and converts to number
     * @param numeral
     * @return
     */
    public Integer convertNumeral(String numeral) {
        if (isRomanNumeral(numeral)) {
            int sum = 0;
            int n = numeral.length();
            for(int i = 0; i < n; i++)
            {
                if (i != n - 1 && roman.get(numeral.charAt(i)) < roman.get(numeral.charAt(i + 1)))
                {
                    sum += roman.get(numeral.charAt(i + 1)) - roman.get(numeral.charAt(i));
                    i++;
                } else {
                    sum += roman.get(numeral.charAt(i));
                }
            }return sum;
        } return 0;
    }

    /**
     * Accepts a number and converts to roman numeral
     * @param number
     * @return
     */
    public String convertNumeric(String number) {
        if (isNumeric(number)) {
            int num = Integer.parseInt(number);
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < values.length; i++) {
                while (num >= values[i]) {
                    num -= values[i];
                    s.append(romanLiterals[i]);
                }
            }
            return s.toString();
        } return null;
    }

    /**
     * Validates a string containing a positive number
     * @param number
     * @return
     */
    public boolean isNumeric(String number) {
        try {
            return Integer.parseInt(number) > 0;
        } catch (Exception e) {
            System.err.println("Invalid numeric");
            return false;
        }
    }

    /**
     * Validates a string if it'sroman numeral
     * @param numeral
     * @return
     */
    public boolean isRomanNumeral(String numeral) {

        if (numeral == null || numeral.trim().equals("")) {
            System.out.println("Numeral is null or empty");
            return false;
        } else {
            Arrays.asList(numeral.toCharArray()).forEach(c -> Arrays.asList(romanLiterals).contains(c.toString()));
            for(int i = 0; i < numeral.length(); i++)
            {
                if (!Arrays.asList(romanLiterals).contains(Character.toString(numeral.charAt(i)))) {
                    System.out.println("not a valid numeral");
                    return false;
                }
            }
            return true;
        }
    }

    public int add(int number) {
            return number + number;
    }
}
