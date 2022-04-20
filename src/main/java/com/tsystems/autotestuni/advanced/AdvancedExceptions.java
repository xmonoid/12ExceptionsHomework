package com.tsystems.autotestuni.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AdvancedExceptions {

    /**
     * This method counts the number of line in a text file.
     * It was implemented with old-style try-catch block.
     * Rewrite this method to use try-with-resources instead.
     * Hint: class {@link SomeResource} should be corrected to achieve that.
     *
     * @param filename fill filename
     * @return the number of lines in the file
     * @throws IOException throws if any issue happens
     */
    public static int numberOfLinesInFile(String filename) throws IOException {
        int numberOfLinesInFile;
        // 2. SomeResource may be used as a resource in try-with-resources
        try (SomeResource someResource = new SomeResource()) {
            numberOfLinesInFile = someResource.numberOfLinesInFile(filename);
        }
        return numberOfLinesInFile;
    }

    // 1. This class should implement interface AutoCloseable
    private static class SomeResource implements AutoCloseable {

        private BufferedReader nbr = null;

        public int numberOfLinesInFile(String filename) throws IOException {
            int result = 0;
            Path sourcePath = Paths.get(filename);
            nbr = Files.newBufferedReader(sourcePath);
            while(nbr.readLine() != null){
                result++;
            }
            return result;
        }

        public void close() throws IOException {
            if (nbr != null) {
                nbr.close();
            }
        }
    }
}