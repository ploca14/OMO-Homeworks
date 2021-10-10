package cz.cvut.k36.omo.hw.hw02;

import java.util.stream.IntStream;

// třída reprezentující průnik dvou množin: A průnik B
public class OMOSetIntersection implements OMOSetView {
  private final OMOSetView setA;
  private final OMOSetView setB;

  OMOSetIntersection(OMOSetView setA, OMOSetView setB) {
    this.setA = setA;
    this.setB = setB;
  }

  @Override
  public boolean contains(int element) {
    return setA.contains(element) && setB.contains(element);
  }

  @Override
  public int[] toArray() {
    return IntStream
        .of(setA.toArray())
        .filter(setB::contains)
        .distinct()
        .toArray();
  }

  @Override
  public OMOSetView copy() {
    OMOSet newSet = new OMOSet();
    for (Integer value : setA.toArray()) {
      if (setB.contains(value)) {
        newSet.add(value);
      }
    }
    return newSet;
  }
}