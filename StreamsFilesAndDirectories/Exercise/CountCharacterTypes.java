package StreamsFilesAndDirectories.Exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        String pathStr = "C:\\Users\\vikto\\Desktop\\Programing JAVA\\Java Advanced\\Advanced old\\JavaAdvancedOld\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\vikto\\Desktop\\Programing JAVA\\Java Advanced\\Advanced old\\JavaAdvancedOld\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputA.txt"));

        PrintWriter out = new PrintWriter(writer);

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        List<String> allLines = Files.readAllLines(Path.of(pathStr));

        for (String line : allLines) {
            for (int i = 0; i < line.length(); i++) {
                char current = line.charAt(i);

                if (current == 'a' || current == 'o' || current == 'e' || current == 'u'
                        || current == 'i') {
                    vowels++;
                } else if (current == '.' || current == ',' || current == '!' || current == '?') {
                    punctuation++;
                } else {
                    if (current != ' ') {
                        consonants++;
                    }
                }
            }
        }
        out.println("Vowels: " + vowels);
        out.println("Other symbols: " + consonants);
        out.println("Punctuation: " + punctuation);

        writer.close();
        out.close();
    }
}
