/*
Name: Connor Byers
Description: Personal use to take files that have varying characters and filter out punctuation, numbers, etc.
and also turn uppercase letters to lowercase.
 */

import java.io.*;

public class TextToPlainFormat {
    private String inputFilePath;
    private String outputFilePath;

    public TextToPlainFormat(String inputFilePath, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    public String[] readAndProcessFile() { //option 3 includes []
        StringBuilder processedContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (!word.isEmpty()) {
                        processedContent.append(word).append(" ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return processedContent.toString().trim().split("\\s+"); //option3 includes .split("\\s+")
    }

    public void writeProcessedContentToFile(String processedContent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            writer.write(processedContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String inputFilePath = "Input file";
        String outputFilePath = "Output file";

        TextToPlainFormat textToPlainFormat = new TextToPlainFormat(inputFilePath, outputFilePath);

        // Step 1: Read the file and process its content
        //String processedContent = textToPlainFormat.readAndProcessFile(); //for option 1 and 2
        String[] wordsArray = textToPlainFormat.readAndProcessFile(); //for option 3

        // Step 2: Write the processed content to the output file
        //textToPlainFormat.writeProcessedContentToFile(processedContent); //option 1
        //System.out.println(processedContent); //option 2
        for (String word : wordsArray) { //option 3
            System.out.println(word);
        }
    }
}

