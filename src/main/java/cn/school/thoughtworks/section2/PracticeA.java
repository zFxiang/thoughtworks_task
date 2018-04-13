package cn.school.thoughtworks.section2;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PracticeA {
    Map<String,Integer> countSameElements(List<String> collection1) {
        //实现练习要求，并改写该行代码。
        Map<String,Integer> map = new LinkedHashMap<>();
        for (String str : collection1) {
            Integer count = map.get(str);
            if(count == null){
                count = 0;
            }
            count++;
            map.put(str,count);
        }
        return map;
    }
}
