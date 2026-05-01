import greenfoot.*;

/**
 * This upgrade adds up to two other machines. 
 * 
 * @author Ivan Ma
 */
public class Buy extends Upgrades
{
    //constructor
    public Buy (int side) {
        super(side); //superclass constrcutor
        image = new GreenfootImage("buy.png");
        setImage(image);
    }
    
    //activates upgrade
    public void activate () {
        super.activate(); //superclass method
    
        FactoryWorld world = (FactoryWorld)getWorld();
    
        if (side == 1) { //left
            if (world.leftMachinesRemaining() == 0) { //none bought
                world.addLeftHandler(); //2nd last machine
            } else if (world.leftMachinesRemaining() == 1) { //first one bought
                world.addLeftPackager(); //last machine
            } else {
                ((FactoryWorld)getWorld()).changeLeftScore(100); //reinburse
            }
        } else { //left
            if (world.rightMachinesRemaining() == 0) { //same as above
                world.addRightHandler();
            } else if (world.rightMachinesRemaining() == 1) {
                world.addRightPackager();
            } else {
                ((FactoryWorld)getWorld()).changeRightScore(100);
            }
        }
    }
}
