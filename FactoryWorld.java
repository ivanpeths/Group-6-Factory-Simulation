import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FactoryWorld extends World
{
    private GreenfootImage background;
    
    /**
     * Constructor for objects of class MyWorld.
     */
    public FactoryWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        
        background = new GreenfootImage ("background.png");
        setBackground (background);
    }
}
