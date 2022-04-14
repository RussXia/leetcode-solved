package com.xzy.leetcode._301_600;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * User: RuzzZZ
 * Date: 2022/2/10
 * Time: 14:39
 */
public class Solution_567 {


    public boolean checkInclusion(String s1, String s2) {
        // count s1 frequency
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < s1.toCharArray().length; i++) {
            Integer count = dict.getOrDefault(s1.charAt(i), 0) + 1;
            dict.put(s1.charAt(i), count);
        }
        // two pointer window compare to s2
        Map<Character, LinkedList<Integer>> countMap = new HashMap<>();
        int start = 0, end = 0, length = s1.length();
        while (end < s2.length() && (end - start + 1) <= length) {
            if (dict.getOrDefault(s2.charAt(end), 0) == 0) { //some character not shown in s1
                end++;
                start = end;
                countMap = new HashMap<>();
            } else {
                LinkedList<Integer> characters = countMap.getOrDefault(s2.charAt(end), new LinkedList<>());
                characters.add(end);
                countMap.put(s2.charAt(end), characters);
                if (dict.getOrDefault(s2.charAt(end), 0) < characters.size()) {  //the frequency of character is more the s1
                    start = characters.getFirst() + 1;
                }

            }
        }
        return (end - start + 1) == length;
    }
}
