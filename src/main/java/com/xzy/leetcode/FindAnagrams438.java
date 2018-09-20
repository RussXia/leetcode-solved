package com.xzy.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams438 {

    public static void main(String[] args) {

        String str = "dsadgfdgfd";
        System.out.println(str.indexOf("gf"));
        System.out.println(str.indexOf("opii"));


    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (p == null || p.length() == 0 || s == null || s.length() == 0 || s.length() < p.length()) {
            return new ArrayList<>();
        }
        char[] charArr = new char[p.length()];


//        Set<String> diffStr = allConsistStr(p);
//        return diffStr.stream().map(s::indexOf)
//                .filter(integer -> integer > 0)
//                .collect(Collectors.toList());
        return new ArrayList<>();
    }
}
