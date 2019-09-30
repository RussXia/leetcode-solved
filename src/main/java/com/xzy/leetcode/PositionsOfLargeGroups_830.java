package com.xzy.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionsOfLargeGroups_830 {

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(largeGroupPositions("abbxxxxzzy")));
        System.out.println(JSONObject.toJSONString(largeGroupPositions("abc")));
        System.out.println(JSONObject.toJSONString(largeGroupPositions("abcdddeeeeaabbbcd")));
        System.out.println(JSONObject.toJSONString(largeGroupPositions("aaa")));
        System.out.println(JSONObject.toJSONString(largeGroupPositions("bababbaaab")));
        System.out.println(JSONObject.toJSONString(largeGroupPositions("bababbabaa")));
    }

    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> list = new ArrayList<>();
        if (S.length() < 3) {
            return list;
        }
        char[] charArray = S.toCharArray();
        int length = 0;
        for (int i = 1; i < charArray.length; i++) {
            if (i == charArray.length - 1) {
                if (charArray[i - 1] == charArray[i]) {
                    length++;
                    i++;
                }
                if (length >= 2) {
                    List<Integer> temp = Arrays.asList(i - length - 1, i - 1);
                    list.add(temp);
                }
                return list;
            }
            if (charArray[i - 1] == charArray[i]) {
                length++;
                continue;
            }
            if (length < 2) {
                length = 0;
                continue;
            }
            List<Integer> temp = Arrays.asList(i - length - 1, i - 1);
            list.add(temp);
            length = 0;
        }
        return list;
    }
}
