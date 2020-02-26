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

    private void createZeroSparseMatrix(List<Map<Integer,Integer>> zroSprMatrix){

        for(int i =0 ; i< this.columns  ;i++){
            Map<Integer,Integer> rowmap = new LinkedHashMap<>();
            zroSprMatrix.add(rowmap);
        }
    }

    public List<Map<Integer,Integer>> getTransposeSparseMatrix(){

        List<Map<Integer,Integer>> trnSprMat = new LinkedList<>();
        //create zero transpose matrix
        createZeroSparseMatrix(trnSprMat);
        // transpose logic
        for(int i=0 ; i< spaMatrix.size() ; i++){
            for(Object key : spaMatrix.get(i).keySet()){
                trnSprMat.get((Integer) key).put(i, spaMatrix.get(i).get((Integer) key));
            }
        }
        return  trnSprMat;
    }


    public SparseMatrix multiplySparseMatrix(SparseMatrix secMat){

        List<Map<Integer,Integer>> resultMat = new LinkedList<>();
        if(this.columns == secMat.rows){
            for(Map<Integer,Integer> map : this.spaMatrix){
                Map<Integer,Integer> row = new LinkedHashMap<>();
                for(int i=0; i< secMat.columns ; i++){
                    int value=0;
                    for(int j=0;j< this.columns; j++){
                        if(map.get(j) !=null && secMat.spaMatrix.get(j).get(i) !=null){
                            value = value + map.get(j) * secMat.spaMatrix.get(j).get(i);
                        }
                    }
                    if(value !=0){
                        row.put(i,value);
                    }

                }
                resultMat.add(row);
            }
        }else {
            System.out.println(" Operation not possible");
        }

        return new SparseMatrix(resultMat,resultMat.size(),resultMat.get(0).size());
    }

    public static  List<List<Integer>> generateRandomMatrix(int rows, int columns){

        List<List<Integer>> matrix = new LinkedList<>();
        for(int i=0 ; i< rows ;i++){
            List<Integer> rowList = new LinkedList<>();
            for(int j=0 ; j<columns ; j++){
                rowList.add((int) Math.round(Math.random() *10) /3 );
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

    public static List<List<Integer>> getTranspose(List<List<Integer>> mat){
        List<List<Integer>> trnMat = new LinkedList<>();

        //trnsp logic
        for(int i=0; i< mat.get(0).size() ; i++){
            List<Integer> row = new LinkedList<>();
            for(int j=0 ; j < mat.size() ; j++){
                row.add(mat.get(j).get(i));
            }
            trnMat.add(row);
        }
        return trnMat;
    }

    public static List<List<Integer>> getMultiplication(List<List<Integer>> mat1, List<List<Integer>> mat2){
        List<List<Integer>> multiMat = new LinkedList<>();

        if(mat1.get(0).size() == mat2.size()){
            for(int i=0; i< mat1.size() ; i++){
                List<Integer> row = new LinkedList<>();
                for(int j=0; j< mat2.get(0).size() ; j++){
                    int value = 0;
                    for(int k=0 ; k < mat1.get(0).size();k++){
                        value = value + mat1.get(i).get(k) * mat2.get(k).get(j);
                    }
                    row.add(value);
                }
                multiMat.add(row);
            }
        }else{
            throw new IllegalArgumentException(" \n This can not be done. need mat1 and mat2 in n*m and m*l format to produce n*l matrix ");
        }

        return multiMat;
    }

    public static void main(String[] args ){

        // printing original matrix
        System.out.println(" ++++++++++++++ New Generated Matrix : => \n");
        List<List<Integer>> mat = generateRandomMatrix(5,4);
        printMatrix(mat);

        System.out.print("\n +++++++++ creating sparse Matrix ++++++++++ \n\n");
        SparseMatrix sprMat = new SparseMatrix(mat);
        printSparseMatrix(sprMat.spaMatrix);

        //Getting Transpose
        System.out.println(" \n +++++++++++++++ Getting Transpose of Given Matrix => \n");
        List<List<Integer>> transpMat = getTranspose(mat);
        printMatrix(transpMat);

        System.out.print("\n +++++++++ creating transpose of sparse Matrix ++++++++++ \n\n");
        List<Map<Integer,Integer>> trnspMat =  sprMat.getTransposeSparseMatrix();
        SparseMatrix trnspSprMat = new SparseMatrix(trnspMat, sprMat.columns, sprMat.rows );
        printSparseMatrix(trnspSprMat.spaMatrix);

        //Getting Multiplication of given matrix and it's transpose
        System.out.println(" \n +++++++++++++++ Getting multiplication of Given Matries => \n");
        List<List<Integer>> multiMat = getMultiplication(mat,transpMat);
        printMatrix(multiMat);

        System.out.print("\n +++++++++ Doing Multiplication of sparse Matrix ++++++++++ \n\n");
        SparseMatrix multSparseMat = sprMat.multiplySparseMatrix(trnspSprMat);
        printSparseMatrix(multSparseMat.spaMatrix);
    }
}
