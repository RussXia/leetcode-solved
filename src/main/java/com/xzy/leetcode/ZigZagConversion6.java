package com.xzy.leetcode;

public class ZigZagConversion6 {

    public String convert(String s, int numRows) {
        // TODO: 2018/7/27
        if (s.length() == 1) {
            return s;
        }
        int column = s.length() / numRows + 1;
        char[][] result = new char[numRows][];
        int indexStr = 0, i = 0, j = 0;
        while (indexStr < s.length()) {
            result[i][j] = s.charAt(indexStr);
        }
        return null;
    }

    public static void main(String[] args) {
        char[] charArr = new char[100];
        charArr[0] = 't';
        charArr[3] = 'e';
        charArr[5] = 's';
        charArr[10] = 't';
        String str1 = new String(charArr).trim();
        str1 = str1.replaceAll("\\s+","");
        System.out.println(str1);
    }
}
