package com.xzy.reactor;

import java.util.Scanner;

public class CharGraphic {
    private static final int MAX_ROW = 7;
    private static final int MAX_COL = 5;

    private static final String[] GRAPHIC = {
            "  *  ", " * * ", "*   *", "*****", "*   *", "*   *", "*   *"
    };

    private static final String[] UNKNOWN = {
            "*****", "*   *", "*   *", "*   *", "*   *", "*   *", "*****"
    };

    /**
     * 将一个字符转换为图形化的字符串数组
     *
     * @param c 待转换的字符，必须为大写字母或小写字母
     * @return 由图形化字符组成的字符串数组，每个字符串代表一个字符的图形化表示方式
     * @throws IllegalArgumentException 如果输入的字符不是大写字母或小写字母，则抛出该异常
     */
    public static String[] getCharGraphic(char c) throws IllegalArgumentException {
        String[] result = new String[MAX_ROW];

        if (c >= 'A' && c <= 'Z') {
            int index = c - 'A';
            for (int i = 0; i < MAX_ROW; i++) {
                result[i] = GRAPHIC[i].substring(index * MAX_COL, (index + 1) * MAX_COL);
            }
        }
        else if (c >= 'a' && c <= 'z') {
            int index = c - 'a';
            for (int i = 0; i < MAX_ROW; i++) {
                result[i] = GRAPHIC[i].substring(index * MAX_COL, (index + 1) * MAX_COL);
            }
        }
        else {
            throw new IllegalArgumentException("输入的字符必须为大写字母或小写字母");
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字母：");
        char c = scanner.next().charAt(0);

        try {
            String[] graphic = getCharGraphic(c);
            System.out.println("图形化表示结果为：");
            for (String row : graphic) {
                System.out.println(row);
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}