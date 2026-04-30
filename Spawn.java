import greenfoot.*;

/**
 * This upgrade increases product spawn rates by 5 frames, around 83 milliseconds
 * 
 * @author Ivan Ma
 */
public class Spawn extends Upgrades
{
    public Spawn (int side) {
        super(side);
        image = new GreenfootImage("spawning.png");
        setImage(image);
    }
    
    public void activate () {
        super.activate();
        if (side == 1) {
            ((FactoryWorld)getWorld()).updateLeftSpawn();
        } else {
            ((FactoryWorld)getWorld()).updateRightSpawn();
        }
    }
}