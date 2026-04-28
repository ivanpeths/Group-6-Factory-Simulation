import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BreakMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Break extends Upgrades
{
    public Break (int side) {
        super(side);
        image = new GreenfootImage("break.png");
        setImage(image);
    }
    
    public void activate () {
        super.activate();

    FactoryWorld world = (FactoryWorld)getWorld();
        if (side == 1) {
            world.getRightMachine().breakMachine();
        } else {
            world.getLeftMachine().breakMachine();
        }
    }
}
