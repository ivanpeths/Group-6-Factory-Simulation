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
        if (Greenfoot.getRandomNumber(5) == 0) {
            breakMachine(); //random 1/5 chance to start broken
        }
    }
    
    public void checkBreak () {
        if (Greenfoot.getRandomNumber(15) == 0) {
            breakMachine(); //random 1/15 chance to break for every product made
        }
    }
    
    public abstract void breakMachine (); //break
    
    public abstract void unbreakMachine(); //repair
    
    public boolean getBroken() {
        return broken; //check if products should be upgraded
    }
}
