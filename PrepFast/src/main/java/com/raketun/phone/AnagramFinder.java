package com.raketun.phone;

import java.util.*;

public class AnagramFinder {

    static Set<String> dict = new HashSet<>();

    public static void main(String[] args) {
        dict.addAll(Arrays.asList(new String[]{"rat","cat", "bat","art","tar"}));
        List<String> result = getAllAnagrams(dict, "rat");
    }

    public static List<String> getAllAnagrams(Set<String> dict, String given){

        if(given == null ){
            return Collections.emptyList();
        }

        List<String> res = new ArrayList<>();

        Map<Character,Integer> givenCharMap = new HashMap<>();

        for(Character c : given.toCharArray()){
            if(givenCharMap.containsKey(c)){
                givenCharMap.put(c, givenCharMap.get(c) +1);
            }else{
                givenCharMap.put(c,1);
            }
        }

        for(String word : dict){

            if(word.length() == given.length() && word != given){
                boolean anagramFlag = true;

                Map<Character,Integer> wordCharMap = new HashMap<>(givenCharMap);

                for(char c : word.toCharArray()){
                    if(wordCharMap.containsKey(c)){
                        wordCharMap.put(c,wordCharMap.get(c)-1);
                    }else{
                        anagramFlag = false;
                        break;
                    }
                }

                for(Map.Entry<Character,Integer> entry : wordCharMap.entrySet()){
                    if(entry.getValue() != 0 ){
                        anagramFlag = false;
                        break;
                    }
                }

                if(anagramFlag){
                    res.add(word);
                }

                wordCharMap.clear();
            }
        }


        return res;
    }
}
