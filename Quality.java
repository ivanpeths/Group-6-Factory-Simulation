import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ProductQuality here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Quality extends Upgrades
{
    public Quality (int side) {
        super(side);
        image = new GreenfootImage("quality.png");
        setImage(image);
    }
    
    public void activate () {
        super.activate();
        if (side == 1) {
            ((FactoryWorld)getWorld()).updateLeftQuality();
        } else {
            ((FactoryWorld)getWorld()).updateRightQuality();
        }
    }
}
