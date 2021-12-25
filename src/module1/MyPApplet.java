package module1;

import processing.core.*;

public class MyPApplet extends PApplet{
	String URL = "https://prd-sf-cdn.wag-static.com/renderer/v1/ferenderer?dsp=https://swiftbuckets-akmi.sf-cdn.com/v1/cmg/cell702/cdm/e45af20518c6408faa11d17e2b0794b0/3&sku=CommerceProduct_27865&st=front&cx=/walgreens/wg/wg-us/walgreens-us&pt=1636614962549&wd=640";
	PImage webImg; // from the processing document, use variable PImage
	public void setup() // setup load into memory
	{
		size(900,800);
		background(255);
		stroke(0);
	
		webImg = loadImage(URL, "png");
		webImg.resize(0,height);
		image(webImg,0,0);
		
		
	}
	
	public void draw() {
		
		int[] color = sunColorSec(second());
		fill(color[0],color[1],color[2]);
		ellipse(width/4, height/5, width/4, height/5);
	
	}
	
	public int[] sunColorSec(float seconds) {
		
		int[] rgb = new int[3];
		
		float differentfrom30 = Math.abs(30-seconds);
		float ratio  = differentfrom30/30;
		rgb[0]= (int)(255*ratio);
		rgb[1] = (int)(255*ratio); 
		rgb[2] = 0; 	
		
		return rgb;
		
	}
	
//	public static void main(String[] args) {
//		
//	}
	
	
}
