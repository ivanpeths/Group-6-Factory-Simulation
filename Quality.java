import greenfoot.*;

/**
 * This upgrade increases the chance of more expensive Products spawning
 * 
 * @author Ivan Ma
 */
public class Quality extends Upgrades
{
    //constructor
    public Quality (int side) {
        super(side); //superclass constructor
        image = new GreenfootImage("quality.png");
        setImage(image);
    }
    
    //activates upgrade
    public void activate () {
        super.activate(); //superclass method
        if (side == 1) { //left
            ((FactoryWorld)getWorld()).updateLeftQuality();
        } else { //right
            ((FactoryWorld)getWorld()).updateRightQuality();
        }
    }
}
