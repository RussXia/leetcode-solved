package com.xzy.leetcode._1_300;

/**
 * @author xiazhengyue
 * @since 2019-11-20
 */
public class Solution_38 {

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
    }

    public static String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            char[] chars = str.toCharArray();
            char flag = chars[0];
            int count = 1;
            for (int j = 0; j < chars.length - 1; j++) {
                if (chars[j] == chars[j + 1]) {
                    count++;
                } else {
                    temp.append(count).append(String.valueOf(flag));
                    flag = chars[j + 1];
                    count = 1;
                }
            }
            temp.append(count).append(String.valueOf(flag));
            str = temp.toString();
        }
        return str;
    }

}
