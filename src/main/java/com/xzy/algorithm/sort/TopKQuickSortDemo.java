package com.xzy.algorithm.sort;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author xiazhengyue
 * @since 2021-03-29
 */
public class TopKQuickSortDemo {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 4};
        System.out.println(JSON.toJSON(getLeastNumbers(arr, 2)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    public static int[] quickSearch(int[] arr, int start, int end, int k) {
        int partition = partition(arr, start, end);
        if (partition == k) {
            return Arrays.copyOf(arr, partition + 1);
        }
        if (partition < k) {
            return quickSearch(arr, partition + 1, end, k);
        } else {
            return quickSearch(arr, 0, partition - 1, k);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int element = arr[start];
        int i = start, j = end + 1;
        while (true) {
            while (++i <= end && arr[i] > element) ;
            while (--j >= start && arr[j] < element) ;
            if (i >= j) {
                break;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[start] = arr[j];
        arr[j] = element;
        return j;
    }
}
