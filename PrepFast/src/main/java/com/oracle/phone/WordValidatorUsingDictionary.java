package com.oracle.phone;

import java.util.*;

public class WordValidatorUsingDictionary {

    /*
        Oracle Phone Interview [ July 31st ] :

        Given a world check if you can break it with the valid words in the dictionary

        word : “Haveaniceday”    dictionary : [ Have, a , nice, day].  => true
        word : “catsandog”    dictionary : [ cat, sand ,dog ]. => false
        word : “catsandog”    dictionary : [ cats, sand, and ,dog ]. => false
        word : “catsandog”    dictionary : [ cats, sand, an ,dog ]. => false
        word : “caterpillar”    dictionary : [ cat,piller]. => fase
        word : “caterpillar”    dictionary : [ cat,piller, caterpiller]. => true


        Its a DP problem.
     */


    public static void main(String[] args){
        String[] dict_Arr = new String[]{"Have", "a" , "nice", "day" };
        String[] dict_Arr1 = new String[]{"cat","sand","dog" };
        String[] dict_Arr2 = new String[]{"cats", "sand", "and" ,"dog" };
        String[] dict_Arr3 = new String[]{"cats", "sand", "an" ,"dog" };
        String[] dict_Arr4 = new String[]{"cat","pillar" };
        String[] dict_Arr5 = new String[]{"cat","pillar", "caterpillar" };

        List<String> dict = Arrays.asList(dict_Arr);
        System.out.println(" Haveaniceday is " + checkWordValidity(dict, "Haveaniceday") + " word of dictionary");

        dict = Arrays.asList(dict_Arr1);
        System.out.println(" catsandog is " + checkWordValidity(dict, "catsandog") + " word of dictionary");

        dict = Arrays.asList(dict_Arr2);
        System.out.println(" catsandog is " + checkWordValidity(dict, "catsandog") + " word of dictionary");

        dict = Arrays.asList(dict_Arr3);
        System.out.println(" catsandog is " + checkWordValidity(dict, "catsandog") + " word of dictionary");

        dict = Arrays.asList(dict_Arr4);
        System.out.println(" caterpillar is " + checkWordValidity(dict, "caterpillar") + " word of dictionary");

        dict = Arrays.asList(dict_Arr5);
        System.out.println(" caterpillar is " + checkWordValidity(dict, "caterpillar") + " word of dictionary");

    }

    private static boolean checkWordValidity(List<String> dict, String word) {

        boolean checkFlag;
        Stack<Integer> j_stack = new Stack<>();
        Map<Integer,Set<Integer>> j_seens = new HashMap<>();

        int i=0, j=i;
        while(true){
            for(; j<= word.length() ; j++ ){
                if(dict.contains(word.substring(i,j)) ) {
                    if(!j_seens.containsKey(i)){
                        j_seens.put(i, new HashSet<Integer>());
                    }

                    if (!j_seens.get(i).contains(j)) {
                        j_stack.push(i);
                        j_seens.get(i).add(j);
                        i = j;
                        continue;
                    }
                }
            }
            if( i== word.length()){
                checkFlag = true;
                break;
            }else{
                if(j_stack.empty()){
                    return false;
                }
                i = j_stack.pop();
                j=i;
            }

        }

        return checkFlag;
    }


}
