package com.ocajexam.extra.cd_exam_tester;

import java.util.ArrayList;

/**
 * [ ] Declare, instantiate, initialize and use a one-dimensional array 
 * [ ] Declare, instantiate, initialize and use multi-dimensional array 
 * [ ] Declare and use an ArrayList
 */
public class Chapter6 {

    public void testQuestionA() {
        ArrayList d1 = new ArrayList();
        ArrayList d2 = new ArrayList<>();
        //   ArrayList<> d3 = new ArrayList<>();
        ArrayList<Double> d4 = new ArrayList<>();
        //  ArrayList<Double> d5 = new ArrayList<Double>();
        //  ArrayList<Double> d6 = new ArrayList<Float>();
    }

    public void testQuestionB() {
        //   Object[] o = {"Song Book", 35.95, new Guitar(), 6};
        String[] s = {"str1", "str2"};
    }

    public void testQuestionC() {
        ArrayList<String> a = new ArrayList<>();
        a.add("Shelby");
        a.add("Peter");
        a.add("Undefined");
        a.add("Benjamin");
        a.add(2, "Happy");
        for (String s : a) {
            System.out.print(s + " ");
        }
        System.out.print("\n");
    }

    public void testQuestionD() {
        int[][] array = new int[10][10];
    }

    public static void main(String[] args) {
        Chapter6 c6 = new Chapter6();
        c6.testQuestionA();
        c6.testQuestionB();
        c6.testQuestionC();
        c6.testQuestionD();
    }
}
