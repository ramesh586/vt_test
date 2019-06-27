package ct.virtusa;

import org.junit.Test;
import static org.junit.Assert.*;


public class NumberToWordConversionUnitTest {

    @Test
    public void whenMoneyNegative_thenReturnInvalidInput() {
        assertEquals(NumberToWordConversion.INVALID_INPUT_GIVEN, NumberToWordConversion.getMoneyIntoWords(-13));
    }

    @Test
    public void whenZeroGiven_thenReturnEmptyString() {
        assertEquals("zero", NumberToWordConversion.getMoneyIntoWords(0));
    }

    @Test
    public void whenOnlyGiven_thenReturnWords() {
        assertEquals("one", NumberToWordConversion.getMoneyIntoWords(1));
    }

    
    @Test
    public void whenAlmostAMillionGiven_thenReturnWords() {
        String expectedResult = "nine hundred and ninety nine thousand nine hundred and ninety nine";
        assertEquals(expectedResult, NumberToWordConversion.getMoneyIntoWords(999_999));
    }
    
    @Test
    public void whenThirtyMillionGiven_thenReturnWords() {
        String expectedResult = "thirty three million three hundred and forty eight thousand nine hundred and seventy eight";
        assertEquals(expectedResult, NumberToWordConversion.getMoneyIntoWords(33_348_978));
    }
    
    @Test
    public void whenMoreThanHundredMillionGiven_thenReturnWords() {
        String expectedResult = "one hundred and thirty three million two hundred and forty seven thousand eight hundred and ten";
        assertEquals(expectedResult, NumberToWordConversion.getMoneyIntoWords(133_247_810));
    }

}