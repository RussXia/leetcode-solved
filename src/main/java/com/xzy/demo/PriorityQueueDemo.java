package com.xzy.demo;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        int[] numbers = generateRandomNumbers(20);
        System.out.println(JSONObject.toJSONString(numbers));
        int n = 5;
        int[] minNumbers = findMinNNumbers(numbers, n);

        System.out.println("最小的 " + n + " 个数是: " + Arrays.toString(minNumbers));
    }

    /**
     * 生成指定数量的随机整数
     */
    private static int[] generateRandomNumbers(int size) {
        int[] numbers = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(1000);;
        }
        return numbers;
    }

    /**
     * 使用优先队列（最大堆）找到最小的 n 个数
     */
    private static int[] findMinNNumbers(int[] numbers, int n) {
        if (numbers == null || numbers.length == 0 || n <= 0 || n > numbers.length) {
            throw new IllegalArgumentException("参数不合法");
        }

        // 使用最大堆（堆顶是最大的元素）
        Queue<Integer> maxHeap = new PriorityQueue<>(n, (a, b) -> b - a);

        for (int num : numbers) {
            if (maxHeap.size() < n) {
                maxHeap.offer(num); // 堆未满，直接加入
            } else if (num < maxHeap.peek()) {
                maxHeap.poll(); // 移除堆顶的最大值
                maxHeap.offer(num); // 加入当前数
            }
        }

        // 将堆中的数转换为数组
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
}
