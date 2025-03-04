package com.xzy.demo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class NumberCollectorDemo {

    public static void main(String[] args) {
        List<Integer> result = subSevenList(100);
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * 正整数N，小于等于N的，可以被7整除或者含有7的数据集合
     * @param n
     * @return
     */
    public static List<Integer> subSevenList(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (hasSubSeven(i)) {
                result.add(i);
            }
        }
        return result;

    }

    /**
     *
     * @param num
     * @return
     */
    public static boolean hasSubSeven(Integer num) {
        if (num % 7 == 0) {
            return true;
        }
        while (num > 0) {
            if (num % 10 == 7) {
                return true;
            }
            num = num / 10;
        }
        return false;
        //return num % 7 == 0 || String.valueOf(num).contains("7");
    }
}
