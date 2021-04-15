package com.xzy.leetcode._1_300;

/**
 * @author xiazhengyue
 * @since 2021-04-15
 */
public class Solution_200 {

    public static void main(String[] args) {
        Solution_200 solution = new Solution_200();
        {
            char[][] grid = {
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '0', '1', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '0', '0', '0'}
            };
            System.out.println(solution.numIslands(grid));
        }
        {
            char[][] grid = {
                    {'1', '1', '0', '0', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '1', '0', '0'},
                    {'0', '0', '0', '1', '1'}
            };
            System.out.println(solution.numIslands(grid));
        }
    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                //向上、下、左、右寻找
                searchAround(grid, i, j);
                count++;
            }
        }
        return count;
    }

    private void searchAround(char[][] grid, int rowIndex, int colIndex) {
        int row = grid.length;
        int col = grid[0].length;

        //遇到0表示已搜索过的/非陆地，停止搜索
        if (grid[rowIndex][colIndex] == '0') {
            return;
        }
        grid[rowIndex][colIndex] = '0';
        if (rowIndex > 0) { //上
            searchAround(grid, rowIndex - 1, colIndex);
        }
        if (rowIndex < (row - 1)) { //下
            searchAround(grid, rowIndex + 1, colIndex);
        }
        if (colIndex > 0) { //左
            searchAround(grid, rowIndex, colIndex - 1);
        }
        if (colIndex < (col - 1)) { //右
            searchAround(grid, rowIndex, colIndex + 1);
        }
    }
}
