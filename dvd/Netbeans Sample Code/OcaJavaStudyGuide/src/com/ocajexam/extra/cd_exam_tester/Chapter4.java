package com.ocajexam.extra.cd_exam_tester;

/**
 * [ ] Differentiate between the type of a reference and the type of an object 
 * [ ] Declare and initialize variables 
 * [ ] Differentiate between object reference variables and primitive variables
 */
public class Chapter4 {

    public void testQuestionA() {
        int b1 = 0b0101_0101_0101_0101;
        int b2 = 0b1010_1010_1010_1010;
        int b3 = b1 | b2;
        System.out.println("Value:" + b3);
    }

    public void testQuestionB() {
        Integer luckyNumber = 66;
        // System.out.println(luckyNumber.booleanValue());
        // System.out.println(luckyNumber.charValue());
        System.out.println(luckyNumber.byteValue());
        System.out.println(luckyNumber.shortValue());
        System.out.println(luckyNumber.longValue());
        System.out.println(luckyNumber.floatValue());
        System.out.println(luckyNumber.doubleValue());
    }

    public void testQuestionC() {
        int value1 = 0000;
        // int value2 = \u0777;
        // int value3 = \01111;
        // int value4 = \x0123;
    }

    public static void main(String[] args) {
        Chapter4 c4 = new Chapter4();
        c4.testQuestionA();
        c4.testQuestionB();
        c4.testQuestionC();
    }
}
