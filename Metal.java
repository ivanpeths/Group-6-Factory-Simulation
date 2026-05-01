import greenfoot.*;

/**
 * Most expensive Product
 * 
 * @author Isaac Law, with help from Ivan Ma
 */

public class Metal extends Product
{
    //contructor
    public Metal (int owner, double speed) {
        super(owner, speed);
    }

    //change image for each quality
    @Override
    public void updateImage() 
    {
        if (type == 0) image = new GreenfootImage("brokeniron.png");
        else if (type == 1) image = new GreenfootImage("materialiron.png");
        else if (type == 2) image = new GreenfootImage("cheapiron.png");
        else if (type == 3) image = new GreenfootImage("expensiveiron.png");
        else image = new GreenfootImage("veryexpensiveiron.png");

        image.scale(50, 50);
        setImage(image);
    }

    //sell item for score
    @Override
    public void sell() 
    {
        if (type == 0) addScore(15);
        else if (type == 1) addScore(20);
        else if (type == 2) addScore(30);
        else if (type == 3) addScore(50);
        else addScore(75);
    }
}
