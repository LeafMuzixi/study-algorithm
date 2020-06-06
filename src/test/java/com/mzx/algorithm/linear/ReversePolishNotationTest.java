package com.mzx.algorithm.linear;

import org.junit.jupiter.api.Test;

/**
 * 逆波兰表达式
 */
public class ReversePolishNotationTest {
    @Test
    public void polishNotation() {
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        System.out.println(calculate(notation));
    }

    /**
     * 计算逆波兰表达式值
     *
     * @param notation {@link String}
     * @return 计算结果值
     */
    private double calculate(String[] notation) {
        Stack<Double> stack = new Stack<>();
        for (String s : notation) {
            double num1;
            double num2;
            switch (s) {
                case "+":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num1 + num2);
                    break;
                case "-":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 - num1);
                    break;
                case "*":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num1 * num2);
                    break;
                case "/":
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num2 / num1);
                    break;
                default:
                    stack.push(Double.valueOf(s));
            }
        }
        return stack.pop();
    }
}
