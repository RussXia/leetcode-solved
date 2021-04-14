package com.xzy.leetcode._1201_;

/**
 * @author xiazhengyue
 * @since 2021-04-07
 */
public class Solution_1455 {

    public static void main(String[] args) {
        String sentence = "i love eating burger";
        String searchWord = "burg";
        System.out.println(isPrefixOfWord(sentence, searchWord));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
