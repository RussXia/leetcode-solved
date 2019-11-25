package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2019-11-22
 */
public class longest_common_prefix_14 {

    public static void main(String[] args) {
//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int min = strs[0].length();
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min) {
                index = i;
                min = strs[i].length();
            }
        }
        String shortest = strs[index];
        int length = shortest.length();
        for (int i = length; i > 0; i--) {
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(shortest.substring(0, i))) {
                    break;
                }
                if (j == strs.length - 1) {
                    return shortest.substring(0, i);
                }
            }
        }
        return "";
    }
}
