/**
 * Middle tier product
 * 
 * @author Isaac Law, with help from Ivan Ma
 */
import greenfoot.*;

public class Wood extends Product
{
    //contructor
    public Wood (int owner, double speed) {
        super(owner, speed); //calls superclass constructor
    }

    //change image for each quality
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

    //sell item for score
    @Override
    public void sell() {
        if (type == 0) addScore(10); //adds score depending on type & quality
        else if (type == 1) addScore(15);
        else if (type == 2) addScore(25);
        else if (type == 3) addScore(35);
        else addScore(50);
    }
}
