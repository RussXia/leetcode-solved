package com.xzy.leetcode._1_300;

/**
 * @author xiazhengyue
 * @since 2021-03-23
 */
public class Solution_278 {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(1));
    }

    public static int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return isBadVersion(start) ? start : start + 1;
    }

    public static boolean isBadVersion(int version) {
        if (version >= 1) {
            return true;
        }
        return false;
    }
}
