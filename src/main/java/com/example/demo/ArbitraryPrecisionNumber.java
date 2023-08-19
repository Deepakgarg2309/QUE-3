package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;

public class ArbitraryPrecisionNumber {
    private ArrayList<Integer> digits;
    private int sign; // 1 for positive, -1 for negative

    public ArbitraryPrecisionNumber() {
        digits = new ArrayList<>();
        digits.add(0);
        sign = 1;
    }

    public ArbitraryPrecisionNumber(String number) {
        digits = new ArrayList<>();
        int start = 0;
        if (number.charAt(0) == '-') {
            sign = -1;
            start = 1;
        } else {
            sign = 1;
        }

        for (int i = number.length() - 1; i >= start; i--) {
            digits.add(Integer.parseInt(String.valueOf(number.charAt(i))));
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

        for (int i = digits.size() - 1; i >= 0; i--) {
            result.append(digits.get(i));
        }

        return result.toString();
    }


}
