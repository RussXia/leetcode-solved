package com.xzy.leetcode._1_300;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author xiazhengyue
 * @since 2021-04-08
 */
public class Solution_17 {

    public static void main(String[] args) {
        String digits = "72";
        System.out.println(JSON.toJSON(letterCombinations(digits)));
    }

    /**
     * dp[n] = dp[n-1] + (dp[n-1]+character[0]) + (dp[n-1]+character[1]) + (dp[n-1]+character[2])
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {

        if (digits == null || digits.equals("")) {
            return new ArrayList<>();
        }

        Map<Character, char[]> dict = new HashMap<Character, char[]>() {
            private static final long serialVersionUID = 7589963405293718363L;

            {
                this.put('2', new char[]{'a', 'b', 'c'});
                this.put('3', new char[]{'d', 'e', 'f'});
                this.put('4', new char[]{'g', 'h', 'i'});
                this.put('5', new char[]{'j', 'k', 'l'});
                this.put('6', new char[]{'m', 'n', 'o'});
                this.put('7', new char[]{'p', 'q', 'r', 's'});
                this.put('8', new char[]{'t', 'u', 'v'});
                this.put('9', new char[]{'w', 'x', 'y', 'z'});

            }
        };
        //初始化dp
        List<String> dp = new ArrayList<>();
        dp.add("");

        //遍历，构造结果
        for (int i = 0; i < digits.length(); i++) {
            List<String> temp = new ArrayList<>();
            char[] chars = dict.get(digits.charAt(i));
            for (int j = 0; j < chars.length; j++) {
                for (String str : dp) {
                    temp.add(str + chars[j]);
                }
            }
            dp = temp;
        }

        return dp;
    }



    public static List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            int length = ans.size();
            for (int j = 0; j < length; j++) {
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }

}
