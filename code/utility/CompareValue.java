package util;

import java.util.Comparator;
import java.util.Map;

public class CompareValue<K extends Comparable<K>, V extends Comparable<V>> implements Comparator<K>{
    private Map<K, V> map;
    
    public CompareValue(Map<K, V> map) {
        this.map = map;
    }
    public int compare(K o1, K o2) {
        int p = map.get(o1).compareTo(map.get(o2));
        if (p != 0) {
            return p;
        }
        return o1.compareTo(o2);
    }
}

