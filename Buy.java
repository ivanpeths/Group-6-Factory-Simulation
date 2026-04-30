import greenfoot.*;

/**
 * This upgrade adds up to two other machines. 
 * 
 * @author Ivan Ma
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
