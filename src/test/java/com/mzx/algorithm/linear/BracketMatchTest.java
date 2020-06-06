package com.mzx.algorithm.linear;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 括号匹配
 */
public class BracketMatchTest {
    @Test
    public void match() {
        String str = "(上海(长安)())";
        assertTrue(isMatch(str));
    }

    /**
     * 判断字符串是否括号匹配
     *
     * @param str 字符串
     * @return true / false;
     */
    private boolean isMatch(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                Character character = stack.pop();
                if (character == null) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
