package cn.school.thoughtworks.section1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PracticeA {
    List<String> collectSameElements(List<String> collection1, List<String> collection2) {
        //实现练习要求，并改写该行代码。
        Set<String> set1 = new LinkedHashSet<>(collection1);
        set1.retainAll(collection2);
        return new ArrayList<>(set1);
    }
}
