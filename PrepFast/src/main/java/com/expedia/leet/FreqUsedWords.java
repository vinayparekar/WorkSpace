package com.expedia.leet;

import java.util.*;

public class FreqUsedWords {

    public static void main(String[] args){
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        topKFrequent(words,3);
    }

    public static List<String> topKFrequent(String[] words, int k) {

        List<String> res = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for(String word: words){
            if(map.containsKey(word)){
                map.put(word, map.get(word) +1);
            }else{
                map.put(word,1);
            }
        }

        Set<Map.Entry<String,Integer>> set = map.entrySet();
        List<Map.Entry<String,Integer>> list = new LinkedList<>(set);
        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b){
                if(a.getValue() < b.getValue()){
                    return 1;
                }else if(a.getValue() == b.getValue()){
                    return 0;
                }else{
                    return -1;
                }
            }
        });

//        Collections.sort(list, (a,b) -> (a.getValue()<b.getValue()? 1:-1) );  //not right need more constraints

        for(Map.Entry<String,Integer> entry : list){
            if(k<=0){
                break;
            }
            k--;
            res.add(entry.getKey());
        }

        Collections.sort(res);
        return res;
    }
}
