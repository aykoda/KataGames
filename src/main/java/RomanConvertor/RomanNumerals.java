package RomanConvertor;

import java.util.NavigableMap;
import java.util.TreeMap;

public class RomanNumerals {

    private static char FOUR = '4';
    private static char NINE = '9';

    private static final NavigableMap<Integer, String> ROMAN_NUMERALS = new TreeMap<>() {
        {
            put(0, "");
            put(1, "I");
            put(5, "V");
            put(10, "X");
            put(50, "L");
            put(100, "C");
            put(500, "D");
            put(1000, "M");
        }
    };

    public static String convertRestNumeral(int number) {
        final String result = ROMAN_NUMERALS.get(number);
        return result != null ? result : calculateRomanNumeral(number);
    }

    private static String calculateRomanNumeral(int number) {

        char irregular = String.valueOf(number).charAt(0); //number%10
        Integer lower = ROMAN_NUMERALS.lowerKey(number);
        Integer lowerKey = (irregular == NINE) ? ROMAN_NUMERALS.lowerKey(lower) : lower;
        Integer upperKey = ROMAN_NUMERALS.higherKey(number);

         if ( irregular == FOUR || irregular == NINE)
            return ROMAN_NUMERALS.get(lowerKey)
                    + ROMAN_NUMERALS.get(upperKey)
                    + convertRestNumeral(number - (upperKey-lowerKey));
        else
            return ROMAN_NUMERALS.get(lowerKey)
                    + convertRestNumeral(number - lowerKey);
    }
}