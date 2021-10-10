package cz.cvut.k36.omo.hw.hw02;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.IntStream;

// třída reprezentující sjednocení dvou množin: A sjednoceno B
public class OMOSetUnion implements OMOSetView {
  private OMOSetView setA;
  private OMOSetView setB;

  OMOSetUnion(OMOSetView setA, OMOSetView setB) {
    this.setA = setA;
    this.setB = setB;
  }

  @Override
  public boolean contains(int element) {
    return setA.contains(element) || setB.contains(element);
  }

  @Override
  public int[] toArray() {
    return IntStream
        .concat(
            IntStream.of(setA.toArray()),
            IntStream.of(setB.toArray())
        )
        .distinct()
        .toArray();
  }

  @Override
  public OMOSetView copy() {
    OMOSet newSet = new OMOSet();
    for (Integer value : setA.toArray()) {
      newSet.add(value);
    }
    for (Integer value : setB.toArray()) {
      newSet.add(value);
    }
    return newSet;
  }
}
