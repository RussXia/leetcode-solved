package com.xzy.leetcode;

import java.util.Map;
import java.util.stream.Collectors;

public class ValidAnagram_242 {


    public static void main(String[] args) {
        String s = "hello";
        System.out.println(isAnagram2(s, "olleh"));
        System.out.println(isAnagram2(s, "fdfsafd"));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Integer, Long> counterS = new StringBuilder(s).chars().sorted().boxed().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        Map<Integer, Long> counterT = new StringBuilder(t).chars().sorted().boxed().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        return counterS.size() == counterT.size() && counterS.keySet().stream().allMatch(key -> counterS.get(key).equals(counterT.get(key)));
    }

    public static boolean isAnagram2(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
