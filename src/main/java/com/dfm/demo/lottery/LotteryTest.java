package com.dfm.demo.lottery;

/**
 * @Author:fengming.dai
 */
public class LotteryTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            String gift = LotteryUtil.init(0);
        }
        LotteryUtil.printCount();

    }
}
