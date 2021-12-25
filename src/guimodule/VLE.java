package guimodule;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;


public class VLE extends PApplet{
	
	UnfoldingMap map;
	
	public void step (){
		size(100,100);
		
		map = new UnfoldingMap(this, 50,50,700,500);
		map.zoomToLevel(2);	
		MapUtils.createDefaultEventDispatcher(this, map);
	}
	
	public void draw(){
		map.draw();
		
	}

}
