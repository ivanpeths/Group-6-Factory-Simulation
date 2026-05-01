import greenfoot.*;

/**
 * Superclass for different types of Machines 
 * Machines upgrade Products into new types, they can be broken and repaired.
 * 
 * @author Ivan Ma
 */
public abstract class Machines extends Actor
{
    protected GreenfootImage image;
    protected boolean broken; //broken or not
    //constructor
    public Machines () {
        broken = false; //start fixed
    }
    
    //randomly break after products enter
    public void checkBreak () {
        if (!broken && Greenfoot.getRandomNumber(15) == 0) {
            ((FactoryWorld) getWorld()).getSoundMan().playBreak(); //breaking sound
            breakMachine(); //random 1/15 chance to break for every product made
        }
    }
    
    public abstract void breakMachine (); //break self
    
    public abstract void unbreakMachine(); //repair self
    
    public boolean getBroken() {
        return broken; //check if products should be upgraded
    }
}
