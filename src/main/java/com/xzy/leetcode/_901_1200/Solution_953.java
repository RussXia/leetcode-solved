package com.xzy.leetcode._901_1200;

/**
 * @author xiazhengyue
 * @since 2021-04-09
 */
public class Solution_953 {

    public static void main(String[] args) {
        String[] words = {"kuvp", "q"};
        System.out.println(isAlienSorted(words, "ngxlkthsjuoqcpavbfdermiywz"));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1) {
            return true;
        }
        for (int i = 0; i < words.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
                if (order.indexOf(words[i].charAt(j)) > order.indexOf(words[i + 1].charAt(j))) {
                    return false;
                }
                if (order.indexOf(words[i].charAt(j)) < order.indexOf(words[i + 1].charAt(j))) {
                    flag = false;
                    break;
                }
            }
            //words[i]包含了words[i+1]，且word[i]长度大于words[i+1]
            if (flag && words[i].length() > words[i + 1].length()) {
                return false;
            }
        }
        return true;
    }
}
