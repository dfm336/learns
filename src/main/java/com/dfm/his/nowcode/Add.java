package com.dfm.his.nowcode;

/**
 * @author dfm
 * @create 2020-09-29 15:12
 */
public class Add {
    private static int solution(int a,int b){
        while (a != 0){//有进位
            int temp = a ^ b;//加法 不考虑进位
            a = (a & b) << 1;//求得 进位
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        int solution = solution(899, 111);
        System.out.println(solution );
    }
}
