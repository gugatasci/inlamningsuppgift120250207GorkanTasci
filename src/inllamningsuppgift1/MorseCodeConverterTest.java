package inllamningsuppgift1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MorseCodeConverterTest {

    @Test
    public void testToMorse() {
        assertEquals(".-", MorseCodeConverter.toMorse("A"));
        assertEquals(".... . .-.. .-.. ---", MorseCodeConverter.toMorse("HELLO"));
        assertEquals("... --- ...", MorseCodeConverter.toMorse("SOS"));
    }

    @Test
    public void testToEnglish() {
        assertEquals("A", MorseCodeConverter.toEnglish(".-"));
        assertEquals("HELLO", MorseCodeConverter.toEnglish(".... . .-.. .-.. ---"));
        assertEquals("SOS", MorseCodeConverter.toEnglish("... --- ..."));
    }

    @Test
    public void testWhitespaceHandling() {
        assertEquals("HELLO WORLD", MorseCodeConverter.toEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -.."));
    }

    @Test
    public void testLowerCaseHandling() {
        assertEquals("HELLO", MorseCodeConverter.toMorse("hello"));
    }

    @Test
    public void testUnknownCharacterHandling() {
        assertEquals("", MorseCodeConverter.toMorse("#"));
    }
}
