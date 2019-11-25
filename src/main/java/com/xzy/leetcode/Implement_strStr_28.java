package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2019-11-20
 */
public class Implement_strStr_28 {

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
