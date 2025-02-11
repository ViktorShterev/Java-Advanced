package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\vikto\\Desktop\\Programing JAVA\\Java Advanced\\Advanced old\\JavaAdvancedOld\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\vikto\\Desktop\\Programing JAVA\\Java Advanced\\Advanced old\\JavaAdvancedOld\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputB.txt");

        PrintStream out = new PrintStream(outputStream);

        int value = fileInputStream.read();

        while (value != -1) {

            if (value != 10 && value != 32) {
                out.print(value);
            } else {
                out.print((char) value);
            }

            value = fileInputStream.read();
        }
        fileInputStream.close();
        outputStream.close();
    }
}
