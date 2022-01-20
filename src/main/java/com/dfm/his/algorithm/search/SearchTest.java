package com.dfm.his.algorithm.search;

import com.dfm.his.algorithm.sort.Quick;

/**
 * @author dfm
 * @create 2020-08-28 15:04
 */
public class SearchTest {
    public static void main(String[] args) {
        int[] arr = {25,58,59,87,15,-4,0};
        Quick.sort(arr);
        int ans = BinarySearch.search(arr,45);
        System.out.println(ans);
    }
}
