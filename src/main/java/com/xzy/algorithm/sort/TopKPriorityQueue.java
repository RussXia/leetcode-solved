package com.xzy.algorithm.sort;

import com.alibaba.fastjson.JSON;

import java.util.PriorityQueue;

/**
 * @author xiazhengyue
 * @since 2021-03-29
 */
public class TopKPriorityQueue {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 4};
        System.out.println(JSON.toJSON(getLeastNumbers(arr, 2)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>((v1,v2)->v2 - v1);
        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k) {
                queue.add(arr[i]);
            } else if (queue.peek() > arr[i]) {
                queue.poll();
                queue.add(arr[i]);
            }

        }
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}
