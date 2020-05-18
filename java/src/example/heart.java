package example;

public class heart extends MyVisual{

    float lerpedw;
    float sum;
    float average;

    public heart()
    {
        lerpedw = 0;
        sum = 0;
        
    }

    public void render()
    {
        

        for(int i = 0 ; i < ab.size() ; i ++) {
            sum += abs(ab.get(i));
        }
        average = sum / ab.size();
        
        float w = average * 100;
        lerpedw = lerp(lerpedw, w, 1.5f);
        
        
        fill(map(average, 0, 1, 0, 255) , 255 , 255 );

        ellipse(500, 150, lerpedw, lerpedw);

        ellipse(400, 100, lerpedw, lerpedw);
        ellipse(600, 100, lerpedw, lerpedw);

        ellipse(300, 75, lerpedw, lerpedw);
        ellipse(700, 75, lerpedw, lerpedw);

        ellipse(200, 110, lerpedw, lerpedw);
        ellipse(800, 110, lerpedw, lerpedw);

        ellipse(175, 175, lerpedw, lerpedw);
        ellipse(825, 175, lerpedw, lerpedw);

        ellipse(200, 250, lerpedw, lerpedw);
        ellipse(800, 250, lerpedw, lerpedw);

        ellipse(250, 300, lerpedw, lerpedw);
        ellipse(750, 300, lerpedw, lerpedw);

        ellipse(350, 350, lerpedw, lerpedw);
        ellipse(650, 350, lerpedw, lerpedw);

        ellipse(425, 400, lerpedw, lerpedw);
        ellipse(575, 400, lerpedw, lerpedw);

        ellipse(500, 450, lerpedw, lerpedw);

        strokeWeight(2);
        float offs = 0;

        //3rd
		for(int i = 0 ; i < ab.size() ; i ++)
		{
			float theta = map(i, 0, ab.size(), 0, TWO_PI);
			float x = (width - 900) + sin(theta) * (width - 900) * ((abs(ab.get(i)) / 2));
			float y = (height - 100) + cos(theta) * (width - 900) * ((abs(ab.get(i)) / 2));
			stroke(
				map(i + offs, 0, ab.size(), 0, 255) % 255
				,255
				,255
			);
			line((width - 900), (height - 100), x, y);
        }
        
		offs += average * 100f;	
        
        //4th
        for(int i = 0 ; i < ab.size() ; i ++)
		{
			float theta = map(i, 0, ab.size(), 0, TWO_PI);
			float x = (width - 100) + sin(theta) * (width - 100) * ((abs(ab.get(i)) / 8));
			float y = (height - 100) + cos(theta) * (width - 100) * ((abs(ab.get(i)) / 8));
			stroke(
				map(i + offs, 0, ab.size(), 0, 255) % 255
				,255
				,255
			);
			line((width - 100), (height - 100), x, y);
		}
        offs += average * 100f;
    }
    
}