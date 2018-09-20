package com.xzy.leetcode;


import java.util.ArrayList;
import java.util.List;

public class ReverseInteger7 {

    public static void main(String[] args) {
        System.out.println(reverseInteger(120));
        System.out.println(reverseInteger(123));
        System.out.println(reverseInteger(-123));
        System.out.println(reverseInteger(0));
        System.out.println(reverseInteger(1534236469));


    }

    /**
     * fixme:超出范围的int类型，在倒转的时候出现精度丢失
     *
     * @param x
     * @return
     */
    private static int reverseInteger(int x) {
        if (x > 0 && x >> 31 != 0) {
            return 0;
        }

        boolean flag = x > 0;
        x = Math.abs(x);
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            int temp = x % 10;
            x = x / 10;
            list.add(temp);
        }
        int result = 0;
        while (!list.isEmpty()) {
            Integer num = list.remove(0);
            result += (int) Math.pow(10, list.size()) * num;
        }
        if (!flag) {
            result = result * -1;
        }
        return result;
    }


    public static int reverseInteger2(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }
}
