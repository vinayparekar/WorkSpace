package com.hulu.phone;

/*
Your previous Plain Text content is preserved below:

This is just a simple shared plaintext pad, with no execution capabilities.

When you know what language you'd like to use for your interview,
simply choose it from the dropdown in the top bar.

You can also change the default language your pads are created with
in your account settings: https://coderpad.io/settings

Enjoy your interview!

* Given Binary Search Tree, input k, write function to find k-th smallest element in the BST
*
* TreeNode {
*   TreeNode left
*   TreeNode right
*   int value
* }
*
* Example:
*              14
*            /    \
*           9     18
*          / \    / \
*         4  11  16 23
*
*
* k = 3 --> 11
* k = 7 --> 23
 */


// TRY WITH RECURSION

public class BST_KthSmallestElement {
    static Integer k ;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(14);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(18);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(11);
        TreeNode node10 = new TreeNode(16);
        TreeNode node5 = new TreeNode(23);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right= node4;
        node2.left = node10;
        node2.right= node5;

        // static variable Approach
        k = 2;
        int value  = getKthSmallestValue(root);System.out.println(value);

        k = 3;  value  = getKthSmallestValue(root);     System.out.println(value);
        k = 5;  value  = getKthSmallestValue(root);     System.out.println(value);
//      k = 10;  value  = getKthSmallestValue(root);     System.out.println(value+ "\n");  // Throws Exception as there are just 7 values in BST

        // Recursive return value Approach
        Pair value1= null;
        k = 2;    value1  = getKthSmallestValue_recursive(root,k);    System.out.println("result : "+value1.r_value);
        k = 3;  value1  = getKthSmallestValue_recursive(root,k);     System.out.println(value1.r_value);
        k = 5;  value1  = getKthSmallestValue_recursive(root,k);     System.out.println(value1.r_value);
        k = 6;  value1  = getKthSmallestValue_recursive(root,k);     System.out.println(value1.r_value);
        k = 10;  value1  = getKthSmallestValue_recursive(root,k);     System.out.println(value1.r_value);

    }

    public static Integer getKthSmallestValue(TreeNode root  ) {

        if (k == 0) {
            return null;
        }

        if (root == null) {
            return null;
        }
        // call left
        Integer resultLeft = getKthSmallestValue(root.left);
        System.out.println(root.value + " : " + k);
        k--;
        if (k == 0) {
            return root.value;
        }

        // call right
        Integer resultRIght = getKthSmallestValue(root.right);

        if (resultLeft != null) {
            return resultLeft;
        } else if (resultRIght != null) {
            return resultRIght;
        } else {
            return null;
        }

    }

    public static Pair getKthSmallestValue_recursive(TreeNode root, int k){

        if(root==null){
            return new Pair(k,-1);
        }
        Pair left_value = getKthSmallestValue_recursive(root.left,k);
        if(left_value.k_value ==0){
            return left_value;
        }
        k=left_value.k_value;
        System.out.println(root.value + " => "+ k );
        if(--k==0){
            return new Pair(0,root.value);
        }
        Pair right_value = getKthSmallestValue_recursive(root.right,k);
        if(right_value.k_value == 0){
            return right_value;
        }
        k= right_value.k_value;
        return new Pair(k,-1);
    }
}

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value){
        this.value = value;
    }
}

class Pair{
    int k_value;
    int r_value;
    Pair(int k, int r){this.k_value = k; this.r_value = r;}
}
