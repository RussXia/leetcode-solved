package com.xzy.leetcode._301_600;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author xiazhengyue
 * @since 2021-03-29
 */
public class Solution_316 {
    public static void main(String[] args) {
        //excepted:"abc"
        System.out.println(removeDuplicateLetters2("abacb"));
        //excepted:"acb"
        System.out.println(removeDuplicateLetters2("cbacb"));
        //excepted:"bac"
        System.out.println(removeDuplicateLetters2("bbcaac"));
    }

    public static String removeDuplicateLetters2(String sr) {

        int[] res = new int[26]; //will contain number of occurences of character (i+'a')
        boolean[] visited = new boolean[26]; //will contain if character (i+'a') is present in current result Stack
        char[] ch = sr.toCharArray();
        for(char c: ch){  //count number of occurences of character
            res[c-'a']++;
        }
        Stack<Character> st = new Stack<>(); // answer stack
        int index;
        for(char s:ch){
            index= s-'a';
            res[index]--;   //decrement number of characters remaining in the string to be analysed
            if(visited[index]) //if character is already present in stack, dont bother
                continue;
            //if current character is smaller than last character in stack which occurs later in the string again
            //it can be removed and  added later e.g stack = bc remaining string abc then a can pop b and then c
            while(!st.isEmpty() && s<st.peek() && res[st.peek()-'a']!=0){
                visited[st.pop()-'a']=false;
            }
            st.push(s); //add current character and mark it as visited
            visited[index]=true;
        }

        StringBuilder sb = new StringBuilder();
        //pop character from stack and build answer string from back
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        return sb.toString();
    }

    public static String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.compute(chars[i], (key, value) -> {
                if (value == null) {
                    return 1;
                }
                return value + 1;
            });
        }
        Set<Character> set = new HashSet<>();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            if (deque.isEmpty()) {
                map.put(chars[i], map.get(chars[i]) - 1);
                set.add(chars[i]);
                deque.add(chars[i]);
                continue;
            }
            while(!deque.isEmpty()) {
                if(set.contains(chars[i])){
                    map.put(chars[i], map.get(chars[i]) - 1);
                    break;
                }
                if (chars[i] <= deque.getLast() && map.get(deque.getLast()) > 0) {
                    set.remove(deque.removeLast());
                } else {
                    break;
                }
            }
            if (!set.contains(chars[i])) {
                deque.add(chars[i]);
                set.add(chars[i]);
                map.put(chars[i], map.get(chars[i]) - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
}
