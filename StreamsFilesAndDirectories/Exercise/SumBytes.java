package StreamsFilesAndDirectories.Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumBytes {
    public static void main(String[] args) throws IOException {

        String pathStr = "C:\\Users\\vikto\\Desktop\\Programing JAVA\\Java Advanced\\Advanced old\\JavaAdvancedOld\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        byte[] allBytes = Files.readAllBytes(Path.of(pathStr));

        int sum = 0;
        for (byte value :allBytes){
            if (value != 10 && value != 13) {
                sum += value;
            }
        }
        System.out.println(sum);
    }
}
