import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir") + "/src");
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (Scanner scanner = new Scanner(selectedFile)) {
                int lineCount = 0;
                int wordCount = 0;
                int charCount = 0;

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                    lineCount++;
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                }

                System.out.println("\nSummary Report:");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);

            } catch (FileNotFoundException e) {
                System.err.println("File not found.");
            }
        } else {
            System.out.println("File selection cancelled.");
        }
    }
}

