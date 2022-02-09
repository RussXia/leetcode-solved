package com.xzy.leetcode._1201_2000;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xiazhengyue
 * @since 2021-03-18
 */
public class Solution_1493 {

    public static void main(String[] args) {
        int[] arr = {1,1,0,0,1,1,1,0,1};
//        int[] arr = {0, 0, 0};
//        int[] arr = {1,1,1};
//        int[] arr = {1,1,0,1};
        System.out.println(longestSubarray2(arr));
    }

    public static int longestSubarray(int[] nums) {
        Deque<Integer> queue = new LinkedList<>();
        int max = 0;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && zeroCount == 0) {
                queue.offer(nums[i]);
                zeroCount++;
            } else if (nums[i] == 0 && zeroCount == 1) {
                max = Math.max(max, queue.size() - 1);
                while (!queue.isEmpty() && queue.removeFirst() != 0) {
                    System.out.println("remove");
                }
                queue.offer(nums[i]);
            } else {
                queue.offer(nums[i]);
            }
        }
        max = Math.max(max, queue.size() - 1);
        return max;
    }


    public static int longestSubarray2(int[] A) {
        int i = 0, j, k = 1;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0){
                k--;
            }
            if (k < 0 && A[i++] == 0){
                k++;
            }
        }
        return j - i - 1;
    }
}
