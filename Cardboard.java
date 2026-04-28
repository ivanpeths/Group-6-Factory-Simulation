import greenfoot.*;

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
        else image = new GreenfootImage("expensivecardboard.png");

        image.scale(50, 50);
        setImage(image);
    }

    @Override
    public void sell() 
    {
        if (type == 1) addScore(10);
        else if (type == 2) addScore(20);
        else if (type == 3) addScore(40);
    }
}
