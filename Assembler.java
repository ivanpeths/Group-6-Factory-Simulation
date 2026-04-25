import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Assembler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Assembler extends Machines
{
    private double valueMultiplier;
    private GreenfootImage image;
    private boolean broken;
    
    public Assembler () {
        valueMultiplier = 1.5;
        image = new GreenfootImage("machine.png");
        setImage(image);
        broken = false;
        if (Greenfoot.getRandomNumber(5) == 0) {
            breakMachine();
        }
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void checkBreak () {
        if (Greenfoot.getRandomNumber(30) == 0) {
            breakMachine();
        }
    }
    
    public void breakMachine() {
        image = new GreenfootImage("brokenmachine.png");
        setImage(image);
        broken = true;
    }
    
    public boolean getBroken() {
        return broken;
    }
}
