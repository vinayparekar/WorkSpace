package com.raketun.phone;

import java.util.Set;
import java.util.TreeSet;

public class FinallyTest {

    public static void main(String[] args) {

        question1();
        question2();

        // print day set. what will be the result
    }

    public static int getReturn(){
        try{
            throw new RuntimeException("");
        }catch (Exception e){
            return 1;
        }finally{
            return 2;
        }
    }

    public static void question1(){
        System.out.println(getReturn());
    }

    enum Day{
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
    }

    public static void question2(){
        Set<Day> daySet = new TreeSet<>();
        daySet.add(Day.Wednesday);
        daySet.add(Day.Thursday);
        daySet.add(Day.Friday);
        daySet.add(Day.Wednesday);

        for (Day day:daySet) {
            System.out.print(day + ", ");
        }
    }

}
