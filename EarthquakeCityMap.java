package guimodule;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.UnfoldingMap;
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
//		Add marker
//		------------------------
		Location valLoc = new Location(29.71f,-95.41f);
		Marker val = new SimplePointMarker(valLoc);
		map.addMarker(val);                                							 // At the end, associate with the map
			
		
	}
	
	
	public void draw() {
		background(10);
		map.draw();
//		addKey();       															// start to design by myself
		
	}
	
	
	public static void main(String[]arg) {
		
	}
}
