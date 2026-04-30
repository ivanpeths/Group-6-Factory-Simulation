import greenfoot.*;
/**
 * Cheapest product. 
 * 
 * @author Isaac Law
 */
public class Cardboard extends Product
{
    public Cardboard (int owner, double speed) {
        super(owner, speed);
    }

    @Override
    public void updateImage() 
    {
        if (type == 0) image = new GreenfootImage("brokencardboard.png");
        else if (type == 1) image = new GreenfootImage("materialcardboard.png");
        else if (type == 2) image = new GreenfootImage("cheapcardboard.png");
        else if (type == 3) image = new GreenfootImage("expensivecardboard.png");
        else image = new GreenfootImage("veryexpensivecardboard.png");

        image.scale(50, 50);
        setImage(image);
    }

    @Override
    public void sell() 
    {
        if (type == 0) addScore(1);
        else if (type == 1) addScore(10);
        else if (type == 2) addScore(15);
        else if (type == 3) addScore(25);
        else addScore(40);
    }
}
