package com.dfm.his.algorithm.sort;


/**
 * @author dfm
 * @create 2020-08-21 13:12
 */
class  Test{
    public static void sort(int[] arr,int left,int right,int[] temp){
        if(left < right){
            int mid = (left + right)/2;
            sort(arr,left,mid,temp);
            sort(arr,mid+1,right,temp);
            merge(arr,left,right,temp);
        }

    }

    private static void merge(int[] arr, int left, int right, int[] temp) {
        int mid = (left + right)/2;
        int pl = left;
        int pr = mid+1;
        int count=0;
        while (pl <= mid && pr <= right){
            if(arr[pl] < arr[pr]){
                temp[count++]=arr[pl];
                pl++;
            }else {
                temp[count++] = arr[pr];
                pr++;
            }
        }
        while (pl <= mid){
            temp[count++] = arr[pl];
            pl++;
        }
        while (pr <= right){
            temp[count++] = arr[pr];
            pr++;
        }

        count = 0;
       while (left <= right){
           arr[left++]=temp[count++];
       }
       return;
    }


    public static void main(String[] args) {
        int[] arr = {25,58,59,87,15,-4,0};
//        Bubble bubble = new Bubble();
//        MergeSort mergeSort = new MergeSort();
//        Selection selection = new Selection();
//        Insertion insertion = new Insertion();
//        Quick quick = new Quick();
//        Shell shell = new Shell();
//        mergeSort.sort(arr,0,arr.length-1,new int[arr.length]);
        sort(arr,0,arr.length-1,new int[arr.length]);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }

        MergeSort mergeSort = new MergeSort();

    }
}
