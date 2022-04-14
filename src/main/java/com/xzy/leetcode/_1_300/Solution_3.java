package com.xzy.leetcode._1_300;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class Solution_3 {

    public static void main(String[] args) {
        //String str1 = "aabaab!bb";
        //String str1 = "abcabcbb";
        //String str1 = "";
        String str1 = "bbbbb";
        //String str1 = "pwwkew";
        //String str1 = "dvdf";
        System.out.println(lengthOfLongestSubstring2(str1));
        System.out.println(lengthOfLongestSubstring3(str1));
    }


    public static int lengthOfLongestSubstring3(String s) {
        //ascii码取值范围
        int[] dict = new int[256];

        int max = 0, start = 0, end = 0;
        while (end < s.length()) {
            if (dict[s.charAt(end)] > 0 && dict[s.charAt(end)] > start) {
                max = Math.max((end - start), max);
                start = dict[s.charAt(end)];
                dict[s.charAt(end)] = end + 1;
                end++;
            } else {
                max = Math.max((end - start + 1), max);
                dict[s.charAt(end)] = end + 1;
                end++;
            }
        }
        return max;
    }


    public static int lengthOfLongestSubstring2(String s) {
        int[] m = new int[256];
        int res = 0, left = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (m[s.charAt(i)] == 0 || m[s.charAt(i)] < left) {
                res = Math.max(res, (i - left + 1));
            } else {
                left = m[s.charAt(i)];
            }
            m[s.charAt(i)] = i + 1;
        }
        return res;
    }


    /**
     * plan A 暴力
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        Set<Integer> lengthSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String testStr = s.substring(i, j);
                if (checkDistinct(testStr)) {
                    lengthSet.add(testStr.length());
                } else {
                    break;
                }

            }
        }
        return lengthSet.size() == 1 ? 1 : lengthSet.stream().max(Integer::compareTo).orElse(1);
    }


    private static boolean checkDistinct(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        return set.size() == str.length();
    }
}
