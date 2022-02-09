package com.xzy.leetcode._1201_2000;

/**
 * @author xiazhengyue
 * @since 2021-04-08
 */
public class Solution_1704 {

    public static void main(String[] args) {
        String s = "AbCdEfGh";
        System.out.println(halvesAreAlike(s));
    }

    public static boolean halvesAreAlike(String s) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i)) && i < s.length() / 2) {
                left++;
            }
            if (isVowel(s.charAt(i)) && i >= s.length() / 2) {
                right++;
            }
        }

        return left == right;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
