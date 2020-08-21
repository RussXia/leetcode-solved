package com.xzy.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiazhengyue
 * @since 2019-01-23
 */
public class Solution_916 {

    public static void main(String[] args) {
        String[] A = {"amazon", "apple", "facebook", "google", "com/xzy/leetcode"};
        String[] B = {"e", "oo"};
        wordSubsets(A, B).forEach(System.out::println);
//        String[] C = {"amazon", "apple", "facebook", "google", "leetcode"};
//        String[] D = {"lo", "eo"};
//        wordSubsets(C, D).forEach(System.out::println);
    }

    public static List<String> wordSubsets(String[] A, String[] B) {
        //统计每个字符出现的最高次数
        int[] uni = new int[26], tmp;
        List<String> result = new ArrayList<>();
        for (String strB : B) {
            tmp = count(strB);
            for (int i = 0; i < 26; i++) {
                uni[i] = Math.max(tmp[i], uni[i]);
            }
        }
        for (String strA : A) {
            tmp = count(strA);
            for (int i = 0; i < 26; i++) {
                if (tmp[i] < uni[i])
                    break;
                if (i == 25)
                    result.add(strA);
            }
        }
        return result;
    }

    private static int[] count(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }
        return count;
    }
}
