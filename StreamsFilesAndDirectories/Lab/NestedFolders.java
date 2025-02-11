package StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\Users\\vikto\\Desktop\\Programing JAVA\\Java Advanced\\Advanced old\\JavaAdvancedOld\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File root = path.toFile();

        Deque<File> queue = new ArrayDeque<>();
        queue.offer(root);

        int count = 0;
        while (!queue.isEmpty()) {

            File file = queue.poll();
            System.out.println(file.getName());
            count++;

            File[] files = file.listFiles();

            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        queue.offer(f);
                    }
                }
            }
    }
        System.out.println(count + " folders");
    }
}
