import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Machines upgrade items into new types, they can be broken and repaired.
 * 
 * @author Ivan 
 */
public abstract class Machines extends Actor
{
    protected GreenfootImage image;
    protected boolean broken; //broken or not
    public Machines () {
        broken = false; //start fixed
    }
    
    public void checkBreak () {
        if (!broken && Greenfoot.getRandomNumber(15) == 0) {
            ((FactoryWorld) getWorld()).getSoundMan().playBreak();
            breakMachine(); //random 1/15 chance to break for every product made
        }
    }
    
    public abstract void breakMachine (); //break
    
    public abstract void unbreakMachine(); //repair
    
    public boolean getBroken() {
        return broken; //check if products should be upgraded
    }
}
