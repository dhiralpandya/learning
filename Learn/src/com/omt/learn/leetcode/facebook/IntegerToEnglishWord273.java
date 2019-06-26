package com.omt.learn.leetcode.facebook;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class IntegerToEnglishWord273 {
    
   
     
    
    public static void main(String args[]){
        System.out.println(getWord(44));
        System.out.println(getWord(1));
        System.out.println(getWord(123));
        System.out.println(getWord(12345));
        System.out.println(getWord(1234567));
        System.out.println(getWord(1234567891));
    }
    
    public static String getWord(int number){
        String word = "";
        
        String numberString =  String.valueOf(number);
        
        if(numberString.length() < 3){
            return getTwoCharsInteger(number);
        }else if(numberString.length() == 3){
            return getThreeCharsInteger(number);
        }
        
        String thousands = THOUSANDS_MAP.get(numberString.length());
        int partition = numberString.length() - PARTITION_THOUSANDS_MAP.get(thousands); 
        String frontNumber = numberString.substring(0,partition);
        String backNumber = numberString.substring(partition,numberString.length());
        
        return getWord(Integer.parseInt(frontNumber))+" "+thousands+" "+getWord(Integer.parseInt(backNumber));
    }

    static Map<Integer,String> THOUSANDS_MAP = new TreeMap<Integer,String>(){
        {
            put(3,"Hundred");
            put(4,"Thousand");
            put(5,"Thousand");
            put(6,"Thousand");
            put(7,"Million");
            put(8,"Million");
            put(9,"Million");
            put(10,"Billion");
        }
    };

    static Map<String,Integer> PARTITION_THOUSANDS_MAP = new TreeMap<String,Integer>(){
        {
            put("Hundred",2);
            put("Thousand",3);
            put("Million",6);
            put("Billion",9);
        }
    };

    static Map<Integer,String> _1_TO_20_TENS = new TreeMap<Integer,String>(){
        {
            put(1,"One");
            put(2,"Two");
            put(3,"Three");
            put(4,"Four");
            put(5,"Five");
            put(6,"Six");
            put(7,"Seven");
            put(8,"Eight");
            put(9,"Nine");
            put(10,"Ten");
            put(11,"Eleven");
            put(12,"Twelve");
            put(13,"Thirteen");
            put(14,"Fourteen");
            put(15,"Fifteen");
            put(16,"Sixteen");
            put(17,"Seventeen");
            put(18,"Eighteen");
            put(19,"Nineteen");
            put(20,"Twenty");
            put(30,"Thirty");
            put(40,"Forty");
            put(50,"Fifty");
            put(60,"Sixty");
            put(70,"Seventy");
            put(80,"Eighty");
            put(90,"Ninety");
        }
    };

    static String getTwoCharsInteger(int number){
        if(_1_TO_20_TENS.containsKey(number)){
            return _1_TO_20_TENS.get(number);
        }

        return  getTwoCharsInteger((number/10)*10)+" "+getTwoCharsInteger(number%10);
    }

    static String getThreeCharsInteger(int number) {
        return _1_TO_20_TENS.get(number / 100) +" "+THOUSANDS_MAP.get(3)+" "+ getTwoCharsInteger(number%100);
    }
    
}
