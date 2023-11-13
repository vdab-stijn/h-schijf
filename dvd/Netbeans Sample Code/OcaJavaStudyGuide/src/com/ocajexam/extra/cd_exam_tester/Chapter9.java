package com.ocajexam.extra.cd_exam_tester;

import java.io.IOException;
import java.nio.file.*;

/**
 * [ ] Differentiate among checked exceptions, RuntimeExceptions and Errors
 * [ ] Create a try-catch block and determine how exceptions alter normal 
 *     program flow
 * [ ] Describe what exceptions are used for in Java
 * [ ] Invoke a method that throws an exception
 * [ ] Recognize common exception classes and categories
 */
public class Chapter9 {

    public void testQuestionA() {

        Path path = Paths.get("/code/tempFolder");
        try {
            Files.delete(path);
        } catch (NoSuchFileException | DirectoryNotEmptyException x) {
            x.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Chapter9 c9 = new Chapter9();
        c9.testQuestionA();
    }
}
