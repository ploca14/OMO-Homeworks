package cz.cvut.k36.omo.hw.hw01;

public class Homework1 {

  private int count = 0;
  private static int staticCount = 0;

  public boolean f() {
    return true;
  }

  public static boolean g() {
    return false;
  }

  public int h() {
    return ++count;
  }

  public int i() {
    return ++staticCount;
  }
}
