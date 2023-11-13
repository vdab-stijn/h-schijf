package com.ocajexam.chapter_05;

/**
 * Loan Details
 *
 * @author Edward Finegan
 * @author Robert J. Liguori
 * @author OCA 8 Study Guide - ISBN 1259587517
 * @version 1.0.0 07-11-15
 * @since 1.0.0 07-11-15
 */
public class LoanDetails {

  private int term;
  private double rate;
  private double principal;

  public LoanDetails() {
    term = 180;
    rate = .0265; //Interest rate as a decimal
    principal = 0;
  }

  public LoanDetails(int t, double r, double p) {
    term = t;
    rate = r;
    principal = p;
  }

  public void setPrincipal(double p) {
    principal = p;
  }

  public double monthlyPayment() {
    return (rate * principal / 12)
            / (1.0 - Math.pow(((rate / 12) + 1.0), (-term)));
  }

  public static void main(String[] args) {
    LoanDetails ld = new LoanDetails();
    ld.setPrincipal(150000);
    System.out.println("Payment: " + ld.monthlyPayment());

    LoanDetails firstLD = new LoanDetails();
    firstLD.setPrincipal(150000);
    System.out.println("Payment 1 : " + firstLD.monthlyPayment());
    LoanDetails secondLD = new LoanDetails(10, .025, 125000);
    System.out.println("Payment 2 : " + secondLD.monthlyPayment());
  }
}
