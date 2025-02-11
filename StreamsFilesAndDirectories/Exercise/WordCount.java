package StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {

        Path pathToWords = Path.of("C:\\Users\\vikto\\Desktop\\Programing JAVA\\Java Advanced\\Advanced old\\JavaAdvancedOld\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");

        Map<String, Integer> wordsCount = new LinkedHashMap<>();

        List<String> allLinesWords = Files.readAllLines(pathToWords);

        allLinesWords.forEach(line ->
                Arrays.stream(line.split("\\s+"))
                        .forEach(word -> wordsCount.put(word, 0)));

        Path pathText = Path.of("C:\\Users\\vikto\\Desktop\\Programing JAVA\\Java Advanced\\Advanced old\\JavaAdvancedOld\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");

        List<String> allLinesText = Files.readAllLines(pathText);

        for (String lines : allLinesText) {
            String[] wordsInLine = lines.split("\\s+");

            Arrays.stream(wordsInLine).forEach(word -> {
                        if (wordsCount.containsKey(word)) {
                            int current = wordsCount.get(word);
                            wordsCount.put(word, current + 1);
                        }
                    }
            );
        }
        wordsCount.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        PrintWriter writer = new PrintWriter("C:\\Users\\vikto\\Desktop\\Programing JAVA\\Java Advanced\\Advanced old\\JavaAdvancedOld\\" +
        "04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\results.txt");

        wordsCount.entrySet().forEach(entry -> writer.println(entry.getKey() + " - " + entry.getValue()));
        writer.close();
    }
}
