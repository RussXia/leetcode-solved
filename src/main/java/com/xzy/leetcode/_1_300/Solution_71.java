package com.xzy.leetcode._1_300;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_71 {

    public static void main(String[] args) {
        String path = "/../";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for (String s : split) {
            if (s.isEmpty() || s.equals(".") || (deque.isEmpty() && s.equals(".."))) {
                continue;
            }
            if (s.equals("..")) {
                deque.pollLast();
                continue;
            }
            deque.addLast(s);
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/").append(deque.pollFirst());
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }


}
