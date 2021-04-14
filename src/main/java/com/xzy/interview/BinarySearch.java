package com.xzy.interview;

/**
 * @author xiazhengyue
 * @since 2021-04-09
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {1, 3, 5, 7, 9, 11};
        System.out.println(binarySearch.binarySearch(nums, 4));
    }

    public int binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (target == nums[middle]) {
                return middle;
            }
            if (target > nums[middle]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1;
    }
}
