package com.xzy.leetcode._301_600;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author xiazhengyue
 * @since 2021-04-13
 */
public class Solution_341 {

    interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    static class NestedIterator implements Iterator<Integer> {
        Stack<NestedInteger> stack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            initStack(nestedList);
        }

        private void initStack(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                return stack.pop().getInteger();
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty() && !stack.peek().isInteger()) {
                List<NestedInteger> list = stack.pop().getList();
                initStack(list);
            }
            return !stack.isEmpty();
        }
    }

}
