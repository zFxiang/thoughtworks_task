package cn.school.thoughtworks.section1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PracticeB {
    List<String> collectSameElements(List<String> collection1, List<List<String>> collection2) {
        //实现练习要求，并改写该行代码。
        Set<String> set1 = new LinkedHashSet<>(collection1);
        Set<String> set2 = new HashSet<>();
        for (List<String> list : collection2) {
            set2.addAll(list);
        }
        set1.retainAll(set2);
        return new ArrayList<>(set1);
    }
}
