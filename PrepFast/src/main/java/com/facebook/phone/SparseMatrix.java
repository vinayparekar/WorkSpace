package com.facebook.phone;

import java.util.*;

public class SparseMatrix {

    List<Map<Integer,Integer>> spaMatrix;

    public SparseMatrix(List<List<Integer>> matrix){

        spaMatrix = new LinkedList<>();
        for(int i =0 ; i< matrix.size()  ;i++){
            Map<Integer,Integer> rowmap = new LinkedHashMap<>();
            for(int j=0 ;j< matrix.get(0).size() ; j++){
                 rowmap.put(j, matrix.get(i).get(j));
            }
            spaMatrix.add(rowmap);
        }
    }

    public void printSparseMatrix(){

        for(Map map : spaMatrix){
            for(Object key : map.keySet()){
                System.out.print(map.get((Integer) key) + " ");
            }
            System.out. println();
        }
    }

    public List<Map<Integer,Integer>> getTransposeSparseMatrix(){

        List<Map<Integer,Integer>> trnSprMat = new LinkedList<>();
        // transpose logic
        return  trnSprMat;

    }

    public static  List<List<Integer>> generateRandomMatrix(int n, int m){

        List<List<Integer>> matrix = new LinkedList<>();
        for(int i=0 ; i< n ;i++){
            List<Integer> rowList = new LinkedList<>();
            for(int j=0 ; j<m ; j++){
                rowList.add((int) Math.round(Math.random()));
            }
            matrix.add(rowList);
        }
        return matrix;
    }

    public static void printMatrix(List<List<Integer>> mat){

        for(int i=0 ; i< mat.size() ;i++){
            for(int j=0 ; j<mat.get(i).size() ; j++){
                System.out.print(mat.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args ){
//        SparseMatrix spMat = new SparseMatrix()
        List<List<Integer>> mat = generateRandomMatrix(5,5);
        printMatrix(mat);

        System.out.print("\n +++++++++ creating sparse Matrix ++++++++++ \n\n");

        SparseMatrix sprMat = new SparseMatrix(mat);
        sprMat.printSparseMatrix();
    }
}
