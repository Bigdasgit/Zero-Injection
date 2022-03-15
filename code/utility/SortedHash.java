package zero_injection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import util.CompareValue;

public class SortedHash {
	
	public static Object[] getItems(HashMap<Integer, Double> occf){
		CompareValue<Integer, Double> comparator = new CompareValue<Integer, Double>(occf);
		
		Map<Integer, Double> sortedMap = new TreeMap<Integer, Double> (comparator);
		sortedMap.putAll(occf);
		
		return sortedMap.keySet().toArray();
		
	}
	
	public static Map<Integer, Double> getMap(HashMap<Integer, Double> occf){
		CompareValue<Integer, Double> comparator = new CompareValue<Integer, Double>(occf);
		
		Map<Integer, Double> sortedMap = new TreeMap<Integer, Double> (comparator);
		sortedMap.putAll(occf);
		
		return sortedMap;
		
	}
	
	public static Map<Integer, Double> getSrotedHash(HashMap<Integer, Double> occf){
		CompareValue<Integer, Double> comparator = new CompareValue<Integer, Double>(occf);
		
		Map<Integer, Double> sortedMap = new TreeMap<Integer, Double> (comparator);
		sortedMap.putAll(occf);
		
		return sortedMap;
		
	}
	
	public static Map<Integer, Double> getSrotedHashDouble(HashMap<Integer, Double> occf){
		CompareValue<Integer, Double> comparator = new CompareValue<Integer, Double>(occf);
		
		Map<Integer, Double> sortedMap = new TreeMap<Integer, Double> (comparator);
		sortedMap.putAll(occf);
		
		return sortedMap;
		
	}

}
