package cz.cvut.k36.omo.hw.hw02;

import java.util.stream.IntStream;

// třída reprezentující A\B: doplněk množiny B vzhledem k množině A:  A\B = { x | x?A ? x?B }
public class OMOSetComplement implements OMOSetView {
  private final OMOSetView setA;
  private final OMOSetView setB;

  OMOSetComplement(OMOSetView setA, OMOSetView setB) {
    this.setA = setA;
    this.setB = setB;
  }

  @Override
  public boolean contains(int element) {
    return setA.contains(element) && !setB.contains(element);
  }

  @Override
  public int[] toArray() {
    return IntStream
        .of(setA.toArray())
        .filter(x -> !setB.contains(x))
        .distinct()
        .toArray();
  }

  @Override
  public OMOSetView copy() {
    OMOSet newSet = new OMOSet();
    for (Integer value : setA.toArray()) {
      if (setB.contains(value)) continue;
      newSet.add(value);
    }
    return newSet;
  }
}
