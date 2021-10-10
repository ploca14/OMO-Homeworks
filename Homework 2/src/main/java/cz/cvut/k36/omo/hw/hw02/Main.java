package cz.cvut.k36.omo.hw.hw02;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    OMOSet setA = new OMOSet();
    OMOSet setB = new OMOSet();

    for (int i = 0; i < 10; i++) {
      setA.add(i);
    }

    for (int i = 5; i < 20; i++) {
      setB.add(i);
    }

    OMOSetUnion unionAB = new OMOSetUnion(setA, setB);
    System.out.println(Arrays.toString(unionAB.toArray()));

    OMOSetIntersection intersectionAB = new OMOSetIntersection(setA, setB);
    System.out.println(Arrays.toString(intersectionAB.toArray()));

    OMOSetComplement complementAB = new OMOSetComplement(setA, setB);
    System.out.println(Arrays.toString(complementAB.toArray()));

    OMOSetEven evenA = new OMOSetEven(setA);
    System.out.println(Arrays.toString(evenA.toArray()));
  }
}
