
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.junit.Assert.*;

public class RomanNumeralsTest {

    @ParameterizedTest
    @MethodSource("parametersGenerator")
    public void convert_NumeralsToRoman_isTrue(Integer numerals,String expRoman){
        //Act
        String resultRoman = RomanNumerals.convertRestNumeral(numerals);

        //Assert
        assertEquals(resultRoman, expRoman);
    }

    private static Stream<Arguments> parametersGenerator() {
        return Stream.of(
                Arguments.of(1, "I"),
                Arguments.of(4, "IV"),
                Arguments.of(5, "V"),
                Arguments.of(9, "IX"),
                Arguments.of(10, "X"),
                Arguments.of(50, "L"),
                Arguments.of(100, "C"),
                Arguments.of(500, "D"),
                Arguments.of(1000, "M")
        );
    }

        @ParameterizedTest
        @MethodSource("parametersGenerator2")
        public void convert_NumeralsToRoman_isTrueOrFalse(Integer numerals,String expRoman, boolean boolExpected){
            //Act
            String resultRoman = RomanNumerals.convertRestNumeral(numerals);
            //System.out.println(resultRoman+" "+expRoman);

            //Assert
            assertEquals(resultRoman.contentEquals(expRoman), boolExpected);
        }
        private static Stream<Arguments> parametersGenerator2() {
            return Stream.of(
                    Arguments.of(685,"DCLXXXV", true),
                    Arguments.of(94,"XCIV", true),
                    Arguments.of(49,"XLIX", true),
                    Arguments.of(837,"DCCCXXXVII", true),
                    Arguments.of(47,"XLI", false),
                    Arguments.of(44,"XLIV", true),            //assertTrue
                    Arguments.of(45,"XLIV", false)            //assertFalse
            );
        }
    }


/*
    @Test
    public void convert_shouldReturn1() {

     Map<Integer, String> expected = new HashMap<>() {
            {
                put(1, "I");
                put(5, "V");
                put(10, "X");
                put(50, "L");
                put(100, "C");
                put(500, "D");
                put(1000, "M");
            }};

        //System.out.println(expected.entrySet().toArray()[0]);
        //Arguments.of(new HashMap<Integer, String>() {{put(1, "I");}});

        //Integer numerals =Integer.parseInt(params.keySet().toArray()[0].toString());
        //String expRoman =params.values().toArray()[0].toString();

        final String romanNumeral = RomanNumerals.convert(1);

        assertThat(romanNumeral, is("I"));
    }

    @Test
    public void convert_shouldReturn4() {

        final String romanNumeral = RomanNumerals.convert(4);

        assertThat(romanNumeral, is("IV"));
    }

    @Test
    public void convert_shouldReturn19() {

        final String romanNumeral = RomanNumerals.convert(19);

        assertThat(romanNumeral, is("XIX"));
    }
    @Test
    public void convert_shouldReturn45() {

        final String romanNumeral = RomanNumerals.convert(44);

        assertThat(romanNumeral, is("XLIV"));
    }
    @Test
    public void convert_shouldReturn95() {

        final String romanNumeral = RomanNumerals.convert(99);

        assertThat(romanNumeral, is("XCIX"));
    }

 */

