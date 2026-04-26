import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buy extends Upgrades
{
    public Buy (int side) {
        super(side);
        image = new GreenfootImage("buy.png");
        setImage(image);
    }
    
    public void activate () {
        super.activate();
    }
}
