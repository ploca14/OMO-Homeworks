package cz.cvut.k36.omo.hw.hw01;

public class Main {

  public static void main(String[] args) {
    Homework1 hw1 = new Homework1();

    System.out.print("Output of f: ");
    System.out.println(hw1.f());

    System.out.print("Output of g: ");
    System.out.println(Homework1.g());

    System.out.print("First output of h: ");
    System.out.println(hw1.h());
    System.out.print("Second output of h: ");
    System.out.println(hw1.h());

    System.out.print("First output of i: ");
    System.out.println(hw1.i());
    System.out.print("Second output of i: ");
    System.out.println(hw1.i());

    System.out.print("First output of i from another instance: ");
    Homework1 hw2 = new Homework1();
    System.out.println(hw2.i());
  }
}
