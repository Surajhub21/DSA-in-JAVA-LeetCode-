package learn.treemap;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {

    public static void main(String[] args) {
        SortedMap<String , Integer> map = new TreeMap<>();
        map.put("B" , 13);
        map.put("A" , 63);
        map.put("D" , 153);
        map.put("C" , 17);
        System.out.println(map);
    }
}
