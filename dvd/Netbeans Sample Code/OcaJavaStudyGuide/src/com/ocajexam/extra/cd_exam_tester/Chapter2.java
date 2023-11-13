package com.ocajexam.extra.cd_exam_tester;

/**
 * [ ] Create and use while loops 
 * [ ] Create and use for loops including the enhanced for loop 
 * [ ] Create and use do/while loops 
 * [ ] Compare loop constructs 
 * [ ] Use break and continue 
 * [ ] Create if and if/else constructs 
 * [ ] Use a switch statement
 */
public class Chapter2 {

    private /*
     * c1
     */ static final int FISCHER_IQ = /*
             * c2
             */ 187;

    public void testQuestionA() {
        String baby = "squirrel";
        switch (baby) {
            case "squirrel":
                System.out.print("Baby Squirrel ");
            case "rabbit":
                System.out.print("Baby Rabbit\n");
                break;
            case "turtle":
                System.out.print("Baby Turtle ");
                break;
            default:
                System.out.print("Baby\n");
                break;
        }
    }

    public void testQuestionB() {
        int cartwheelsInAMinute = 30;
        if (cartwheelsInAMinute > 48) {
            System.out.println("New world record!");
        } else if (cartwheelsInAMinute > 30 && cartwheelsInAMinute <= 48) {
            System.out.println("Awesome Job!");
        } else if (cartwheelsInAMinute > 0 && cartwheelsInAMinute <= 30) {
            System.out.println("Still impressive!");
        } else {
            System.out.println("Keep trying!");
        }
    }

    public void testQuestionC() {
        int j = 0;
        for (j = 1; j < 10;) {
            j++;
            ++j;
        }
        System.out.println(j);
    }

    public void testQuestionD() {
        boolean isValid = true;
        while (isValid) {
            isValid = false;
            System.out.print("test1 ");
            isValid = true;
            System.out.println("test2 ");
            break;
      //   isValid = false;
            //    System.out.println("test3");     
        }
    }

    public static void main(String[] args) {
        Chapter2 c2 = new Chapter2();
        c2.testQuestionA();
        c2.testQuestionB();
        c2.testQuestionC();
        c2.testQuestionD();
    }
}
