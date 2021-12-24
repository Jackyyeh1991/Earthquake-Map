package guimodule;

import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;


import java.util.ArrayList;
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
		MapUtils.createDefaultEventDispatcher(this, map);
	}
	
	public void draw(){
		background(10);
		map.draw();
		
	}
	
	
	private Map<String,Float> LoadLifeExpectancyFromCSV(String fileName){
		Map<String, Float> lifeExpMap = new HashMap<String, Float>();
		String[] rows = loadStrings(fileName);
		System.out.println(rows);
		
		return lifeExpMap;
		
	}

}
