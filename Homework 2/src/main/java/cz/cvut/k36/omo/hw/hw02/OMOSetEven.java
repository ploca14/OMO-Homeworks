package cz.cvut.k36.omo.hw.hw02;

import java.util.stream.IntStream;

// třída reprezentující množinu sudých čísel
public class OMOSetEven implements OMOSetView {
  private final OMOSetView setA;

  OMOSetEven(OMOSetView setA) {
    this.setA = setA;
  }

  @Override
  public boolean contains(int element) {
    return element % 2 == 0 && setA.contains(element);
  }

  @Override
  public int[] toArray() {
    return IntStream
        .of(setA.toArray())
        .filter(x -> x % 2 == 0)
        .distinct()
        .toArray();
  }

  @Override
  public OMOSetView copy() {
    OMOSet newSet = new OMOSet();
    for (Integer value : setA.toArray()) {
      if (value % 2 == 0){
        newSet.add(value);
      }
    }
    return newSet;
  }
}
