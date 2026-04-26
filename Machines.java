import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Machines here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Machines extends Actor
{
    protected GreenfootImage image;
    protected boolean broken;
    public Machines () {
        broken = false;
        if (Greenfoot.getRandomNumber(5) == 0) {
            breakMachine();
        }
    }
    
    public void act () {
        
    }
    
    public void checkBreak () {
        if (Greenfoot.getRandomNumber(30) == 0) {
            breakMachine();
        }
    }
    
    public abstract void breakMachine ();
    
    public boolean getBroken() {
        return broken;
    }
}
