package com.xzy.leetcode._1201_;

/**
 * @author xiazhengyue
 * @since 2021-04-07
 */
public class Solution_1551 {

    public static void main(String[] args) {
        System.out.println(minOperations(3));
        System.out.println(minOperations(4));
        System.out.println(minOperations(5));
        System.out.println(minOperations(6));
        System.out.println(minOperations(7));
        System.out.println(minOperations(8));
        System.out.println(minOperations(9));
        System.out.println(minOperations(10));
        System.out.println(minOperations(11));
    }

    /**
     * n=3,avg=3,out=2
     * n=4,avg=4,out=4
     * n=5,avg=5,out=6
     * n=6,avg=6,out=9
     * <p>
     * 奇数时，
     * Sum(i=1 to n/2) = n-1 + n-3 + ... + 2
     * = [(n+1)*(n/2)]/2
     * <p>
     * <p>
     * 偶数时，
     * Sum(i=1 to n/2) = n-1 + n-3 + ... + 1
     * = [n * (n/2)]/2
     *
     * @param n
     * @return
     */
    public static int minOperations(int n) {
        if (n % 2 == 0) {
            return (n * (n / 2)) / 2;
        }
        return ((n + 1) * (n / 2)) / 2;
    }

    public static int minOperations2(int n) {
        int count = 0;
        for (int i = 0; i <= n / 2 && (2 * i + 1) < n; i++) {
            count += n - (2 * i + 1);
        }
        return count;
    }
}
