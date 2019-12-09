package com.google.phone;

import java.util.*;

public class PeriodicStringCheck {

    public static void main(String[] args){
    System.out.println(" \"abcabcabc\" Is periodic String : " + isPeriodicStringOf("abcabcabc",2));
    System.out.println(" \"abcabcabc\" Is periodic String : " + isPeriodicStringOf("abcabcabc",3));

    System.out.println(" \"abcabcabc\" Is periodic String of period: " + getSmallestPeriodNaive("abcabcabc"));
    System.out.println(" \"abcabcabc\" Is periodic String of period: " + getSmallestPeriodBetter("abcabcabcd"));
    System.out.println(" \"abcabcabc\" Is periodic String of period: " + getSmallestPeriodBetter("abcabcabcd abcabcabcd abcabcabcd "));
    System.out.println(" \"abcabcabc\" Is periodic String of period: " + getSmallestPeriodBetter("abcabcabcdabcabcabcdabcabcabcd"));
    System.out.println(" \"abcabcabc\" Is periodic String of period: " + getSmallestPeriodBetter("abcabcabcdabcabcabdcdabcabcabcd"));
    System.out.println(" \"abcabcabc\" Is periodic String of period: " + getSmallestPeriodBetter("abcabcabcdabcabcabcdabcabcabcdff"));
    System.out.println(" \"abcabcabc\" Is periodic String of period: " + getSmallestPeriodBetter("abcabcabcdabcabzcabcdabcabcabcd"));
//    System.out.println(" \"abcabcabc\" Is periodic String : " + getSmallestPeriodNaive("abcabcabc"));

    }

    public static boolean isPeriodicStringOf(String s, int p){
        int firstPointer = 0;
        int secondPointer = p;
        if( s == null || "".equals(s)|| s.length() <= p || s.length()%p != 0){
            return false;
        }
        while( secondPointer < s.length()){
            if(s.charAt(firstPointer) == s.charAt(secondPointer)){
                secondPointer++; firstPointer++;
            }
            else{
                return false;
            }
            if(firstPointer == p){
                firstPointer = 0;
            }
        }

        return true;
    }

    public static Integer getSmallestPeriodNaive(String s){
        int i=1;
        for( ; i< s.length() / 2 ;i++ ){
            if(isPeriodicStringOf(s,i)){
                return i;
            }
        }
        return null;
    }

    public static Integer getSmallestPeriodBetter(String s){
        // create map char and freq
        Map<Character,Integer> charFreqMap= new HashMap<>();

        for(int j=0 ; j<s.length(); j++){
            if(charFreqMap.containsKey(s.charAt(j))){
                charFreqMap.put(s.charAt(j),charFreqMap.get(s.charAt(j))+1);
            }else{
                charFreqMap.put(s.charAt(j),1);
            }
        }
        // sort based freq
        Set<Integer> values = new HashSet<>(charFreqMap.values());
        List<Integer> valueList = new ArrayList<>(values);
        Collections.sort(valueList);

        // iterator over freq values.
        for(int value : valueList){
            if( value ==1 || value > s.length() / 2){
                break;
            }else{
                // get period from value
                int period = s.length()/value;
                if(isPeriodicStringOf(s,period)){
                    return period;
                }
            }
        }
        return null;
    }
}
