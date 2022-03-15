package util;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Percentile {
	
	
	int standard;
	HashMap<Double, Integer> frequentOfValue ;
	ArrayList<Double> valueList;
	double result;
	double minValue;
	
	
	public Percentile(ArrayList<Double> valueList, int standard) {
		frequentOfValue = new HashMap<Double, Integer>();
		this.valueList = valueList;
		this.standard = standard;
	}
	
	public double getMinValue(){
		Collections.sort(valueList);
		return valueList.get(0);
	}

	
	public double getPercentileX(){
		setFrequentOfValue();
		result = calPercentilePos(standard);
		return result;
	}
	
	public void setFrequentOfValue(){
		Collections.sort(valueList);
		
		for (int i = 0 ; i<valueList.size(); i++){
			int numOfValue = 1;
			double curVal = valueList.get(i);
			if (frequentOfValue.keySet().contains(curVal)){
				numOfValue = frequentOfValue.get(curVal) + 1;
			}
			frequentOfValue.put(curVal, numOfValue);
		}
	}
	
	public double calPercentilePos(int standard) {
		int numOfPreVal = 0;
		int numOfCurVal;
		double preVal = -999;
		ArrayList<Double> uniqueItems = new ArrayList<Double>(new HashSet<Double>(valueList));
		Collections.sort(uniqueItems);
		
		for (Double curVal : uniqueItems) {
			
			numOfCurVal = frequentOfValue.get(curVal);
			double curPercentile = (numOfPreVal + 0.5*numOfCurVal) / valueList.size() *100;
			
			if (curPercentile > standard)
				return preVal;
			
			numOfPreVal += numOfCurVal;
			preVal = curVal;
		}
		return preVal;
	}

}
