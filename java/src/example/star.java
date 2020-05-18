package example;
import ie.tudublin.*;

public class star extends MyVisual{

    float sum;
    float cy;
    float y;
    float lerpedw;
    float average;

    public star()
    {
        sum = 0;
        y = height - 100;
        lerpedw  = 0;
    }

    public void render()
    {
        float cy = height / 5;
        
        for(int i = 0 ; i < ab.size() ; i ++) {
            stroke( map(i, 0, ab.size(), 0, 255), 255 , 255 );
            line(i, y, i, y + ab.get(i) * cy);
            sum += abs(ab.get(i));
        }
        average = sum / ab.size();
    
        float w = average * 100;
        lerpedw = lerp(lerpedw, w, 0.6f);
        noStroke();
        fill(map(average, 0, 1, 0, 255) , 255 , 255 );
    
        for(int x = 30; x < 1000; x += 130) {
            ellipse(x, cy, lerpedw, lerpedw);
        }
    
        int cyy = height/2 ;
        for(int x = 80; x < 1000; x += 180)
        {
            ellipse(x, cyy,lerpedw, lerpedw);
        }
    }
}