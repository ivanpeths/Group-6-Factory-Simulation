import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pointer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pointer extends SuperSmoothMover
{
    private int xSize = 50;
    private int ySize = 75;
    
    public Pointer(){
        GreenfootImage img = new GreenfootImage("pointer.png");
        img.scale(xSize, ySize);
        setImage(img);
    }
    
    public void act()
    {
        
    }
}
