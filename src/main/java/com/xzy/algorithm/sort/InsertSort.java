package com.xzy.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * @author xiazhengyue
 * @since 2021-04-13
 */
public class InsertSort {

    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i];
            for (; j >= 0 && arr[j] > temp; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        InsertSort sort = new InsertSort();
        int[] arr = {3, 8, 7, 6, 5, 4, 9, 2, 1};
        sort.insertSort(arr);
        System.out.println(JSON.toJSON(arr));
    }
}
