package com.xzy.leetcode._1201_;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User: RuzzZZ
 * Date: 2021/9/23
 * Time: 13:30
 */
public class Solution_1239 {

    public static void main(String[] args) {
        Solution_1239 solution = new Solution_1239();
        List<String> arr = Lists.newArrayList("un", "iq", "ue");      //4
        //List<String> arr = Lists.newArrayList("cha", "r", "act", "ers");     //6
        //List<String> arr = Lists.newArrayList("abcdefghijklmnopqrstuvwxyz");      //26
        //List<String> arr = Lists.newArrayList("yy", "bkhwmpbiisbldzknpm");        //0
        //List<String> arr = Lists.newArrayList("a", "abc", "d", "de", "def");        //6
        //List<String> arr = Lists.newArrayList("s", "sa", "m", "e", "mu", "ei");        //6
        System.out.println(solution.maxLength(arr));
    }

    /**
     * dp[n] = fn[dp[n-1]]
     * @param arr
     * @return
     */
    public int maxLength(List<String> arr) {
        //filter duplicates first
        arr = arr.stream().filter(this::isDistinct).collect(Collectors.toList());
        if (arr.size() == 1) {
            return arr.get(0).length();
        }
        //recursive
        return dfs(arr, "", 0, 0);
    }


    public int dfs(List<String> arr, String temp, int idx, int max) {
        boolean isDistinct = isDistinct(temp);
        if (isDistinct) {
            max = Math.max(temp.length(), max);
        }
        if (!isDistinct || arr.size() == idx) {
            return max;
        }
        for (int i = idx; i < arr.size(); i++) {
            max = Math.max(dfs(arr, temp + arr.get(i), i + 1, max), max);
        }
        return max;
    }

    public boolean isDistinct(String str) {
        if (str.length() > 26) {
            return false;
        }
        char[] chars = str.toCharArray();
        int[] dicts = new int[26];
        for (char c : chars) {
            dicts[c - 'a'] += 1;
            if (dicts[c - 'a'] > 1) {
                return false;
            }
        }
        return true;
    }
}
