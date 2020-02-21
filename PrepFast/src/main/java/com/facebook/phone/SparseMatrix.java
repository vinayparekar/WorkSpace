package com.facebook.phone;

import java.util.*;

public class SparseMatrix {

    List<Map<Integer,Integer>> spaMatrix;
    int rows;
    int columns;

    SparseMatrix(List<List<Integer>> matrix){

        spaMatrix = new LinkedList<>();
        for(int i =0 ; i< matrix.size()  ;i++){
            Map<Integer,Integer> rowmap = new LinkedHashMap<>();
            for(int j=0 ;j< matrix.get(0).size() ; j++){
                if(matrix.get(i).get(j) !=0 ){
                    rowmap.put(j, matrix.get(i).get(j));
                }
            }
            spaMatrix.add(rowmap);
        }

        rows = matrix.size();
        columns = matrix.get(0).size();
    }

    SparseMatrix(List<Map<Integer,Integer>> matrix, int rows, int columns){

        spaMatrix = new LinkedList<>();
        for(int i =0 ; i< rows  ;i++){
            Map<Integer,Integer> rowmap = new LinkedHashMap<>();
            rowmap.putAll(matrix.get(i));
            spaMatrix.add(rowmap);
        }

        this.rows = rows;
        this.columns = columns;
    }

    public static void printSparseMatrix(List<Map<Integer,Integer>> spaMatrix){

        for(Map map : spaMatrix){
            for(Object key : map.keySet()){
                System.out.print("[" +key + " -> " +map.get((Integer) key) + "] ");
            }
            System.out. println();
        }
    }

    public void createZeroSparseMatrix(List<Map<Integer,Integer>> zroSprMatrix, int rows, int columns){

        for(int i =0 ; i< rows  ;i++){
            Map<Integer,Integer> rowmap = new LinkedHashMap<>();
            zroSprMatrix.add(rowmap);
        }
    }

    public List<Map<Integer,Integer>> getTransposeSparseMatrix(){

        List<Map<Integer,Integer>> trnSprMat = new LinkedList<>();
        //create zero transpose matrix
        createZeroSparseMatrix(trnSprMat, columns, rows);
        // transpose logic
        for(int i=0 ; i< spaMatrix.size() ; i++){
            for(Object key : spaMatrix.get(i).keySet()){
                trnSprMat.get((Integer) key).put(i, spaMatrix.get(i).get((Integer) key));
            }
        }
        return  trnSprMat;

    }

    public static  List<List<Integer>> generateRandomMatrix(int rows, int columns){

        List<List<Integer>> matrix = new LinkedList<>();
        for(int i=0 ; i< rows ;i++){
            List<Integer> rowList = new LinkedList<>();
            for(int j=0 ; j<columns ; j++){
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
        List<List<Integer>> mat = generateRandomMatrix(5,4);
        printMatrix(mat);

        System.out.print("\n +++++++++ creating sparse Matrix ++++++++++ \n\n");

        SparseMatrix sprMat = new SparseMatrix(mat);
        printSparseMatrix(sprMat.spaMatrix);

        System.out.print("\n +++++++++ creating transpose of sparse Matrix ++++++++++ \n\n");
        List<Map<Integer,Integer>> trnspMat =  sprMat.getTransposeSparseMatrix();
        SparseMatrix trnspSprMat = new SparseMatrix(sprMat.getTransposeSparseMatrix(), trnspMat.size(), trnspMat.get(0).size() );
        printSparseMatrix(trnspSprMat.spaMatrix);
    }
}
