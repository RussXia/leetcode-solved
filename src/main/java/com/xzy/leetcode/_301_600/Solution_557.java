package com.xzy.leetcode._301_600;

/**
 * User: RuzzZZ
 * Date: 2022/2/2
 * Time: 19:46
 */
public class Solution_557 {

    public static void main(String[] args) {
        Solution_557 solution_557 = new Solution_557();
        String s = "Let's take LeetCode contest";
        System.out.println(solution_557.reverseWords(s));
    }

    public String reverseWords(String s) {
        int first = 0, second = 0;
        for (; first < s.length() && second < s.length(); ) {
            if (s.charAt(second) == ' ') {
                //switch
                s = reverseWords(s, first, second - 1);
                first = second + 1;
                second = first;
            } else {
                second++;
            }
        }
        if (second != first) {
            //switch
            s = reverseWords(s, first, second-1);
        }
        return s;
    }

    public String reverseWords(String str, int start, int end) {
        char[] s = str.toCharArray();
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        return new String(s);
    }
}
