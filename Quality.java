import greenfoot.*;

/**
 * This upgrade increases the chance of more expensive Products spawning
 * 
 * @author Ivan Ma
 */
public class Quality extends Upgrades
{
    public Quality (int side) {
        super(side);
        image = new GreenfootImage("quality.png");
        setImage(image);
    }
    
    public void activate () {
        super.activate();
        if (side == 1) {
            ((FactoryWorld)getWorld()).updateLeftQuality();
        } else {
            ((FactoryWorld)getWorld()).updateRightQuality();
        }
    }
}
