package com.joanmanera.examen;

public class ComparatorDist implements java.util.Comparator<Star> {
    @Override
    public int compare(Star o1, Star o2) {
        Double uno = o1.getDist();
        Double dos = o2.getDist();
        return uno.compareTo(dos);
    }
}
