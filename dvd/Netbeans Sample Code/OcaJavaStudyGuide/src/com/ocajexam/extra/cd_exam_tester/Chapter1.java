package com.ocajexam.extra.cd_exam_tester;

import static java.lang.Math.abs;
//import static java.util.Math.abs;
//import java.lang.Math.abs;
//import java.lang.*;

/**
 * [ ] Create executable Java applications with a main method 
 * [ ] Define the structure of a Java class 
 * [ ] Import other Java packages to make them accessible in your code
 *
 */
public class Chapter1 {

    public void testQuestionA() {
    int absoluteValue = abs(-21);
        System.out.println(absoluteValue);
        // char a = '\x{0068}';
        char[] cArray = {'\u004F', '\u0043', '\u0041', '\u004A'}; // OCAJ
        System.out.println(cArray);
        int i = '\u0021'; // 67 + 100
        System.out.println(i);
    }

    public static void main(String[] args) {
        Chapter1 c1 = new Chapter1();
        c1.testQuestionA();

    }

}
