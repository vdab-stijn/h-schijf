package com.ocajexam.extra.cd_exam_tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * [ ] Implement inheritance 
 * [ ] Develop code that demonstrates the use of polymorphism 
 * [ ] Determine when casting is necessary
 */
public class Chapter8 {

    public void testQuestionA() {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("roses");
        list1.add("daisies");
        Stack<String> list2 = new Stack<>();
        list2.add("carnations");
        list2.add("tulips");
        //   list2.delete("tulips");
        List list;
        list = list1;
        System.out.print(list1);
        list = list2;
        System.out.print(list2);
    }

    public void testQuestionB() {
        System.out.println("###########################");
        int i = (int) 45.3;
        System.out.println("VALUE: " + i);
        int aa = (int) -45.9;
        System.out.println("VALUE: " + aa);
    }

    public static void main(String[] args) {
        Chapter8 c8 = new Chapter8();
        c8.testQuestionA();
        c8.testQuestionB();
    }
}
