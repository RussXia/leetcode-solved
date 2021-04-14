package com.xzy.leetcode._601_900;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution_884 {

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(uncommonFromSentences("this apple is sweet", "this apple is sour")));
    }

    public static String[] uncommonFromSentences(String A, String B) {
        String[] strArrA = A.split(" ");
        List<String> listA = Arrays.stream(strArrA).collect(Collectors.toList());
        String[] strArrB = B.split(" ");
        List<String> listB = Arrays.stream(strArrB).collect(Collectors.toList());

        List<String> multiElementA = listA.stream().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<String> multiElementB = listB.stream().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<String> collectA = listA.stream().filter(str -> !listB.contains(str) && !multiElementA.contains(str)).collect(Collectors.toList());
        List<String> collectB = listB.stream().filter(str -> !listA.contains(str) && !multiElementB.contains(str)).collect(Collectors.toList());
        collectA.addAll(collectB);
        return collectA.toArray(new String[0]);
    }
}
