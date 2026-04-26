import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spawn extends Upgrades
{
    public Spawn (int side) {
        super(side);
        image = new GreenfootImage("spawning.png");
        setImage(image);
    }
    
    public void activate () {
        super.activate();
    }
}
