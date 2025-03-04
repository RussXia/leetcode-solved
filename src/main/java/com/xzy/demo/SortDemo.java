package com.xzy.demo;

import com.alibaba.fastjson.JSON;

public class SortDemo {

    public static void main(String[] args) {
        //int[] arr = {3, 1, 2, 9, 5, 6, 8};
        //bubbleSort(arr);
        int[] arr = {9, 1, 3, 2, 5, 6, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(JSON.toJSONString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        System.out.println(JSON.toJSONString(arr));
    }

    public static void heapSort(int[] arr) {

    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int partition = partition(arr, start, end);
            quickSort(arr, start, partition - 1);
            quickSort(arr, partition + 1, end);
        }
    }


    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start + 1, right = end;
        while (left < right) {
            while (left < end && arr[left] <= pivot)
                left++;
            while (right > start && arr[right] >= pivot)
                right--;
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, start, right);
        return right;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
