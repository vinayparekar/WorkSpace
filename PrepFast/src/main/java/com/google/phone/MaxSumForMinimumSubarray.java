package com.google.phone;

public class MaxSumForMinimumSubarray {

    public static void main(String[] args){
        System.out.println();
    }

    public boolean subArrayTest(int[] arr, int k, int x){
        int subarraysum = 0;
        for(int i=0; i<arr.length; i++){
            subarraysum += arr[i];
            if(subarraysum>=x){
                k--;
                if(k==0){
                    return true;
                }
            }
        }
        return false;
    }
}
