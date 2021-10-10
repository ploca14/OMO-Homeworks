package cz.cvut.k36.omo.hw.hw02;

import java.util.LinkedHashSet;
import java.util.Set;

// třída reprezentující obecnou množinu
public class OMOSet extends OMOSetBase implements OMOSetView {
  private final Set<Integer> values = new LinkedHashSet<>();

  @Override
  public void add(int element) {
    values.add(element);
  }

  @Override
  public void remove(int element) {
    values.remove(element);
  }

  @Override
  public boolean contains(int element) {
    return values.contains(element);
  }

  @Override
  public int[] toArray() {
    return values.stream().mapToInt(value -> value.intValue()).toArray();
  }

  @Override
  public OMOSetView copy() {
    OMOSet newSet = new OMOSet();
    for (Integer value : values) {
      newSet.add(value);
    }
    return newSet;
  }
}
