package com.amazon.ots;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// WRONG solution

public class SpreadVirusToAllServers {

    public static void main(String[] args){
        int rows= 5;
        int columns= 5;
        List<List<Integer>> serverGrid = createServerGrid(rows,columns);
        CountGoStoreInBuildings.printGrid(serverGrid);
        int hours= getVirusSpreadingHours(serverGrid);
        System.out.println();
        CountGoStoreInBuildings.printGrid(serverGrid);

        System.out.println(" Hours taken by algo to spread the virus : " + hours);
    }

    public static List<List<Integer>> createServerGrid(int rows, int columns){
        List<List<Integer>> grid = new ArrayList<>();

        for(int i=0;i<rows;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<columns;j++){
                row.add((int) Math.round(Math.random()));
            }
            grid.add(row);
        }
        return grid;
    }

    public static int getVirusSpreadingHours(List<List<Integer>> grid){

        if(grid.isEmpty()) {
            return 0;
        }

        int hours = 0;
        boolean change = true;

        List<List<Integer>> copyGrid = new ArrayList<>();
        copyGrid(copyGrid,grid);

        while(change){
            change = false;
            for(int i=0;i<grid.size();i++){
                for(int j=0;j<grid.get(0).size();j++) {
                    if(grid.get(i).get(j) == 1){
                        change = change || spread4Sides(i,j,copyGrid);
                    }
                }
            }
            if(!change){
                break;
            }
            hours++;

            System.out.println();
            CountGoStoreInBuildings.printGrid(copyGrid);
            copyGrid(grid,copyGrid);
            //Collections.copy(grid,copyGrid);
        }

        return hours;
    }

    public static boolean spread4Sides(int i, int j, List<List<Integer>> grid){

        boolean change = false;
        if(i-1>=0 && i-1<grid.size() && j>=0 && j<grid.get(0).size() && grid.get(i-1).get(j) == 0){
            grid.get(i-1).set(j,1);
            change =true;
        } if(i+1>=0 && i+1<grid.size() && j>=0 && j<grid.get(0).size() && grid.get(i+1).get(j) == 0){
            grid.get(i+1).set(j,1);
            change =true;
        } if(i>=0 && i<grid.size() && j-1>=0 && j-1<grid.get(0).size() && grid.get(i).get(j-1) == 0){
            grid.get(i).set(j-1,1);
            change =true;
        } if(i>=0 && i<grid.size() && j+1>=0 && j+1<grid.get(0).size() && grid.get(i).get(j+1) == 0){
            grid.get(i).set(j+1,1);
            change =true;
        }

        return change;
    }

    public static void copyGrid(List<List<Integer>> tarGrid, List<List<Integer>> sourceGrid){

        List<List<Integer>> newGrid = new ArrayList<>();
        for(List<Integer> list : sourceGrid){
            List<Integer> row = new ArrayList<>();
            for(int value : list){
                row.add(value);
            }
            newGrid.add(row);
        }
        tarGrid.clear();
        tarGrid.addAll(newGrid);

    }



}
