package com.quora.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PathSum3 {

    static int count=0;
    public int pathSum(TreeNode root, int sum) {
        Deque<Integer> q = new ArrayDeque();
        pathSum(root, sum, 0, q );
        return count;
    }

    public void pathSum(TreeNode root,int targetSum ,int sum, Deque<Integer> q){
        if(root == null){
            return;
        }
        else if(root.left == null && root.right== null){
            sum = sum+ root.val;
            q.addFirst(root.val);
            while(!q.isEmpty()){
                int value=q.pollLast();
                if(sum==targetSum){
                    count++;
                }
                sum=sum-value;
            }
            return;
        }else{
            sum = sum+ root.val;
            q.addFirst(root.val);
            pathSum(root.left,targetSum,sum,new ArrayDeque<Integer>(q));
            pathSum(root.right,targetSum,sum,new ArrayDeque<Integer>(q));

            while(!q.isEmpty()){
                int value=q.pollLast();
                if(sum==targetSum){
                    count++;
                }
                sum=sum-value;
            }
            return;
        }
    }
}


//  Definition for a binary tree node.
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
