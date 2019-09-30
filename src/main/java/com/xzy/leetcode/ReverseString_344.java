package com.xzy.leetcode;

public class ReverseString_344 {

    public static void main(String[] args) {
        System.out.println(reverseString("A man, a plan, a canal: Panama"));
    }

    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
