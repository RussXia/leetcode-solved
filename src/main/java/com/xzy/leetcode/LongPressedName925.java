package com.xzy.leetcode;

/**
 * @author xiazhengyue
 * @since 2019-01-23
 */
public class LongPressedName925 {

    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "aaleex"));
        System.out.println(isLongPressedName("saeed", "ssaaedd"));
        System.out.println(isLongPressedName("leelee", "lleeelee"));
        System.out.println(isLongPressedName("laiden", "laiden"));
        System.out.println(isLongPressedName("laiden", "laidennnnnnn"));
        System.out.println(isLongPressedName("laiden", "laidennnnnnne"));
        System.out.println(isLongPressedName("pyplrz", "ppyypllr"));
    }

    public static boolean isLongPressedName(String name, String typed) {
        char[] nameChar = name.toCharArray();
        char[] typedChar = typed.toCharArray();
        int i = 0, j = 0;
        boolean skipOverFlag = false;
        for (; j < typedChar.length; ) {
            if (nameChar[i] == typedChar[j]) {
                if (i < nameChar.length - 1) {
                    i++;
                } else {
                    skipOverFlag = true;
                }
                j++;
                continue;
            }
            if (j - 1 >= 0 && typedChar[j] == typedChar[j - 1]) {
                j++;
                continue;
            }
            return false;
        }
        if (skipOverFlag) {
            return true;
        }
        return false;
    }
}
