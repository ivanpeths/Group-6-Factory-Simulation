import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Draws the conveyor belts, allows ability to move seamlessly
 * 
 * @author Ivan Ma
 */
public class Conveyor extends Actor
{
    private GreenfootImage image;
    public Conveyor () {
        image = new GreenfootImage("conveyor.png");
        setImage(image);
    }
}
