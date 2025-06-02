package com.back;

public class Calc {
    public static int run(String input) {
        String[] split = input.split(" ");
        int sum = Integer.parseInt(split[0]);
        int curIndex = 1;
        while (curIndex < split.length) {
            sum = operation(sum, Integer.parseInt(split[curIndex + 1]), split[curIndex]);
            curIndex += 2;
        }
        return sum;
    }

    public static int operation(int sum, int num, String operator) {
        return switch (operator) {
            case "+" -> sum + num;
            case "-" -> sum - num;
            case "*" -> sum * num;
            default -> 0;
        };
    }
}