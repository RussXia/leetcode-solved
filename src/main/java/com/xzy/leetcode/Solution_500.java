package com.xzy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiazhengyue
 * @since 2019-01-25
 */
public class Solution_500 {

    private static String[] alphabet = {
            "QWERTYUIOPqwertyuiop",
            "ASDFGHJKLasdfghjkl",
            "ZXCVBNMzxcvbnm"
    };

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        for (String word : findWords(words)) {
            System.out.println(word);
        }
    }

    public static String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            int row = findRow(word.charAt(0));
            boolean found = true;
            for (char character : word.toCharArray()) {
                if (alphabet[row].indexOf(character) == -1) {
                    found = false;
                    break;
                }

            }
            if (found) {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    private static int findRow(char character) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i].indexOf(character) != -1) {
                return i;
            }
        }
        return -1;
    }
}
