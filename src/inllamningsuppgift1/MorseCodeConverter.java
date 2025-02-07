package inllamningsuppgift1;
//Importerar klasser: HashMap och Map används för att lagra konverteringstabellerna mellan engelska bokstäver och morsekod.
import java.util.HashMap;
import java.util.Map;
//MorseCodeConverter: Logikklassen som hanterar omvandling mellan engelska och morsekod.och 2 felhanteringar

public class MorseCodeConverter {
    private static final Map<Character, String> ENGLISH_TO_MORSE = new HashMap<>();
    private static final Map<String, Character> MORSE_TO_ENGLISH = new HashMap<>();
//Morse-tabellen: En tvådimensionell array där varje rad innehåller en bokstav/siffra och dess motsvarande morsekod.
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
//Loop som fyller HashMaps:
//pair[0] innehåller bokstaven/siffran.
//pair[1] innehåller motsvarande morsekod.
//Lägger till värden i ENGLISH_TO_MORSE (för att konvertera engelska till morsekod).
//Lägger till värden i MORSE_TO_ENGLISH (för att konvertera morsekod till engelska).
        for (String[] pair : morseTable) {
            char letter = pair[0].charAt(0);
            String morse = pair[1];
            ENGLISH_TO_MORSE.put(letter, morse);
            MORSE_TO_ENGLISH.put(morse, letter);
        }
    }
//två felhanteringar:
//
//Hantera tom eller null inmatning – Kastar ett IllegalArgumentException om input är tom eller null.
//Hantera ogiltiga tecken – Kastar ett IllegalArgumentException om en användare försöker konvertera
// en bokstav eller symbol som inte stöds.

    public static String toMorse(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Input text cannot be null or empty");
        }

       //Konvertering:
        //Gör om texten till stora bokstäver (morsekod är skiftlägesokänsligt).
        //Går igenom varje tecken och letar upp motsvarande morsekod i ENGLISH_TO_MORSE.
        //Om tecknet inte finns i kartan, kastas ett undantag (förhindrar att okända tecken orsakar problem).
        //Returnerar den konverterade morsekoden.

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

        //Konvertering:
        //Delar upp morsekoden med split(" ") för att hantera varje symbol individuellt.
        //Kollar om symbolen finns i MORSE_TO_ENGLISH och lägger till motsvarande bokstav.
        //Hanterar mellanslag ("/" i morsekod översätts till ett mellanslag i text).
        //Om en ogiltig morsekod hittas, kastas ett undantag.
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
//Sammanfattning
//HashMaps används för snabb konvertering mellan engelska och morsekod.
//Statisk initialisering fyller kartorna vid programmets start.
//Felhantering ser till att endast giltig inmatning accepteras.
//Metoderna konverterar mellan engelska och morsekod genom att slå upp tecken i kartorna.