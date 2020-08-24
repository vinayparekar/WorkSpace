package com.pramp;

public class PancakeSort {

    static int[] pancakeSort(int[] arr) {
        // your code goes here
        int end = arr.length-1;
        int start = 0;
        while(end>=0){
            int index = findMax(arr, end);
            flip(arr,index);
            flip(arr,end);
            end--;
        }
        return arr;
    }

    static void flip(int[] arr, int k){
        int s = 0;
        int e = k;
        while(s<=e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }

    static int findMax (int[] arr, int end){
        int index = 0;
        int max = Integer.MIN_VALUE;

        for(int i =0;i<end;i++){
            if(arr[i]>max){
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {

    }

}
