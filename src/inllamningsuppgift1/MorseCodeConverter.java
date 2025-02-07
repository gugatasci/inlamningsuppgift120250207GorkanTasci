package inllamningsuppgift1;

import java.util.HashMap;
import java.util.Map;
//MorseCodeConverter: Logikklassen som hanterar omvandling mellan engelska och morsekod.

public class MorseCodeConverter {
    private static final Map<Character, String> ENGLISH_TO_MORSE = new HashMap<>();
    private static final Map<String, Character> MORSE_TO_ENGLISH = new HashMap<>();

    static {
        String[][] morseTable = {
                {"A", ".-"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."},
                {"E", "."}, {"F", "..-."}, {"G", "--."}, {"H", "...."},
                {"I", ".."}, {"J", ".---"}, {"K", "-.-"}, {"L", ".-.."},
                {"M", "--"}, {"N", "-."}, {"O", "---"}, {"P", ".--."},
                {"Q", "--.-"}, {"R", ".-."}, {"S", "..."}, {"T", "-"},
                {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"},
                {"Y", "-.--"}, {"Z", "--.."}, {"1", ".----"}, {"2", "..---"},
                {"3", "...--"}, {"4", "....-"}, {"5", "....."}, {"6", "-...."},
                {"7", "--..."}, {"8", "---.."}, {"9", "----."}, {"0", "-----"},
                {" ", "/"}
        };

        for (String[] pair : morseTable) {
            char letter = pair[0].charAt(0);
            String morse = pair[1];
            ENGLISH_TO_MORSE.put(letter, morse);
            MORSE_TO_ENGLISH.put(morse, letter);
        }
    }

    public static String toMorse(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Input text cannot be null or empty");
        }
        StringBuilder morse = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (ENGLISH_TO_MORSE.containsKey(c)) {
                morse.append(ENGLISH_TO_MORSE.get(c)).append(" ");
            } else {
                throw new IllegalArgumentException("Unsupported character: " + c);
            }
        }
        return morse.toString().trim();
    }

    public static String toEnglish(String morseCode) {
        if (morseCode == null || morseCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Input morse code cannot be null or empty");
        }
        StringBuilder text = new StringBuilder();
        for (String morseChar : morseCode.split(" ")) {
            if (MORSE_TO_ENGLISH.containsKey(morseChar)) {
                text.append(MORSE_TO_ENGLISH.get(morseChar));
            } else if (morseChar.equals("/")) {
                text.append(" ");
            } else {
                throw new IllegalArgumentException("Invalid Morse code sequence: " + morseChar);
            }
        }
        return text.toString();
    }
}
