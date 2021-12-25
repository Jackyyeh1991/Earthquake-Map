package guimodule;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;


import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import processing.core.*;
//import processing.opengl.*;


public class EarthquakeCityMap extends PApplet{
	
	
	private UnfoldingMap map;
	
	

	
	
	public void setup() {
		
//		------------------------
//		Set up map
//		------------------------
		
		
		
		
		
		size(400,400);
//		size(400,400,P2D);                                                            // P2D need OPenGL, but solve OPENGL issue latter
		map = new UnfoldingMap(this,200,50,700,500);
//		map = new UnfoldingMap(this,200,50,700,500, new Google.GoogleMapProvider());  // google provide need OPENGL
		map.zoomToLevel(2);															  // zoom in
		MapUtils.createDefaultEventDispatcher(this, map);                             // interactive map
		
//		------------------------
//		Add marker and Feature class
//		------------------------
		Location valLoc = new Location(29.71f,-95.41f);
			
		
		
//		------------------------
//		For a single data
//		------------------------
		Feature valEq = new PointFeature(valLoc);      							       // put location object in point feature
		valEq.addProperty("title", "Valdivia,Chile");
		valEq.addProperty("magnitude", "9.5");
		valEq.addProperty("date", "May 22, 1960");
		valEq.addProperty("year", "1960");
		
		List<PointFeature> bigEqs = new ArrayList<PointFeature>();                    // put multiple location with multiple feature in the list
		
		
//		------------------------
//		For multiple data
//		------------------------
		
		bigEqs.add(valEq);
//		bigEqs.add(alaskaEq);
//		bigEqs.add(sumatraEq);
//		bigEqs.add(japanEq);
//		bigEqs.add(kamchatkaEq);
		
//		------------------------
//		Create multiple Marker
//		------------------------
		List<Marker> markers = new ArrayList<Marker>();
		for (PointFeature eq: bigEarthquakes) {
			markers.add(new SimplePointMarker(eq.getLocation(),eq.getProperties()));
		}
		
//		------------------------
//		style multiple Marker
//		------------------------
		
		for(Marker mk: markers) {
			if ((int) mk.getProperties("year") > 2000) {
				mk.setColor(yellow);
			} else {
				mk.setColor(gray);
			}
			
			
			
		}
		
		

		
		
//		------------------------
//		Create single Marker
//      ------------------------	
		
		Marker valMK = new SimplePointMarker(valLoc, valEq.getProperties());     		// put feature obj(Feature) in Marker obj
		map.addMarker(valMK);                            								// At the end, associate marker obj with the map
			
		
	}
	
	
	public void draw() {        // refresh the screen
		background(10);
		map.draw();
//		addKey();       															// start to design by myself
		
	}
	
	
	public static void main(String[]arg) {
		
	}
}
