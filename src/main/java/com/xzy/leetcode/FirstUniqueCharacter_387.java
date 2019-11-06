package com.xzy.leetcode;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiazhengyue
 * @since 2019-11-05
 */
public class FirstUniqueCharacter_387 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("leetcodelove"));
        System.out.println(firstUniqChar("leel"));
        System.out.println(firstUniqChar("l"));
    }

    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Pair<Integer, Integer>> dict = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Pair<Integer/*index*/, Integer/*count*/> count = dict.getOrDefault(chars[i], new Pair<>(i, 0));
            dict.put(chars[i], new Pair<>(count.key, count.value + 1));
        }
        int index = chars.length;
        for (Character character : dict.keySet()) {
            Pair<Integer, Integer> pair = dict.get(character);
            if (pair.value == 1 && pair.key < index) {
                index = pair.key;
            }
        }
        return index == chars.length ? -1 : index;
    }

    static class Pair<K,V> {
        K key;

        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}
