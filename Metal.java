// Metal by Isaac
import greenfoot.*;

public class Metal extends Product
{
    public Metal (int owner, double speed) {
        super(owner, speed);
    }

    @Override
    public void updateImage() 
    {
        if (type == 0) image = new GreenfootImage("placeholder.png");
        else if (type == 1) image = new GreenfootImage("placeholder.png");
        else if (type == 2) image = new GreenfootImage("placeholder.png");
        else image = new GreenfootImage("placeholder.png");

        image.scale(50, 50);
        setImage(image);
    }

    @Override
    public void sell() 
    {
        if (type == 0) addScore(5);
        else if (type == 1) addScore(10);
        else if (type == 2) addScore(20);
        else if (type == 3) addScore(40);
    }
}
