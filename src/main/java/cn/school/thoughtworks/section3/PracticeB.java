package cn.school.thoughtworks.section3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PracticeB {
    Map<String,Integer> createUpdatedCollection(Map<String,Integer> collectionA, Map<String,List<String>> object) {
        //实现练习要求，并改写该行代码。
        Map<String,Integer> map = new HashMap<>(collectionA.size());
        Set<String> set = new HashSet<>();
        for (String key : object.keySet()) {
            set.addAll(object.get(key));
        }
        for (String key : collectionA.keySet()) {
            Integer count = collectionA.get(key);
            if(set.contains(key)){
                count -= count / 3;
            }
            map.put(key,count);
        }
        return map;
    }
}
