package com.xzy.interview;

public class LeetCode_42 {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new LeetCode_42().trap(height));
    }

    /**
     * max_left[i] = Math.max(max_left[i-1],height[i-1])
     * max_right[i] = Math.max(max_right[i+1],height[i+1])
     *
     */
    public int trap4(int[] height) {
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int minValue = Math.min(max_left[i], max_right[i]);
            result += Math.max(minValue - height[i], 0);
        }
        return result;
    }

    public int trap3(int[] height) {
        int result = 0;
        for (int i = 1; i < height.length; i++) {
            int max_left = 0;
            int max_right = 0;
            // 找出左侧最高的列
            for (int j = 0; j < i; j++) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            // 找出右侧最高的列
            for (int j = i; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            // 计算当前列的值
            int minValue = Math.min(max_left, max_right);
            result += Math.max(minValue - height[i], 0);
        }
        return result;
    }

    public int trap2(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int result = 0;
        while (left <= right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    result += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    result += rightMax - height[right];
                }
                right--;
            }
        }
        return result;
    }

    public int trap(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        int result = 0;
        for (int i = 1; i <= max; i++) {
            int count = 0;
            int start = 0, end = height.length - 1;
            for (int j = 0; j < height.length; j++) {
                if (height[j] >= i) {
                    break;
                }
                start++;
            }
            for (int j = height.length - 1; j >= 0; j--) {
                if (height[j] >= i) {
                    break;
                }
                end--;
            }
            for (int j = start; j < end; j++) {
                if (height[j] < i) {
                    count++;
                }
            }
            result += count;
        }
        return result;
    }
}
