package StreamsFilesAndDirectories.Exercise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicInteger;

public class LineNumbers {
    public static void main(String[] args) throws IOException {

        String pathStr = "C:\\Users\\vikto\\Desktop\\Programing JAVA\\Java Advanced\\Advanced old\\JavaAdvancedOld\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\vikto\\Desktop\\Programing JAVA\\Java Advanced\\Advanced old\\JavaAdvancedOld\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputLineNumbers.txt"));

        AtomicInteger count = new AtomicInteger(1);
        Files.readAllLines(Path.of(pathStr)).forEach(
                line -> {
                    try {
                        writer.write(count + ". " + line + "\n");
                        count.getAndIncrement();

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        writer.close();
    }
}
