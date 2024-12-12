package linkedList.doublyLinkedList;

import java.io.*;
import java.util.List;

public class FileMergeTest {
    public static void main(String[] args) {
        List<String> files = List.of("file1.csv", "file2.csv", "file3.csv");

        mergeFiles(files);

    }

    public static void mergeFiles(List<String> files) {
        String outputFileName = "output.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (String file : files) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
                    }
                } catch (IOException e) {
                    System.err.println("Error reading file: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
