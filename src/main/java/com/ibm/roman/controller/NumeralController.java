package com.ibm.roman.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeralController {

    @Autowired
    Converter converter;

    /**
     * this endpoint accepts a roman numeral string and converts to number
     * @param numeral
     * @return
     */
    @GetMapping("/numeral")
    public String numeralToNumeric(@RequestParam(value = "input") String numeral) {

        int result = converter.convertNumeral(numeral);
        return (result != 0)? numeral + " converted to number, result : " + result : "Invalid input";
    }

    /**
     * this endpoint accepts a number and converts to roman numeral
     * @param numeric
     * @return
     */
    @GetMapping("/numeric")
    public String numericToNumeral(@RequestParam(value = "input") String numeric) {

        String result = converter.convertNumeric(numeric);
        return (result != null)? numeric + " converted to roman numeral, result : " + result : "Invalid input";
    }

    @GetMapping("/add")
    public String add(@RequestParam(value = "input") int n) {

        return  String.valueOf("added"+converter.add(n));
    }
}
