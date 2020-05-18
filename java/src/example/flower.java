package example;

import processing.core.PApplet;
import processing.core.PConstants;
import ddf.minim.AudioBuffer;

public class flower {
    
    public static void render(AudioBuffer ab, PApplet pa) {
        float offs = 0;
        float average = 0;
        float lerpedw = 0;
        float cx;
        float cy;
        pa.strokeWeight(2);
        cx = pa.width / 5;
        cy = pa.height / 2;

        // bottom left
        for (int i = 0; i < ab.size(); i++) {
            float theta = PApplet.map(i, 0, ab.size(), 0, PConstants.TWO_PI);
			float x = (pa.width - 800) + PApplet.sin(theta) * (pa.width - 800) * ((PApplet.abs(ab.get(i)) / 2));
			float y = (pa.height - 125) + PApplet.cos(theta) * cx * ((PApplet.abs(ab.get(i)) / 2));
			pa.stroke(
				    PApplet.map(i + offs, 0, ab.size(), 0, 255) % 255
				,255
				,255
			);
			pa.line((pa.width - 800), (pa.height - 125), x, y);
        }
        
		offs += average * 100f;	
        
        //middle
        for(int i = 0 ; i < ab.size() ; i ++)
		{
			float theta = PApplet.map(i, 0, ab.size(), 0, PConstants.TWO_PI);
			float x = (pa.width / 2) + PApplet.sin(theta) * (pa.width / 2) * ((PApplet.abs(ab.get(i)) / 2));
			float y = (pa.width / 5.01f) + PApplet.cos(theta) * cx * ((PApplet.abs(ab.get(i)) / 2));
			pa.stroke(
				    PApplet.map(i + offs, 0, ab.size(), 0, 255) % 255
				,255
				,255
			);
			pa.line((pa.width / 2), cy, x, y);
		}
        offs += average * 100f;	
        
        //bottom right
        for(int i = 0 ; i < ab.size() ; i ++)
		{
			float theta = PApplet.map(i, 0, ab.size(), 0, PConstants.TWO_PI);
			float x = (pa.width - 200) + PApplet.sin(theta) * (pa.width - 200) * ((PApplet.abs(ab.get(i)) / 8));
			float y = (pa.height - 125) + PApplet.cos(theta) * (pa.width - 200) * ((PApplet.abs(ab.get(i)) / 8));
			pa.stroke(
				PApplet.map(i + offs, 0, ab.size(), 0, 255) % 255
				,255
				,255
			);
			pa.line((pa.width - 200), (pa.height - 125), x, y);
		}
        offs += average * 100f;
        
        //top left
        for(int i = 0 ; i < ab.size() ; i ++)
		{
			float theta = PApplet.map(i, 0, ab.size(), 0, PConstants.TWO_PI);
			float x = (pa.width - 800) + PApplet.sin(theta) * (pa.width - 800) * ((PApplet.abs(ab.get(i)) / 2));
			float y = (pa.height - 425) + PApplet.cos(theta) * (pa.width - 800) * ((PApplet.abs(ab.get(i)) / 2));
			pa.stroke(
				PApplet.map(i + offs, 0, ab.size(), 0, 255) % 255
				,255
				,255
			);
			pa.line((pa.width - 800), (pa.height - 425), x, y);
		}
        offs += average * 100f;
        
        //top right
        for(int i = 0 ; i < ab.size() ; i ++)
		{
			float theta = PApplet.map(i, 0, ab.size(), 0, PConstants.TWO_PI);
			float x = (pa.width - 200) + PApplet.sin(theta) * (pa.width - 200) * ((PApplet.abs(ab.get(i)) / 8));
            float y = (pa.height - 425) + PApplet.cos(theta) * (pa.width - 200) * ((PApplet.abs(ab.get(i)) / 8));
			pa.stroke(
				PApplet.map(i + offs, 0, ab.size(), 0, 255) % 255
				,255
				,255
			);
			pa.line((pa.width - 200), (pa.height - 425), x, y);
		}
        offs += average * 100f;
    }

    private int abs(float f) {
        return 0;
    }
    
}