package com.back;

public class Calc {
    /**
     * 스택 자료구조 사용 X, 재귀를 사용
     * 1. 연산식을 먼저 전부 나눈다.  [20, +, 10, +, 5, *, 2]
     * 2. 앞에서 부터 하나씩 확인 - 인덱스 < 위 배열 길이
     * 3. 곱셈이 먼저 계산되어야하므로 덧,뺄셈 -> 곱셈을 호출해야 곱셈이 먼저 처리되고 돌아온다.
     */
    static String[] split;
    static int curIndex;

    public static int run(String input) {
        split = input.split(" ");
        curIndex = 0;
        return addOrSub();
    }

    public static int addOrSub() {
        int sum = multiple();
        while (curIndex < split.length) {
            String operator = split[curIndex];
            if (operator.equals("+")) {
                curIndex++;
                sum += multiple();
            }
            if (operator.equals("-")) {
                curIndex++;
                sum -= multiple();
            }
        }
        return sum;
    }

    public static int multiple() {
        int curNum = Integer.parseInt(split[curIndex]);
        curIndex++;
        while (curIndex < split.length) {
            String operator = split[curIndex];
            if (!operator.equals("*")) {
                break;
            }
            curNum *= Integer.parseInt(split[++curIndex]);
            curIndex++;
        }
        return curNum;
    }
}