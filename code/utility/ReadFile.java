package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReadFile {
	
	public Map<Integer, HashMap<Integer, Double>> readPreUsePref(String path, HashMap<Integer, HashMap<Integer, Double>> base) {
		String file = path;
		BufferedReader br = null;
		String line = "";
		
		
		Map<Integer, HashMap<Integer, Double>> preUsePref = new HashMap<Integer,HashMap<Integer, Double>>();
		
		
		try {
			
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				
				HashMap<Integer, Double> userVector;
				String[] cell = line.split("\\s+");

				int userId = Integer.parseInt(cell[0]);
				int itemId = Integer.parseInt(cell[1]);
				Double value = Double.parseDouble(cell[2]);
				
				//check
				if ( base.get(userId) != null && base.get(userId).get(itemId) != null){
					continue;
				}
				
				
				if (!preUsePref.containsKey(userId)){
					userVector = new HashMap<Integer, Double>();
					userVector.put(itemId, value);
					preUsePref.put(userId, userVector);
				}
				
				preUsePref.get(userId).put(itemId, value);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				} finally {
					if (br != null) {
						try {
							br.close();
							} catch (IOException e) {
								e.printStackTrace();
								}
						}
					}
		System.out.println("Done");
		return preUsePref;
	}
	
	public HashMap<Integer, HashMap<Integer, Double>> readBase(String path) {
		String file = path;
		BufferedReader br = null;
		String line = "";
		
		
		HashMap<Integer, HashMap<Integer, Double>> preUsePref = new HashMap<Integer,HashMap<Integer, Double>>();
		
		
		try {
			
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				
				HashMap<Integer, Double> userVector;
				String[] cell = line.split("\\s+");

				int userId = Integer.parseInt(cell[0]);
				int itemId = Integer.parseInt(cell[1]);
				double value = Integer.parseInt(cell[2]);
				
				if (!preUsePref.containsKey(userId)){
					userVector = new HashMap<Integer, Double>();
					userVector.put(itemId, value);
					preUsePref.put(userId, userVector);
				}
				
				preUsePref.get(userId).put(itemId, value);
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				} finally {
					if (br != null) {
						try {
							br.close();
							} catch (IOException e) {
								e.printStackTrace();
								}
						}
					}
		System.out.println("Done");
		return preUsePref;
	}
	
	
	

}
