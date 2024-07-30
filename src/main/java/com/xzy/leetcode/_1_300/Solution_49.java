package com.xzy.leetcode._1_300;

import java.util.*;

/**
 * User: RuzzZZ
 * Date: 2024/7/29
 * Time: 14:48
 */
public class Solution_49 {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sortedStr = sortStr(str);
            List<String> list = map.getOrDefault(sortedStr, new ArrayList<>());
            list.add(str);
            map.put(sortedStr, list);
        }
        return new ArrayList<>(map.values());
    }

    private static String sortStr(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
