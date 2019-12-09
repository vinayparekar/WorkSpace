package com.amazon.ots;

import java.util.ArrayList;
import java.util.List;

public class CountGoStoreInBuildings {

    public static void main(String[] args){

        List<List<Integer>> grid = new ArrayList<>();
        int rows= 5;
        int columns= 5;
        for(int i=0;i<rows;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<columns;j++){
                row.add((int) Math.round(Math.random()));
                //System.out.print( row.get(j)+" ");
            }
            grid.add(row);
            System.out.println();
        }
        System.out.println();
        printGrid(grid);

        int count = countGoStoresInGrid(rows,columns,grid);
        System.out.println("GoStore Count:" +  count );
    }

    public static void printGrid(List<List<Integer>> grid){
        for(int i=0;i<grid.size();i++){
            for(int j= 0;j < grid.get(0).size(); j++){
                System.out.print( grid.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public  static int countGoStoresInGrid(int rows,int columns, List<List<Integer>> grid){
        int goCount= 0;
        if(grid.isEmpty()){
            return 0;
        }

        for(int i=0;i<grid.size();i++){
            for(int j= 0;j < grid.get(0).size(); j++){
                if(grid.get(i).get(j) ==1){
                    goCount++;
                    //grid.get(i).set(j,-1);
                    call4Directions(i,j,grid);
                }
            }
            System.out.println();
        }

        return goCount;
    }

    public static void call4Directions(int i, int j,List<List<Integer>> grid ){

        if(i>=0 && i<grid.size() && j>=0 && j<grid.get(0).size() && grid.get(i).get(j)==1){
            grid.get(i).set(j,-1);
            call4Directions(i,j-1,grid);
            call4Directions(i,j+1,grid);
            call4Directions(i-1,j,grid);
            call4Directions(i+1,j,grid);
        }

    }

}
