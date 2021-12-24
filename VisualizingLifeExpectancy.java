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
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import processing.core.*;

public class VisualizingLifeExpectancy extends PApplet{
	
	
	UnfoldingMap map;
	
	List<Feature> countries;
	List<Marker> countryMarkers;
	Map<String, Float> lifeExpByCountry;
	
	public void setup (){
		size(860,700);
		
		map = new UnfoldingMap(this, 50,50,700,500);
		map.zoomToLevel(2);
		
		// import file and read
//		Map<String, Float> lifeExpByCountry;
		lifeExpByCountry = LoadLifeExpectancyFromCSV("/Users/jacky/eclipse-workspace/UCSDUnfoldingMaps/data/LifeExpectancyWorldBank.csv");


		
//		----------------------
//		feature list 
//		----------------------
		List<Feature> countries = new ArrayList<Feature>();
		
		
		countries = GeoJSONReader.loadData(this, "/Users/jacky/eclipse-workspace/UCSDUnfoldingMaps/data/countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		
		map.addMarkers(countryMarkers);
		shadeCountries();
		
		
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
//			System.out.println(columns[5]);
//			System.out.println(columns[4]);
			
						
			
			if(! columns[5].equals("..")) {                      // pre-process the CSV file 
				float value = Float.parseFloat(columns[5]);
				lifeExpMap.put(columns[4], value);	
			}
			
		}
		
		return lifeExpMap;
		
	}
	
	
	private void shadeCountries() {                              // change the number into according color, take maker, find marker countries' age using ID and set marker color.
		for(Marker marker: countryMarkers) {
			String countryId = marker.getId();
			
			if(lifeExpByCountry.containsKey(countryId)) {
				float lifeExp = lifeExpByCountry.get(countryId);
				int colorLevel = (int)map(lifeExp,40,90,10,255); // age: 40~90. color range: 10~255
				marker.setColor(color(255-colorLevel,100,colorLevel));
			}
			else {
				marker.setColor(color(150,150,150));
				
			}
			
		}
		
		 
		
	}
	
	
	
	
	
	

}
