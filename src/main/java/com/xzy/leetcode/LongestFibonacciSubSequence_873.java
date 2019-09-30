package com.xzy.leetcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author xiazhengyue
 * @since 2019-01-25
 */
public class LongestFibonacciSubSequence_873 {

    public static void main(String[] args) {
//        System.out.println(lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
//        System.out.println(lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18}));
        System.out.println(lenLongestFibSubseq(new int[]{2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50}));
        System.out.println(lenLongestFibSubseq(new int[]{1, 3, 5}));
    }

    public static int lenLongestFibSubseq(int[] A) {
        List<Integer> list = IntStream.of(A).boxed().collect(Collectors.toList());
        int maxCounter = 0;
        for (int i = 0; i <= A.length - 1; i++) {
            for (int j = i + 1; j <= A.length - 1; j++) {
                int counter = 2;
                int preIndex = i;
                int nextIndex = j;
                while (list.contains(A[preIndex] + A[nextIndex])) {
                    int temp = nextIndex;
                    nextIndex = list.indexOf(A[preIndex] + A[nextIndex]);
                    preIndex = temp;
                    counter++;
                }
                if (counter > maxCounter && counter > 2)
                    maxCounter = counter;
            }
        }
        return maxCounter;
    }
}
