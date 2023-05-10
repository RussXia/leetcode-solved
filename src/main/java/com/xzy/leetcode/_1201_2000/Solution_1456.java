package com.xzy.leetcode._1201_2000;

/**
 * User: RuzzZZ
 * Date: 2023/5/5
 * Time: 10:47
 */
public class Solution_1456 {

    public static void main(String[] args) {
        System.out.println(maxVowels("weallloveyou", 7));
    }


    public static int maxVowels(String s, int k) {
        int windowVowel = 0, maxVowels = 0;
        int start = 0, end = start + k;
        char[] chars = s.toCharArray();
        if (end > chars.length) {
            return maxVowels;
        }
        // 构建窗口内元音字母数量
        for (int i = start; i < end; i++) {
            if (isVowel(chars[i])) windowVowel++;
        }
        maxVowels = Math.max(windowVowel, maxVowels);

        // 遍历字符串
        start++;
        end++;
        while (start > 0 && end <= chars.length) {
            if (isVowel(chars[start - 1])) windowVowel--;
            if (isVowel(chars[end - 1])) windowVowel++;
            maxVowels = Math.max(windowVowel, maxVowels);
            start++;
            end++;
            if (maxVowels == k) return maxVowels;
        }
        return maxVowels;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
