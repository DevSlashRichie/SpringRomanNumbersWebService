package io.github.ricardormdev.springwebservice.Utils;

import io.github.ricardormdev.springwebservice.Errors.IncompatibleLetterError;

import java.util.Hashtable;
import java.util.TreeMap;

public class RomanNumber {
    private final static TreeMap<Integer, String> map = new TreeMap<>();
    private final static Hashtable<Character, Integer> reverseMap = new Hashtable<>();

    
    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        map.put(0, "");

        reverseMap.put('I',1);
        reverseMap.put('X',10);
        reverseMap.put('C',100);
        reverseMap.put('M',1000);
        reverseMap.put('V',5);
        reverseMap.put('L',50);
        reverseMap.put('D',500);

    }

    public static String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }

    public static int toInt(String romanNumber) {
        int finalNumber = 0;
        int previousNumber = 0;

        for(int i = romanNumber.length()-1; i>=0 ; i--) {
            if(!reverseMap.containsKey(romanNumber.charAt(i))) {
                throw new IncompatibleLetterError(romanNumber);
            }
            int currentNumber = reverseMap.get(romanNumber.charAt(i));

            if(currentNumber < previousNumber)
                finalNumber -= currentNumber;
            else
                finalNumber += currentNumber;

            previousNumber = currentNumber;
        }

        return finalNumber;
    }
}
