package StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        Path first = Path.of("C:\\Users\\vikto\\Desktop\\Programing JAVA\\Java Advanced\\Advanced old\\JavaAdvancedOld\\" +
        "04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");

        Path second = Path.of("C:\\Users\\vikto\\Desktop\\Programing JAVA\\Java Advanced\\Advanced old\\JavaAdvancedOld\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");

        List<String> allLinesFirst = Files.readAllLines(first);
        List<String> allLinesSecond = Files.readAllLines(second);

        PrintWriter writer = new PrintWriter("C:\\Users\\vikto\\Desktop\\Programing JAVA\\Java Advanced\\Advanced old\\JavaAdvancedOld\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputB.txt");

        allLinesFirst.forEach(writer::println);
        allLinesSecond.forEach(writer::println);

        writer.close();
    }
}
