package com.xzy.algorithm;

/**
 * User: RuzzZZ
 * Date: 2023/6/9
 * Time: 16:28
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,8,9};
        System.out.println(search(arr,3));
        System.out.println(search(arr,4));
        System.out.println(search(arr,5));
    }

    /**
     * @param arr    单调递增的数组
     * @param target 需要搜索的目标
     * @return 目标所在的索引位，如果不存在返回-1
     */
    public static int search(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (arr[middle] < target) start = middle + 1;
            else if (arr[middle] > target) end = middle - 1;
            else return middle;
        }
        return -1;
    }
}
