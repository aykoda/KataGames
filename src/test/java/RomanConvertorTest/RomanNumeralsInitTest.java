package RomanConvertorTest;

import RomanConvertor.RomanNumerals;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class RomanNumeralsInitTest {

    @Test
    public void should_TestMinAndMax_NumeralsConstrains(){
        //Act
        Boolean isTrueResult = RomanNumerals.isNumeralsConstrainsTrue(3999);
        //Assert
        assertEquals(true, isTrueResult);
    }

    @Test
    public void convert_shouldReturn1() {
        final String romanNumeral = RomanNumerals.convertRestNumeral(1);
        assertThat(romanNumeral, is("I"));
    }

    @Test
    public void convert_shouldReturn4() {

        final String romanNumeral = RomanNumerals.convertRestNumeral(4);
        assertThat(romanNumeral, is("IV"));
    }

    @Test
    public void convert_shouldReturn19() {

        final String romanNumeral = RomanNumerals.convertRestNumeral(19);
        assertThat(romanNumeral, is("XIX"));
    }
    @Test
    public void convert_shouldReturn45() {

        final String romanNumeral = RomanNumerals.convertRestNumeral(44);
        assertThat(romanNumeral, is("XLIV"));
    }
    @Test
    public void convert_shouldReturn95() {

        final String romanNumeral = RomanNumerals.convertRestNumeral(99);
        assertThat(romanNumeral, is("XCIX"));
    }

}

