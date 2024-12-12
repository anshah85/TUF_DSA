package fileRetrievalPractice.driver;

import java.io.*;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file;

        while (true) {
            System.out.println("Please enter a file path: ");
            String filePath = scanner.nextLine();

            file = new File(filePath);

            if (file.exists() && file.isFile()) {
                System.out.println("File found! Processing...");
                break;
            } else {
                System.err.println("File not found, Please try again.");
            }
        }

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;
        String longestWord = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                lineCount++;

                String[] words = line.split("\\s+");
                wordCount += words.length;

                for (String word : words) {
                    charCount += word.replaceAll("\\s+", "").length();

                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }

            System.out.println("Line count: " + lineCount);
            System.out.println("Word count: " + wordCount);
            System.out.println("Character count: " + charCount);
            System.out.println("Longest word: " + longestWord + " (" + longestWord.length() + " characters)");

            String outputFile = "src/fileRetrievalPractice/analysis_result.txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                writer.write("Line count: " + lineCount);
                writer.newLine();
                writer.write("Word count: " + wordCount);
                writer.newLine();
                writer.write("Character count: " + charCount);
                writer.newLine();
                writer.write("Longest word: " + longestWord + " (" + longestWord.length() + " characters)");
//                writer.newLine();
            } catch (IOException ioException) {
                System.err.println("Error writing file: " + ioException.getMessage());
            }
        } catch (IOException ioException) {
            System.err.println("Error reading file: " + ioException.getMessage());
        }
    }
}
