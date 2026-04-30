import greenfoot.*;

/**
 * This upgrade increases product spawn rates by 5 frames, around 83 milliseconds
 * 
 * @author Ivan Ma
 */
public class Spawn extends Upgrades
{
    public Spawn (int side) {
        super(side); //calls superclass constructor
        image = new GreenfootImage("spawning.png"); //image for upgrade
        setImage(image);
    }
    
    public void activate () {
        super.activate(); //calls superclass method
        if (side == 1) { //left
            ((FactoryWorld)getWorld()).updateLeftSpawn();
        } else { //right
            ((FactoryWorld)getWorld()).updateRightSpawn();
        }
    }
}