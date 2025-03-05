package com.xzy.interview;

public class LeetCode_9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] charArray = String.valueOf(x).toCharArray();
        int start = 0, end = charArray.length - 1;
        while (start < end) {
            if (charArray[start] != charArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
