package com.xzy.leetcode._1_300;

import com.alibaba.fastjson.JSON;

/**
 * @author xiazhengyue
 * @since 2019-11-05
 */
public class Solution_48 {

    public static void main(String[] args) {
//        int[][] matrix = {
//                {5, 1, 9, 11},
//                {2, 4, 8, 10},
//                {13, 3, 6, 7},
//                {15, 14, 12, 16}
//        };

//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };

//        int[][] matrix = {
//                {1, 2, 3, 4, 5},
//                {6, 7, 8, 9, 7},
//                {3, 2, 5, 7, 4},
//                {4, 3, 2, 6, 8},
//                {5, 4, 3, 7, 9},
//        };

        int[][] matrix = {
                {24, 4, 38, 2, 21, 18, 33, 40},
                {24, 37, 25, 62, 37, 15, 35, 36},
                {42, 23, 13, 58, 17, 26, 19, 8},
                {32, 48, 9, 58, 36, 18, 40, 61},
                {23, 16, 0, 46, 35, 34, 23, 60},
                {9, 49, 60, 47, 1, 32, 20, 45},
                {56, 34, 40, 11, 61, 60, 20, 30},
                {45, 30, 25, 18, 49, 3, 16, 10}
        };

        /**
         * expected
         * [45,56,9,23,32,42,24,24],
         * [30,34,49,16,48,23,37,4],
         * [25,40,60,0,9,13,25,38],
         * [18,11,47,46,58,58,62,2],
         * [49,61,1,35,36,17,37,21],
         * [3,60,32,34,18,26,15,18],
         * [16,20,20,23,40,19,35,33],
         * [10,30,45,60,61,8,36,40]]
         */
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(JSON.toJSONString(matrix[i]));
        }
    }

    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        int maxIndex = length - 1;
        for (int i = 0; i <= matrix.length / 2; i++) {
            for (int j = i; j < length - 1; j++) {
                //顺时针旋转四个对角的元素
                int temp = matrix[i][j];
                matrix[i][j] = matrix[maxIndex - j][i];
                matrix[maxIndex - j][i] = matrix[maxIndex - i][maxIndex - j];
                matrix[maxIndex - i][maxIndex - j] = matrix[j][maxIndex - i];
                matrix[j][maxIndex - i] = temp;
            }
            length--;
        }
    }

}
