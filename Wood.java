// Wood by Isaac
import greenfoot.*;

public class Wood extends Product
{
    public Wood (int owner, double speed) {
        super(owner, speed);
    }

    @Override
    public void updateImage() 
    {
        if (type == 0) image = new GreenfootImage("brokenwood.png");
        else if (type == 1) image = new GreenfootImage("materialwood.png");
        else if (type == 2) image = new GreenfootImage("cheapwood.png");
        else if (type == 3) image = new GreenfootImage("expensivewood.png");
        else image = new GreenfootImage("veryexpensivewood.png");

        image.scale(50, 50);
        setImage(image);
    }

    @Override
    public void sell() 
    {
        if (type == 0) addScore(5);
        else if (type == 1) addScore(15);
        else if (type == 2) addScore(20);
        else if (type == 3) addScore(30);
        else addScore(50);
    }
}
