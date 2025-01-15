package com.xzy.leetcode._1_300;

public class Solution_13 {



    public int romanToInt(String s) {
        s.replace("IV", "a");
        s.replace("IX", "b");
        s.replace("XL", "c");
        s.replace("XC", "d");
        s.replace("CD", "e");
        s.replace("CM", "f");
        int result = 0;
        for (char c : s.toCharArray()) {
            result += which(c);
        }
        return result;
    }

    private int which(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            case 'a':
                return 4;
            case 'b':
                return 9;
            case 'c':
                return 40;
            case 'd':
                return 90;
            case 'e':
                return 400;
            case 'f':
                return 900;
            default:
                return 0;
        }
    }
}
