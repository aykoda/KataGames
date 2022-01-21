

import java.util.NavigableMap;
import java.util.TreeMap;

public class RomanNumerals {

    private static final NavigableMap<Integer, String> ROMAN_NUMERALS = new TreeMap<>() {
        {
            put(1, "I");
            put(5, "V");
            put(10, "X");
            put(50, "L");
            put(100, "C");
            put(500, "D");
            put(1000, "M");
        }
    };

    public static String convert(int number) {
        final String result = ROMAN_NUMERALS.get(number);
        return result != null ? result : calculateRomanNumeral(number);
    }

    private static String calculateRomanNumeral(int number) {
        final Integer lowerKey = ROMAN_NUMERALS.lowerKey(number);
        final Integer lowerLowerKey = ROMAN_NUMERALS.lowerKey(lowerKey);
        final Integer upperKey = ROMAN_NUMERALS.higherKey(number);

        if (number==4)
            return ROMAN_NUMERALS.get(lowerKey) + ROMAN_NUMERALS.get(upperKey);
        else if (number==9)
            return ROMAN_NUMERALS.get(lowerLowerKey) + ROMAN_NUMERALS.get(upperKey);
        else if (String.valueOf(number).charAt(0) =='4')
            return ROMAN_NUMERALS.get(lowerKey) + ROMAN_NUMERALS.get(upperKey) +convert(number - (upperKey-lowerKey));
        else if (String.valueOf(number).charAt(0) =='9')
           return ROMAN_NUMERALS.get(lowerLowerKey) + ROMAN_NUMERALS.get(upperKey) + convert(number - (upperKey-lowerLowerKey));

        return ROMAN_NUMERALS.get(lowerKey) + convert(number - lowerKey);
    }
}