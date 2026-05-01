import greenfoot.*;
/**
 * Cheapest product. 
 * 
 * @author Isaac Law, with help from Ivan Ma
 */
public class Cardboard extends Product
{
    //contructor
    public Cardboard (int owner, double speed) {
        super(owner, speed);
    }

    //change image for each quality
    @Override
    public void updateImage() //apply image depending on quality
    {
        if (type == 0) image = new GreenfootImage("brokencardboard.png");
        else if (type == 1) image = new GreenfootImage("materialcardboard.png");
        else if (type == 2) image = new GreenfootImage("cheapcardboard.png");
        else if (type == 3) image = new GreenfootImage("expensivecardboard.png");
        else image = new GreenfootImage("veryexpensivecardboard.png");

        image.scale(50, 50);
        setImage(image);
    }

    //sell item for score
    @Override
    public void sell() 
    {
        if (type == 0) addScore(5);
        else if (type == 1) addScore(10);
        else if (type == 2) addScore(15);
        else if (type == 3) addScore(20);
        else addScore(30);
    }
}
