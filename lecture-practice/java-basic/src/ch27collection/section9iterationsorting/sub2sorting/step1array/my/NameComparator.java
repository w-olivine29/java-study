package ch27collection.section9iterationsorting.sub2sorting.step1array.my;

import java.util.Comparator;

public class NameComparator implements Comparator<MyUser> {
    @Override
    public int compare(MyUser o1, MyUser o2) {
        return o1.getName().compareTo(o2.getName()); //String 의 compareTo
    }

}
