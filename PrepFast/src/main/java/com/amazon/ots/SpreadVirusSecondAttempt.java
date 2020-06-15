package com.amazon.ots;

import java.util.LinkedList;
import java.util.List;

public class SpreadVirusSecondAttempt {

    public static void main(String[] args){
        //create grid
        List<List<Integer>> grid = createGrid(5,4);
        int hours = getVirusPreadingTime(grid);
        System.out.println("Virus spreading time : " + hours);

    }

    public static List<List<Integer>> createGrid(int n, int m){

        List<List<Integer>> grid= new LinkedList<>();
        for(int i=0; i< n ;i++){
            List<Integer> row = new LinkedList<>();
            for(int j = 0; j< m ; j++){
                row.add((int) Math.round(Math.random()));
            }
            grid.add(row);
        }
        return grid;
    }

    public static List<List<Integer>> copyGrid(List<List<Integer>> grid){

        List<List<Integer>> cpGrid= new LinkedList<>();

        for(int i=0; i< grid.size() ;i++){
            List<Integer> row = new LinkedList<>(grid.get(i));
            cpGrid.add(row);
        }
        return cpGrid;
    }

    public static int getVirusPreadingTime(List<List<Integer>> grid){

        int hoursPassed = 1;
        //copy grid to another
       List<List<Integer>> cpGrid =  copyGrid(grid);
       boolean changesLastPass = true;

       while(changesLastPass){
           changesLastPass =false;
           for(int i = 0 ;i< cpGrid.size(); i++){
               for(int j=0; j< cpGrid.get(i).size() ; j++){
                   if(cpGrid.get(i).get(j) == 1){
                       changesLastPass = changesLastPass | spreadVirus(grid,i,j);
                   }
               }
           }
       }

       return hoursPassed;
    }

    public static boolean spreadVirus(List<List<Integer>> grid, int i, int j){
        boolean changeValue = false;
        if(i+1 >=0 && i+1< grid.size() && grid.get(i+1).get(j) == 0 ){
            grid.get(i+1).set(j,1);
            changeValue = true;
        }
        if(i-1 >=0 && i-1< grid.size() && grid.get(i-1).get(j) == 0 ){
            grid.get(i-1).set(j,1);
            changeValue = true;
        }
        if(j+1 >=0 && j+1< grid.get(0).size() && grid.get(i).get(j+1) == 0 ){
            grid.get(i).set(j+1,1);
            changeValue = true;
        }
        if(j-1 >=0 && j-1< grid.get(0).size() && grid.get(i).get(j-1) == 0 ){
            grid.get(i).set(j-1,1);
            changeValue = true;
        }
        return changeValue;
    }


}
