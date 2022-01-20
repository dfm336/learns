package com.dfm.app.javacore;

import java.math.BigInteger;

/**
 * @Author:fengming.dai
 */
public class BigNumberTest {
    public static void main(String[] args) {
        BigInteger sum = BigInteger.valueOf(1000L);

        //  sum + 2000
        BigInteger add = sum.add(BigInteger.valueOf(2000));
        System.out.println("add = " + add);
        // sum * 2
        BigInteger multiply = sum.multiply(BigInteger.valueOf(2));
        System.out.println("multiply = " + multiply);
        // sum / 2
        BigInteger divide = sum.divide(BigInteger.valueOf(2));
        System.out.println("divide = " + divide);
        // sum - 500
        BigInteger subtract = sum.subtract(BigInteger.valueOf(500));
        System.out.println("subtract = " + subtract);
        // sum % 99  取余
        BigInteger mod = sum.mod(BigInteger.valueOf(99));
        System.out.println("mod = " + mod);


    }
}
