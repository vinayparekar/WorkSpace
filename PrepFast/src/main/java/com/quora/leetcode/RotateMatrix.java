package com.quora.leetcode;

public class RotateMatrix {

    static int matrix_n = 4;


    public static int[][] creatMatrix(){
        int[][] matrix = new int[matrix_n][matrix_n];
        int counter=1;
        for(int i=-0;i<matrix.length;i++){
            for(int j=0; j< matrix.length;j++){
                matrix[i][j] = counter++;
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix){
        int counter=1;
        for(int i=-0;i<matrix.length;i++){
            for(int j=0; j< matrix.length;j++){
                System.out.print(matrix[i][j] + "    ");
            }
            System.out.println();
        }
    }

    public static int[][] rotateMatrix(int[][] matrix){

        int last = matrix.length-1;
        for(int level=0;level<matrix_n/2;level++){
            for(int i=level; i< matrix.length-1;i++){
                swap(matrix, level,i,i,last);
                swap(matrix,level,i,last,last-i);
                swap(matrix,level,i,last-i,level);
            }
            System.out.println();
        }
        return matrix;
    }

    public static void swap(int[][] matrix, int i, int j, int k, int l){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[k][l];
        matrix[k][l]=temp;
    }


    public static void main(String[] args){
        int[][] matrix = creatMatrix();
        printMatrix(matrix);
        int[][] rotated = rotateMatrix(matrix);
        System.out.println();
        System.out.println( "===================== Rotated ======================");
        System.out.println();
        printMatrix(rotated);
    }
 }

 // try apporach
 // 1> transpose the metrix
// 2> reverse the rows