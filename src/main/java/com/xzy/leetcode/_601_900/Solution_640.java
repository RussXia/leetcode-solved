package com.xzy.leetcode._601_900;

import java.util.Stack;

/**
 * User: RuzzZZ
 * Date: 2022/8/10
 * Time: 14:12
 */
public class Solution_640 {

    public static void main(String[] args) {

    }

    public static String solveEquation(String equation) {
        String[] split = equation.split("=");
        char[] lChars = split[0].toCharArray();
        char[] rChars = split[1].toCharArray();
        //等式左右分别入栈，计算两边的x的系数
        Stack<Character> lStack = new Stack<>();
        Stack<Character> rStack = new Stack<>();

        for (int i = 0; i < lChars.length; i++) {

        }



        return null;
    }
}
