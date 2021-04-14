package com.xzy.algorithm.sort;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiazhengyue
 * @since 2021-04-13
 */
public class BucketSort {

    private int step = 10;

    private int indexFor(int a, int min) {
        return (a - min) / step;
    }

    public void bucketSort(int[] arr) {

        int max = arr[0], min = arr[0];
        for (int a : arr) {
            if (max < a)
                max = a;
            if (min > a)
                min = a;
        }
        // 该值也可根据实际情况选择
        int bucketNum = max / step - min / step + 1;
        List<List<Integer>> buckList = new ArrayList<>();
        // create bucket
        for (int i = 1; i <= bucketNum; i++) {
            buckList.add(new ArrayList<>());
        }
        // push into the bucket
        for (int i = 0; i < arr.length; i++) {
            int index = indexFor(arr[i], min);
            buckList.get(index).add(arr[i]);
        }
        int index = 0;
        for (int i = 0; i < bucketNum; i++) {
            List<Integer> bucket =  buckList.get(i);
            insertSort(bucket);
            for (int k : bucket) {
                arr[index++] = k;
            }
        }

    }

    // 把桶内元素插入排序
    private void insertSort(List<Integer> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            int temp = bucket.get(i);
            int j = i - 1;
            for (; j >= 0 && bucket.get(j) > temp; j--) {
                bucket.set(j + 1, bucket.get(j));
            }
            bucket.set(j + 1, temp);
        }
    }

    public static void main(String[] args) {
        BucketSort sort = new BucketSort();
        int[] arr = {3, 1, 2, 5, 4, 9, 7, 6, 8, 11, 13, 16, 12, 14, 15};
        sort.bucketSort(arr);
        System.out.println(JSON.toJSON(arr));
    }
}
