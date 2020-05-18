package example;

import ie.tudublin.*;

public class MyVisual extends Visual {
    WaveForm wf;
    AudioBandsVisual abv;
    float frameSize;
    float sampleRate;
    boolean str;
    boolean hrt;
    boolean flwr;

    public void settings() {
        size(1024, 500);
    }

    public void setup() {
        startMinim();
        // Call loadAudio to load an audio file to process
        loadAudio("inlwag.mp3");
        setFrameSize(1024);
        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);
        colorMode(HSB);
        sampleRate = getSampleRate();
        frameSize = getFrameSize();
        str = false;
        hrt = false;
        flwr = false;
    }

    public void keyPressed()
    {
        if(key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }

        if(key == 'a')
        {
            flwr = true;
        }
        if(key == 'b')
        {
            hrt = true;
        }
        if(key == 'c')
        {
            str = true;
        }
    }

    public void create_star()
    {
        float sum = 0;
        float y = height - 100;
        float lerpedw  = 0;
        float average;

        float cy = height / 5;
        
        for(int i = 0 ; i < width; i++) {
            stroke( map(i % ab.size(), 0, ab.size(), 0, 255), 255 , 255 );
            line(i, y, i , y + ab.get(i % ab.size()) * cy);
            sum += abs(ab.get(i % ab.size()));
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

    public void create_flower()
    {
        float offs = 0;
        float average = 0;
        float cx;
        float cy;
         strokeWeight(2);
        cx =  width / 5;
        cy =  height / 2;

        // bottom left
        for (int i = 0; i < ab.size(); i++) {
            float theta = map(i, 0, ab.size(), 0, TWO_PI);
			float x = ( width - 800) + sin(theta) * ( width - 800) * ((abs(ab.get(i)) / 2));
			float y = ( height - 125) + cos(theta) * cx * ((abs(ab.get(i)) / 2));
			 stroke(
				     map(i + offs, 0, ab.size(), 0, 255) % 255
				,255
				,255
			);
			 line(( width - 800), ( height - 125), x, y);
        }
        
		offs += average * 100f;	
        
        //middle
        for(int i = 0 ; i < ab.size() ; i ++)
		{
			float theta =  map(i, 0, ab.size(), 0, TWO_PI);
			float x = ( width / 2) +  sin(theta) * ( width / 2) * (( abs(ab.get(i)) / 2));
			float y = ( width / 5.01f) +  cos(theta) * cx * (( abs(ab.get(i)) / 2));
			 stroke(
				     map(i + offs, 0, ab.size(), 0, 255) % 255
				,255
				,255
			);
			 line(( width / 2), cy, x, y);
		}
        offs += average * 100f;	
        
        //bottom right
        for(int i = 0 ; i < ab.size() ; i ++)
		{
			float theta =  map(i, 0, ab.size(), 0, TWO_PI);
			float x = ( width - 200) +  sin(theta) * ( width - 200) * (( abs(ab.get(i)) / 8));
			float y = ( height - 125) +  cos(theta) * ( width - 200) * (( abs(ab.get(i)) / 8));
			 stroke(
				 map(i + offs, 0, ab.size(), 0, 255) % 255
				,255
				,255
			);
			 line(( width - 200), ( height - 125), x, y);
		}
        offs += average * 100f;
        
        //top left
        for(int i = 0 ; i < ab.size() ; i ++)
		{
			float theta =  map(i, 0, ab.size(), 0, TWO_PI);
			float x = ( width - 800) +  sin(theta) * ( width - 800) * (( abs(ab.get(i)) / 2));
			float y = ( height - 425) +  cos(theta) * ( width - 800) * (( abs(ab.get(i)) / 2));
			 stroke(
				 map(i + offs, 0, ab.size(), 0, 255) % 255
				,255
				,255
			);
			 line(( width - 800), ( height - 425), x, y);
		}
        offs += average * 100f;
        
        //top right
        for(int i = 0 ; i < ab.size() ; i ++)
		{
			float theta =  map(i, 0, ab.size(), 0, TWO_PI);
			float x = ( width - 200) +  sin(theta) * ( width - 200) * (( abs(ab.get(i)) / 8));
            float y = ( height - 425) +  cos(theta) * ( width - 200) * ((abs(ab.get(i)) / 8));
			 stroke(
				map(i + offs, 0, ab.size(), 0, 255) % 255
				,255
				,255
			);
			line((width - 200), (height - 425), x, y);
		}
        offs += average * 100f;
    }


    public void create_heart()
    {
        float lerpedw = 0;
        float sum = 0;
        float average;

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
    

    

    public void draw() {
        // float sampleRate = getSampleRate();
        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        
        // Call this is you want to use frequency bands
        calculateFrequencyBands();

        calculateAverageAmplitude();        
        
        if(str == true)
        {
            create_star();
        }
        else if(flwr == true)
        {
            create_flower();
        }
        else if(hrt == true)
        {
            create_heart();
        }
        else
        {
            create_flower();
        }
        // wf.render();
        // abv.render();

    }
    
}
