package module6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import demos.Airport;

//import java.util.Arrays;

public class findAirportcode {
	
	private String city;
	private String country;
	private String code3;
	
	
	
	
	
	public static String findAirportLinearSearch(String toFind, Airport[] airports) {
		int index = 0;
		while(index < airports.length) {
			Airport a = airports[index];
			if(toFind.equals(a.getCity())) {   // == is compare the object
				return a.getCode3();
			}
			index++;
			
		}
		return null;
		
	}
	
	
	
	public static String findAirportBS(String toFind, Airport[] airports) {
		int low = 0;
		int high = airports.length -1;
		int mid;
		
		while(low <= high) {
			mid = low + (high - low)/2;   // prevent integer overflow
			int Compare = toFind.compareTo(airports[mid].getCity()); // .compareTo: compare alphabatically and return -1 0 and 1
			if (Compare <0) {
				high = mid-1;
			}
			else if (Compare > 0) {
				low = mid+1;
			}
			else {
				return airports[mid].getcode();
			}
		}
		return null;
		
		
	}
	
	public static void selectionSort(int[] vals) {
		
		int minIndex;
		for(int i= 0; i < vals.length-1 ; i++) {
			
			minIndex = vals[i];
			for(int j =i+1; j< vals.length; j++ ) {
				
				if (vals[j] < minIndex) {
					minIndex = j;
					
				}
				
				swqp(vals,minIndex,i);
				
			}
			
			
		}
		
		
		
		
	}
	
	

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

//		int[] intArray = new int[]{1,2,3,4,5,6,7,8,9,10};
//		System.out.println(Arrays.toString(intArray));
//		System.out.println(intArray.length);
//		int n = intArray.length;
//		
//		int target = 8;
//		
//		for(int i= 0; i < n; i++ ) {
//			if(intArray[i] == target) {
//				System.out.println(i);
//			}
////			System.out.println(i);
//			
//		}
//		
			
	}

	
	
	
	public String getcity() {
		return this.city;
	}
	
	public String getcountry() {
		return this.country;
	}
	
	public String getcode3() {
		return this.code3;
	}
	
	
	
	
}

