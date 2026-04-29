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
    
        FactoryWorld world = (FactoryWorld)getWorld();
    
        if (side == 1) {
            if (world.leftMachinesRemaining() == 0) {
                world.addLeftHandler();
            } else if (world.leftMachinesRemaining() == 1) {
                world.addLeftPackager();
            } else {
                ((FactoryWorld)getWorld()).changeLeftScore(100);
            }
        } else {
            if (world.rightMachinesRemaining() == 0) {
                world.addRightHandler();
            } else if (world.rightMachinesRemaining() == 1) {
                world.addRightPackager();
            } else {
                ((FactoryWorld)getWorld()).changeRightScore(100);
            }
        }
    }
}
