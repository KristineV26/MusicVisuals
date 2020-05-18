# Music Visualiser Project

Name: Kristine Viernes

Student Number: C18388556

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
For this assignment we were required to create our own versions of the Music Visualizer. Something a person can watch while listening to music.

# Instructions

# How it works
For my Music Visualiser I have 3 different types of visualiser methods called as
1.	create_star
2.	create_flower
3.	create_heart

# create_star
When I listened to the song I chose, the first thing I though of was the beach during the night which gave me the idea for this one. For the stars I chose to use ellipse and when the stars “shine” is when the ellipse expands or contracts base on the beat of the music. Then the wave is like the sea waves.

```Java
for(int i = 0 ; i < width; i++) {
            stroke( map(i % ab.size(), 0, ab.size(), 0, 255), 255 , 255 );
            line(i, y, i , y + ab.get(i % ab.size()) * cy);
            sum += abs(ab.get(i % ab.size()));
        }
```
With this one my struggle was to get the wave all the way through the screen which in my opinion was because the width was bigger than the buffer so instead I used the modulus of the buffer so if it goes out of bound then it would go back to 0, 
The wave is created inside a for loop that is looping with the width and every time it loops a line is drawn based on the buffer and multiply that by a certain number so the significant changes can be seen and then add that to the y coordinate of where I want to place this wave.
In the for loop, I added the sum buffer and getting the average using it as the destination attribute of lerp which controls how much the ellipse contracts and expands

```Java
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
```


# Create_flower
To fit the softness of this music I had an idea for a flower field. I decided to use a visualiser that increases and decreases from a certain starting point which, in my opinion, looked similar to a flower. In the middle off the “flower field”, I wanted to put something different in the middle as an emphasis and to do so, I changed one of the attributes of this visualiser to create an elongated version of it, which I found while messing with the code when I was first trying to figure out how the visualiser worked. 
Inside a loop, I map the audio buffer into pi and making it equals to theta. Then I needed the x and y coordinates of one end of the line. For the x,  the x coordinate of where I want the line to start is added into sin(theta) which is multiplied into the x coordinate which is also multiplied to the buffer (which I divided into 2 as I didn’t want the lines to go too far). For the y, I didn’t the same but instead of the x coordinate of where I want the line to start, I used the y coordinate. Then I create a line where I choose the starting x and y coordinate and the calculated x and y is the other end of the line

```java

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

```


# Create_heart
I wanted to add a bit of a personalisation in this assignment, so I decided to create a shape of heart using ellipse. I wanted the heart to look like it was beating which the ellipse contracting and expanding help create.
At first, I struggled to get the right coordinates of the heart, so I decided to create a graph on paper first and create a heart there first. When I started making a heart, I forgot to take into consideration that the width of the screen was not 1000 but 1024. This caused a bit of a problem first as I used (width / 2) as my x coordinate and basing all the next coordinates off it. It took me a while because the paper graph I originally had now does not make sense and I tried to change the coordinates gradually trying to align the coordinates, until I realised why I was struggling. After realising this I was able to base it off my graph and used 500 instead of (width / 2).
To create this, I used the average of the audio buffer by first getting the sum of the audio buffer then dividing it by its size. Then, I used this average by multiplying it by 100 first so we can see the significant change and then using this number as an attribute in lerp() as its stop (where the ellipse expands or contracts). With this the ellipse will now expand and collapse based on the average changing

To play this, you would have to click enter and when you do, you can click on b to go to flower and c to go to the star. This is because in the key pressed method, if a was clicked then the heart method would be true and then run, if b was clicked then flower would be true and flower would run and then if c is clicked then the star would run.


# What I am most proud of in the assignment
The part I am most proud of in the assignment is create_heart. Though I loved all parts of the assignments as I wanted all of it to have some story. It could be because that is where I was the most frustrated about but when it all came together, I thought it looked very pretty. I also added some of the circular visualiser at the bottom left- and right-hand side which I thought enhanced the whole thing. I also like it because I incorporated it to add some personalisation. I also like the idea of the beating heart based on the beat of the music.

This is the youtube video:

[![YouTube](https://www.youtube.com/watch?v=87RE3a4C0m8)]
https://www.youtube.com/watch?v=87RE3a4C0m8

