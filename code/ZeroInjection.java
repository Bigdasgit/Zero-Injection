package main;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import util.Percentile;
import util.ReadFile;
import util.WriteFile;
import zero_injection.SortedHash;

public class ZeroInjection {

	public static void main(String[] args) {
		
		int theta = 90;
		
		
	
		
		/*Input
		 * baseFilePath: given matrix (rating matrix)
		 * preUsePrefPath: pre-use preference matrix
		 */
		String baseFilePath = "sample_data/givenMatrix.base";
		String preUsePrefPath = "sample_data/preUsePrefMatrix.predict";
		
		//Output
		String zeroInjectedPath = "sample_data/zeroInjectedMatrix.base"; 
		
		
		ReadFile rf = new ReadFile();
		HashMap<Integer, HashMap<Integer, Double>> base = rf.readBase(baseFilePath);
		Map<Integer, HashMap<Integer, Double>> preUsePref = rf.readPreUsePref(preUsePrefPath, base);
		
		
		//Calculate percentile rank
		ArrayList<Double> valueList = new ArrayList<Double>();
		
		for (Object user : preUsePref.keySet().toArray()) {
			int userId = (int) user;
			Object[] sortUser = SortedHash.getItems(preUsePref.get(userId));
			for (Object item : sortUser) {
				int itemId = (int) item;
				valueList.add(preUsePref.get(userId).get(itemId));
			}
		}
		Percentile pr = new Percentile(valueList, theta);
		double thetaValue = pr.getPercentileX();
		
		
		
		//Zero-injection
		for (Object user : preUsePref.keySet().toArray()) {
			int userId = (int) user;
			Object[] sortUser = SortedHash.getItems(preUsePref.get(userId));
			
			for (Object item : sortUser) {
				
				//Uninteresting items
				int itemId = (int) item;
				double curVal = preUsePref.get(userId).get(itemId);
				
				
				//Interesting items
				if (curVal > thetaValue){
					break;
				}
				
				base.get(userId).put(itemId, 0.0);
				
				
			}
		}
		
		WriteFile wf = new WriteFile();
		wf.writeZeroInjection(base, zeroInjectedPath);
		
		
		
	}

}
