package com.tsystems.autotestuni.advanced;

import org.junit.jupiter.api.Test;

import java.nio.charset.MalformedInputException;
import java.nio.file.FileSystemException;
import java.nio.file.NoSuchFileException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdvancedExceptionsTest {

    @Test
    void numberOfLinesInFile() throws Exception {
        if (System.getProperty("os.name").contains("Windows")) {
            assertTrue(AdvancedExceptions.numberOfLinesInFile(
                    "C:\\Windows\\System32\\drivers\\etc\\hosts") > 0);
            assertThrows(NoSuchFileException.class, () -> AdvancedExceptions.numberOfLinesInFile(
                    "C:\\Windows\\System32\\drivers\\etc\\hosts2"));
            assertThrows(MalformedInputException.class, () -> AdvancedExceptions.numberOfLinesInFile(
                    "C:\\Windows\\System32\\notepad.exe"));
            assertThrows(FileSystemException.class, () -> AdvancedExceptions.numberOfLinesInFile(
                    "C:\\swapfile.sys"));
        } else {
            throw new UnsupportedOperationException("Other OS are not supported yet." +
                    " Please, contact Evgenii Kosykh (evgenii.kosykh@t-systems.com) to get some advice");
        }
    }
}