package com.xzy.leetcode._1_300;

/**
 * User: RuzzZZ
 * Date: 2023/5/10
 * Time: 11:20
 */
public class Solution_59 {

    public static void main(String[] args) {
        System.out.println(generateMatrix(3));
        System.out.println(generateMatrix(1));
        System.out.println(generateMatrix(5));
    }

    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int count = 1;
        int i = 0, j = 0;
        int startRow = 0, row = n - 1;
        int startCol = 0, col = n - 1;
        // 0-向右;1-向下;2-向左;3-向上
        int flag = 0;
        do {
            arr[i][j] = count;
            count++;
            if (j == col && flag == 0) {    //第一行
                flag = 1;
                startRow++;
            } else if (i == row && flag == 1) {     // 最后一列
                flag = 2;
                col--;
            } else if (j == startCol && flag == 2) {       // 最后一行
                flag = 3;
                row--;
            } else if (i == startRow && flag == 3) {    // 第一列
                flag = 0;
                startCol++;
            }
            // 继续移动
            if (flag == 0) j++;
            else if (flag == 1) i++;
            else if (flag == 2) j--;
            else i--;
        } while (i >= startRow && i <= row && j >= startCol && j <= col);
        return arr;
    }
}
