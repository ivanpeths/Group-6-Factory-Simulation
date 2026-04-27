import greenfoot.*;

public class Cardboard extends Product
{
    public Cardboard(int owner) {
        super(owner);
    }

    @Override
    public void updateImage() 
    {
        if (type == 0) image = new GreenfootImage("broken_cardboard.png");
        else if (type == 1) image = new GreenfootImage("material_cardboard.png");
        else if (type == 2) image = new GreenfootImage("finish_cardboard.png");
        else image = new GreenfootImage("expensive_cardboard.png");

        image.scale(50, 50);
        setImage(image);
        getImage().setTransparency(transparency);
    }

    @Override
    public void sell() 
    {
        if (type == 0) addScore(0);      // broken = no money (fix this)
        else if (type == 2) addScore(10);
        else if (type == 3) addScore(25);
    }
}
