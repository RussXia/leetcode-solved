package com.xzy.leetcode;

public class PalindromeNumber9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome2(12321));
    }


    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        String[] splitArr = String.valueOf(x).split("");
        if (splitArr.length == 1) {
            return true;
        }
        int l = splitArr.length % 2 == 0 ? splitArr.length / 2 - 1 : splitArr.length / 2;
        int r = splitArr.length / 2;
        while (l >= 0 && r <= splitArr.length) {
            if (!splitArr[l].equals(splitArr[r])) {
                return false;
            }
            l--;
            r++;
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x> rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }
}
