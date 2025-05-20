package com.pluralsight.streams;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFileReader {
    private final String fileName = "";

    private static List<String> filterAndConvertToUpper(Stream<String> stream, int length) {
        return stream.filter(s -> s.length() == length)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    //READ FILE
    //Step 1: Create a Stream of lines from the file
    public void readLines() {
        try {
            Stream<String> lines = Files.lines(Paths.get(fileName));
            List<String> filteredStrings = filterAndConvertToUpper(lines, 5);
            System.out.println("Filtered strings with length 5 (converted to uppercase): " + filteredStrings);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //WRITE TO FILE
    public void writeLines(ArrayList<String> words) {
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get(fileName)))) {
            // Step 2: Use Stream to write each word to the file
            Stream.of(words).forEach(pw::println);
        } catch (IOException e) {
            // Step 4: Handle any IO exception that occurs
            // during the file writing process
            System.out.println(e.getMessage());
        }
        // Step 3: Print success message to the console
        System.out.println(
                "Words written to the file successfully.");
    }
}


