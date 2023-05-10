package com.xzy.leetcode._1_300;

import java.util.LinkedList;
import java.util.List;

/**
 * User: RuzzZZ
 * Date: 2023/5/9
 * Time: 10:13
 */
public class Solution_54 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0, row = matrix.length - 1, startCol = 0, col = matrix[0].length - 1;
        // i横向移动，[startCol,col];j纵向移动，[startRow,row]
        int i = 0, j = 0;
        // 0-向右;1-向下;2-向左;3-向上
        int flag = 0;
        List<Integer> result = new LinkedList<>();
        do {
            result.add(matrix[i][j]);
            // 转向
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
        return result;
    }
}
