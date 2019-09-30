package com.xzy.leetcode;

public class LongestPalindromicSubstring_5 {

    private int low, maxLen;

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(low, low + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        j++;
        k--;
        if (maxLen < k - j + 1) {
            maxLen = k - j + 1;
            low = j;
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring_5 palindromic = new LongestPalindromicSubstring_5();
        String str = palindromic.longestPalindrome("babad");
        System.out.println(str);
    }

}
