package com.dfm.app;

public class BitoTest {
    public static void main(String[] args) {
        String inputString = null;
        // 检查输入字符串是否为 null
        if (inputString == null) {
            System.out.println("输入字符串为空。");
        } else {
            // 检查输入字符串是否等于 "2"
            boolean isEqual = "2".equals(inputString);
            System.out.println("输入字符串是否等于 \"2\"？" + isEqual);
        }


    }
}
