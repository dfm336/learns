package com.dfm.his.exam;

import java.util.Scanner;

/**
 * @author dfm
 * @create 2020-10-13 09:51
 */
public class XieCheng {
    static int buyCoke(int m, int a, int b, int c, int x) {
//            if(c * 100 == x * m)return c;
            int buy= m;
            int pay = 0;
            int count = 0;
            if(c != 0){
                for(int i=1;i<=c;i++){
                    pay += 100;
                    if(pay < x)continue;
                    if( pay == x){
                        m--;
                        pay = 0;
                    }else {
                        m--;
                        int mod = pay-x;
                        if(mod >= 50){
                            if(mod % 50 == 0)b+= (mod / 50);
                            else {
                                b += (mod / 50);
                                a += ((mod % 50)/10);
                            }
                        }else{
                            a += (mod / 10);
                        }
                        pay = 0;

                    }
                    if(m == 0)return  i;
                }
            }

            count += c;

            if(b != 0){
                for(int i=1;i<=b;i++){
                    pay += 50;
                    if(pay < x)continue;
                    if( pay == x){
                        m--;
                        pay = 0;
                    }else {
                        m--;

                        int mod = pay-x;
                        a += (mod / 10);

                    }
                    pay = 0;
                    if(m == 0)return  i+count;
                }
            }

            count += b;
            int need = (buy * x);
            if(a != 0){
               count += (need - pay )/10;
            }
            return  count;


    }
    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int incomeOfA = cin.nextInt();
            int incomeOfB = cin.nextInt();
            //Start coding -- Input Data
        }
        System.out.println("error");
        //Start coding
    }
}
