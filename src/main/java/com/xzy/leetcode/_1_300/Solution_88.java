package com.xzy.leetcode._1_300;

import java.util.Arrays;

public class Solution_88 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge3(nums1, m, nums2, n);
        System.out.println(nums1);
    }


    // double point without extra space
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                nums1[tail--] = nums2[p2--];
                continue;
            }
            if (p2 == -1) {
                nums1[tail--] = nums1[p1--];
                continue;
            }
            if (nums1[p1] < nums2[p2]) {
                nums1[tail--] = nums2[p2--];
            } else {
                nums1[tail--] = nums1[p1--];
            }
        }
    }


    // copy & quick sort
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    // double point
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[nums1.length];
        System.arraycopy(nums1, 0, result, 0, m);
        for (int i = 0, a = 0, b = 0; i < (m + n); i++) {
            if (a >= m) {
                nums1[i] = nums2[b];
                b++;
                continue;
            }
            if (b >= n) {
                nums1[i] = result[a];
                a++;
                continue;
            }
            if (result[a] < nums2[b]) {
                nums1[i] = result[a];
                a++;
            } else {
                nums1[i] = nums2[b];
                b++;
            }
        }
    }
}
