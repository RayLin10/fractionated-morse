import java.util.*;

public class fractionatedMorse {

    public static String encode (String plaintext, Hashtable morseKey, Hashtable cipherMap, boolean verbose) {
        String morse = "", output = "";

        for (int x = 0; x < plaintext.length(); x++) {
            char currentChar = plaintext.charAt(x);
            if (currentChar == ' ')
                morse += "x";
            else {
                morse += morseKey.get(currentChar);
                if (x != plaintext.length() - 1)
                    morse += "x";
                if (verbose) {
                    System.out.println(currentChar + " -> " + "\"" + morseKey.get(currentChar) + "\"");
                    System.out.println("Current Morse: " + morse);
                }
            }
        }

        while ((morse.length() % 3) != 0) {
            morse += "x";
        }

        if (verbose)
            System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Morse: " + morse);

        if (verbose)
            System.out.println("--------------------------------------------------------------------------------");

        for (int x = 0; x < morse.length(); x += 3) {
            String compare = morse.substring(x, x + 3);
            output += cipherMap.get(compare);
            if (verbose) {
                System.out.println("\"" + compare + "\"" + " -> " + cipherMap.get(compare));
                System.out.println("Current Ciphertext: " + output);
            }
        }

        if (verbose)
            System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Ciphertext: " + output);

        return output;
    }

    public static String decode (String ciphertext, Hashtable morseKey, Hashtable cipherMap, boolean verbose) {
        String morse = "", output = "";

        for (int x = 0; x < ciphertext.length(); x++) {
            morse += cipherMap.get(ciphertext.charAt(x));
            if (verbose) {
                System.out.println(ciphertext.charAt(x) + " -> " + "\"" + cipherMap.get(ciphertext.charAt(x)) + "\"");
                System.out.println("Current Morse: " + morse);
            }
        }

        if (verbose)
            System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Morse: " + morse);

        if (verbose)
            System.out.println("--------------------------------------------------------------------------------");

        while (morse.charAt(morse.length() - 1) == 'x') {
            morse = morse.substring(0, morse.length() - 1);
        }

        while (morse.contains("x")) {
            int index = morse.indexOf("x");
            String tempMorse = morse.substring(0, index);
            output += morseKey.get(tempMorse);
            if (verbose) {
                System.out.println("\"" + tempMorse + "\"" + " -> " + morseKey.get(tempMorse));
                System.out.println("Current Plaintext: " + output);
            }
            if (morse.charAt(index + 1) == 'x') {
                output += " ";
                morse = morse.substring(index + 2);
            }
            else
                morse = morse.substring(index + 1);
        }

        output += morseKey.get(morse);
        if (verbose) {
            System.out.println("\"" + morse + "\"" + " -> " + morseKey.get(morse));
            System.out.println("Current Plaintext: " + output);
            System.out.println("--------------------------------------------------------------------------------");
            }

        System.out.println("Plaintext: " + output);

        return output;
    }

    public static void main (String[] args) {

        if (args.length < 3) {
            System.exit(0);
        }

        boolean encode = false, decode = false, verbose = false;
        String key = args[1]; 
        String inputText = args[2];

        if (args[0].equals("encode")) {
            encode = true;
        }
        if (args[0].equals("decode")) {
            decode = true;
        }
        if (args.length > 3)
            if (args[3].equals("verbose")) {
                verbose = true;
            }
        
        inputText = inputText.toUpperCase();
        key = key.toUpperCase();

        System.out.println("Input: " + inputText);
        System.out.println("Key: " + key);
        if (verbose)
            System.out.println("--------------------------------------------------------------------------------");

        char[] textChar = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 
            'Z', '.', ',', ':', '"', '\'', '!', '?', '@', '-', ';', '(', ')', '=', '1', 
            '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        String[] morseCode = new String[] {".-", "-...", "-.-.", "-..", ".", "..-.", 
            "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", 
            ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".-.-.-", 
            "--..--", "---...", ".-..-.", ".----.", "-.-.--", "..--..", ".--.-.", "-....-", 
            "-.-.-.", "-.--.", "-.--.-", "-...-", ".----", "..---", "...--", "....-", 
            ".....", "-....", "--...", "---..", "----.", "-----"};
        Hashtable<Character, String> morseKey = new Hashtable<>(49, 1.0f);
        for (int x = 0; x < 49; x++) {
            morseKey.put(textChar[x], morseCode[x]);
        }
        Hashtable<String, Character> reverseMorse = new Hashtable<>(49, 1.0f);
        for (int x = 0; x < 49; x++) {
            reverseMorse.put(morseCode[x], textChar[x]);
        }

        String[] mapConstant = new String[] {"...", "..-", "..x", ".-.", ".--", ".-x", 
            ".x.", ".x-", ".xx", "-..", "-.-", "-.x", "--.", "---", "--x", "-x.", "-x-", 
            "-xx", "x..", "x.-", "x.x", "x-.", "x--", "x-x", "xx.", "xx-"};
        Hashtable<Character, String> map = new Hashtable<>(26, 1.0f);
        for (int x = 0; x < 26; x++) {
            map.put(key.charAt(x), mapConstant[x]);
            if (verbose)
                System.out.println(key.charAt(x) + " | " + "\"" + mapConstant[x] + "\"");
        }
        Hashtable<String, Character> reverseMap = new Hashtable<>(26, 1.0f);
        for (int x = 0; x < 26; x++) {
            reverseMap.put(mapConstant[x], key.charAt(x));
        }

        if (verbose)
            System.out.println("--------------------------------------------------------------------------------");

        if (encode == true) 
            encode(inputText, morseKey, reverseMap, verbose);
        if (decode == true)
            decode(inputText, reverseMorse, map, verbose);
    }
}