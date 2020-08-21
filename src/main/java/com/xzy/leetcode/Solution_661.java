package com.xzy.leetcode;

import java.util.Arrays;

/**
 * @author xiazhengyue
 * @since 2019-03-04
 */
public class Solution_661 {

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4};
        System.out.println(triangleNumber(nums));
    }

    public static int triangleNumber(int[] A) {
        Arrays.sort(A); //先排序
        int count = 0, n = A.length;
        for (int i = n - 1; i >= 2; i--) {  //i是三角边最长那个的index，最长边恒定，遍历两个小的
            int l = 0, r = i - 1;      //l是最短的，r是中间长度的
            while (l < r) {
                if (A[l] + A[r] > A[i]) {
                    count += r - l;//r-l中间的元素都符合要求(排序过)
                    r--;   //中间边向下调整
                } else l++; //最短边向上调整
            }
        }
        return count;
    }
}
