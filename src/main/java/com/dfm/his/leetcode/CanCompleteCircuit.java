package com.dfm.his.leetcode;

/**
 * @author dfm
 * @create 2020-10-21 16:46
 */
public class CanCompleteCircuit {
    public static void main(String[] args) {
        int[] gas = new int[]{2,3,4};
        int[] cost = new int[]{3,4,3};
        int res = solution(gas,cost);
        System.out.println(res);
    }

    private static int solution(int[] gas, int[] cost) {
        int len = gas.length;
        for(int i=0;i<len;i++){

            int index =  i;
            int rest = gas[i];
            int need = cost[index];

            if(index + 1 == len){
                index = 0;
            }else {
                index++;
            }

            while (rest >= need){
                if(index == i)return i;

                rest -= need;
                rest += gas[index];

                need = cost[index];

                //下一步
                if(index + 1 == len){
                    index = 0;
                }else {
                    index++;
                }


            }
        }
        return -1;
    }
}
