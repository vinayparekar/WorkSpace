package com.layoff.projects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println("Hello World!");

//        Stack<String> stingStack = new Stack<>();
//        Character.isLetterOrDigit('}');
//
//        App app = new App();
//        app.printCounter();
//
//        List list = new ArrayList();
//
//        list.add(new Integer(2));
//        list.add("a String");
//
//       System.out.println(  "binary seardch location : "+Collections.binarySearch(list,2));
//
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//
        int[] states = new int[] {1,1,1,0,1,1,1,1};
        System.out.println(cellCompete(states,2));
    }

    public static int printCounter(){
        final int counter=0;
        return counter;
    }


    public static List<Integer> cellCompete(int[] states, int days)
    {
        // WRITE YOUR CODE HERE

        int[] newState = new int[states.length];

        for(int k=0; k<states.length ; k++){
            newState[k] = states[k];
        }

        for(int i=0; i<days ;i++){
            for(int j=0; j<states.length ; j++){
                if(j==0){
                    if(states[j+1] ==0){
                        newState[j] = 0;
                    }
                }else if(j==states.length-1){
                    if(states[j-1] ==0){
                        newState[j] = 0;
                    }
                }else{
                    if(states[j-1] == 0 && states[j+1] ==0){
                        newState[j] = 0;
                    }else if(states[j-1] ==1 && states[j+1] ==1){
                        newState[j] = 0;
                    }else{
                        newState[j] = 1;
                    }
                }
            }
            for(int k=0; k<states.length ; k++){
                states[k] = newState[k];
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int state : newState){
            list.add(state);
        }

        return list;
    }

}
