package com.expedia.leet;

public class CompressString {

    public static void main(String[] args){

        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        char[] chars1 = new char[]{'a','b','c'};
        char[] chars2 = new char[]{};
        char[] chars3 = new char[]{'a','a','a','b','b','d','c','c','c'};
        char[] chars4 = {'a','a','a','b','b','d','c','c'};

        System.out.println(" Length after compression : " + compress(chars));
        System.out.println(" Length after compression : " + compress(chars1));
        System.out.println(" Length after compression : " + compress(chars2));
        System.out.println(" Length after compression : " + compress(chars3));
        System.out.println(" Length after compression : " + compress(chars4));

    }

    public static int compress(char[] letters){

        char[] res = new char[letters.length];
        int k=0;
        for(int i = 0, j=0; i <letters.length ; k++){
            while(i<letters.length && j<letters.length && letters[i] == letters[j]){
                j++;
            }
            res[k]=letters[i];
            if(j-i >1){
                while((j-i) / 10 != 0){
                    res[++k] = (char) ((j-i) / 10);
                }
                res[++k] = (char) ((j-i) % 10);
            }
            i=j;
        }

        return k;
    }
}
