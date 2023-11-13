/**
 * [ ] Manipulate data using the StringBuilder class and its methods 
 * [ ] Create and manipulate strings 
 * [ ] Use Java operators 
 * [ ] Use parentheses to override operator precedence 
 * [ ] Test equality between strings and other objects using == and equals ()
 */
package com.ocajexam.extra.cd_exam_tester;

public class Chapter3 {

    public void testQuestionA() {
        int value = 6 * 8 / 4 + 2 + 2 * 3 + 4 / 2 * 8;
        System.out.println("i:" + value);
    }

    public void testQuestionB() {
        String s = "roberto".replaceAll("o", "!").substring(2, 6);
        System.out.println(s);
    }

    public void testQuestionC() {
        String s1 = new String("FIVE DOLLARS");
        String s2 = new String("five dollars");
        s2.toUpperCase();
        System.out.println(s1.equals(s2));
    }

    public static void main(String[] args) {
        Chapter3 c3 = new Chapter3();
        c3.testQuestionA();
        c3.testQuestionB();
        c3.testQuestionC();
    }
}
