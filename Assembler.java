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
    
    public Assembler () {
        valueMultiplier = 1.5;
        image = new GreenfootImage("machine.png");
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
