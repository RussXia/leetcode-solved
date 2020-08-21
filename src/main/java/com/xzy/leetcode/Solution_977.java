package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2019-01-23
 */
public class Solution_977 {

    public static void main(String[] args) {
        int[] A = new int[]{-7, -3, 1, 9, 11};
        for (int i : sortedSquares(A)) {
            System.out.print(i + "\t");
        }
    }

    public static int[] sortedSquares(int[] A) {
        //定义头尾两个指针
        int head = 0;
        int tail = A.length - 1;
        int[] result = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            //取绝对值最大的那个元素，放到数组最后,移动指针
            if (Math.abs(A[head]) > Math.abs(A[tail])) {
                result[i] = A[head] * A[head];
                head++;
            } else {
                result[i] = A[tail] * A[tail];
                tail--;
            }
        }
        return result;
    }
}
