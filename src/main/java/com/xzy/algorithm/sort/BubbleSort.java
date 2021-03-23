package com.xzy.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author xiazhengyue
 * @since 2020-08-25
 */
public class BubbleSort {


    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 9, 5, 6, 8};
        System.out.println(JSON.toJSONString(sort(arr)));
    }

    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    break;
                }
            }
        }
        return arr;
    }
}
