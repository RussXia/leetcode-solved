package com.xzy.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xiazhengyue
 * @since 2019-01-25
 */
public class PowerfulIntegers_970 {

    public static void main(String[] args) {
//        powerfulIntegers(2, 3, 10).forEach(System.out::println);
        powerfulIntegers(1, 2, 100).forEach(System.out::println);

//        System.out.println(Math.log(4));
    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; j + i <= bound; j *= y) {
                result.add(i + j);
                if (y == 1) {
                    break;
                }
            }
            if (x == 1) {
                break;
            }
        }
        return new ArrayList<>(result);
    }

}
