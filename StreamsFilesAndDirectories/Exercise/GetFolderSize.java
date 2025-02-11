package StreamsFilesAndDirectories.Exercise;

import java.io.File;
import java.io.IOException;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\vikto\\Desktop\\Programing JAVA\\Java Advanced\\Advanced old\\JavaAdvancedOld\\04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercise\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File folder = new File(path);

        File[] files = folder.listFiles();

        int sum = 0;
        for (File file : files) {
            sum += file.length();
        }
        System.out.println("Folder size: " + sum);
    }
}
