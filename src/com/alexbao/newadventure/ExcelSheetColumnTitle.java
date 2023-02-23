package com.alexbao.newadventure;

public class ExcelSheetColumnTitle {
    /**
     *  168. Excel Sheet Column Title
     *  Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
     *
     * For example:
     *
     * A -> 1
     * B -> 2
     * C -> 3
     * ...
     * Z -> 26
     * AA -> 27
     * AB -> 28
     * ...
     */

    public String convertToTitle(int columnNumber) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] singleAlphabets = alphabet.split("");
        StringBuilder builder = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            builder.append(singleAlphabets[columnNumber % 26]);
            columnNumber = columnNumber / 26;
        }
        builder.reverse();
        return builder.toString();
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle app = new ExcelSheetColumnTitle();
        int columnNumber = 2147483647;
        System.out.println(app.convertToTitle(columnNumber));
    }
}
