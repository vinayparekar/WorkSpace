package com.quora.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContiguousArray {

//Input: [0,1,0]
//Output: 2
//Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

    public static void main(String[] args){
        int  value  = findMaxLength(new int[]{0,0,0,0,1,0,1,0,0,0});
        System.out.println("Answer is : "+ value);

        List<List<Integer>> list = new ArrayList<>();
        list.size();
//        list.get(0).size();

    }


        public static int findMaxLength(int[] nums) {
            HashMap<Integer,Integer> map = new HashMap<>();
            map.put(0,0);
            int ans = 0,sum=0;
            for(int i=0;i<nums.length;++i){
                if(nums[i]==0) nums[i] = -1;
                sum += nums[i];
                if(map.containsKey(sum)) ans = Math.max(ans,i-map.get(sum)+1);
                else map.put(sum,i+1);
            }
            return ans;
        }

}
