package RomanConvertorTest;
import RomanConvertor.*;

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

