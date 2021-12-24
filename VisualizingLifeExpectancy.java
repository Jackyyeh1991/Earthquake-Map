package guimodule;

import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import processing.core.*;

public class VisualizingLifeExpectancy extends PApplet{
	
	
	private UnfoldingMap map;
	
	public void setup (){
		size(500,500);
		
		map = new UnfoldingMap(this, 50,50,700,500);
		map.zoomToLevel(2);
		
		// import file and read
		Map<String, Float> lifeExpByCountry;
//		lifeExpByCountry = LoadLifeExpectancyFromCSV("/Users/jacky/eclipse-workspace/UCSDUnfoldingMaps/data/LifeExpectancyWorldBank.csv");
		lifeExpByCountry = LoadLifeExpectancyFromCSV("/Users/jacky/eclipse-workspace/UCSDUnfoldingMaps/data/LifeExpectancyWorldBank.csv");
		
		MapUtils.createDefaultEventDispatcher(this, map);
	}
	
	public void draw(){
		background(10);
		map.draw();
		
	}
	
	
	private Map<String,Float> LoadLifeExpectancyFromCSV(String fileName){      // helper function to read file and store as hashmap
		Map<String, Float> lifeExpMap = new HashMap<String, Float>();
		String[] rows = loadStrings(fileName);               // take one row at a time and put in rows(from processing) 
		
//		System.out.println(Arrays.toString(rows));           // show in console

		for(String row : rows) {
			String[] columns = row.split(",");

//			System.out.println(Arrays.toString(columns));
			
		

//			float value = Float.parseFloat(columns[5]);
			
//
//			System.out.println(columns[5]);
////			
//			System.out.println(columns[4]);
			
						
			
			if(! columns[5].equals("..")) {                      // pre-process the CSV file 
				float value = Float.parseFloat(columns[5]);
				lifeExpMap.put(columns[4], value);	
			}
			
		}
		
		return lifeExpMap;
		
	}

}
