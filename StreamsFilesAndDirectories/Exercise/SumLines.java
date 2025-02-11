package StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumLines {
    public static void main(String[] args) throws IOException {

        String pathStr = "C:\\Users\\vikto\\Desktop\\Programing JAVA\\Java Advanced\\Advanced old\\JavaAdvancedOld\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        Path path = Path.of(pathStr);

        List<String> allLines = Files.readAllLines(path);

        for (String line : allLines) {
            int sum = 0;
            for (int i = 0; i < line.length(); i++) {
                char current = line.charAt(i);
                sum += current;
            }
            System.out.println(sum);
        }

        /*allLines.stream().map(String::toCharArray).forEach(
                charArray -> {
                    int sum = 0;
                    for (char current : charArray) {
                        sum += current;
                    }
                    System.out.println(sum);
                }
        );*/
    }
}
