package com.xzy.leetcode._301_600;

import com.alibaba.fastjson.JSON;

public class Solution_344 {

    public static void main(String[] args) {
        System.out.println(reverseString("A man, a plan, a canal: Panama"));
        char[] s = {'h', 'e', 'i', 'l', 'o'};
        reverseString(s);
        System.out.println(JSON.toJSONString(s));
    }

    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }
}
