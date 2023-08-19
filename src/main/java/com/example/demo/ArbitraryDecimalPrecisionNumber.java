package com.example.demo;

import java.util.ArrayList;

public class ArbitraryDecimalPrecisionNumber {
    private ArrayList<Integer> integerPart; // Digits of the integer part
    private ArrayList<Integer> decimalPart; // Digits of the decimal part
    private int sign; // 1 for positive, -1 for negative

    public ArbitraryDecimalPrecisionNumber() {
        integerPart = new ArrayList<>();
        integerPart.add(0);
        decimalPart = new ArrayList<>();
        sign = 1;
    }

    public ArbitraryDecimalPrecisionNumber(String number) {
        integerPart = new ArrayList<>();
        decimalPart = new ArrayList<>();
        int start = 0;
        if (number.charAt(0) == '-') {
            sign = -1;
            start = 1;
        } else {
            sign = 1;
        }

        int dotIndex = number.indexOf('.');
        if (dotIndex == -1) {
            dotIndex = number.length();
        }

        for (int i = dotIndex - 1; i >= start; i--) {
            integerPart.add(Integer.parseInt(String.valueOf(number.charAt(i))));
        }

        for (int i = dotIndex + 1; i < number.length(); i++) {
            decimalPart.add(Integer.parseInt(String.valueOf(number.charAt(i))));
        }
    }

    public void add(ArbitraryPrecisionNumber other) {
        // Perform addition logic here
        // Remember to handle carry
    }

    public void multiply(ArbitraryPrecisionNumber other) {
        // Perform multiplication logic here
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        if (sign == -1) {
            result.append("-");
        }

        for (int i = integerPart.size() - 1; i >= 0; i--) {
            result.append(integerPart.get(i));
        }

        if (!decimalPart.isEmpty()) {
            result.append(".");
            for (int digit : decimalPart) {
                result.append(digit);
            }
        }

        return result.toString();
    }
}
