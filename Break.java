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
        FactoryWorld w = (FactoryWorld) getWorld();
        super.activate();
        if (side == 1){
            w.getRightMachine().breakMachine();
        } else {
            w.getLeftMachine().breakMachine();
        }
    }
}
