package cn.school.thoughtworks.section2;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PracticeC {
    Map<String, Integer> countSameElements(List<String> collection1) {
        //实现练习要求，并改写该行代码。
        Map<String,Integer> map = new LinkedHashMap<>();
        for (String str : collection1) {
            String key = str;
            int incr = 1;
            if (str.contains("-")){
                key = str.substring(0,str.indexOf("-"));
                incr = Integer.parseInt(str.substring(str.indexOf("-") + 1,str.length()));
            }
            if (str.contains(":")){
                key = str.substring(0,str.indexOf(":"));
                incr = Integer.parseInt(str.substring(str.indexOf(":") + 1,str.length()));
            }
            if (str.contains("[")){
                key = str.substring(0,str.indexOf("["));
                incr = Integer.parseInt(str.substring(str.indexOf("[") + 1,str.indexOf("]")));
            }
            Integer count = map.get(key);
            if(count == null){
                count = 0;
            }
            count += incr;
            map.put(key,count);
        }
        return map;
    }
}
