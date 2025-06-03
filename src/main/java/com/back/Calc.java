package com.back;

public class Calc {
    /**
     * 스택 자료구조 사용 X, 재귀를 사용
     * 1. 연산식을 먼저 전부 나눈다.  [20, +, 10, +, 5, *, 2]
     * 2. 앞에서 부터 하나씩 확인 (인덱스 < 위 배열 길이)
     * 3. 괄호가 최우선순위이므로 덧,뺄셈 -> 곱셈 -> 괄호 순으로 호출되어야한다.
     * 4. 괄호를 만나면 내부 연산식을 계산해야하므로 덧,뺄셈 연산 재귀 호출
     */
    static String[] split;
    static int curIndex;

    public static int run(String input) {
        input = input.replace("(", "( ");
        input = input.replace(")", " )");
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
            if (operator.equals(")")) {
                break;
            }
        }
        return sum;
    }

    public static int multiple() {
        int curNum = calParentheses();
        curIndex++;
        while (curIndex < split.length) {
            String operator = split[curIndex];
            if (!operator.equals("*")) {
                break;
            }
            curIndex++;
            curNum *= calParentheses();
            curIndex++;
        }
        return curNum;
    }

    public static int calParentheses() {
        String curStr = split[curIndex];
        if (curStr.equals("(")) {
            curIndex++;
            return addOrSub();
        }
        if (curStr.equals("-(")) {
            curIndex++;
            return addOrSub() * -1;
        }
        return Integer.parseInt(curStr);
    }
}