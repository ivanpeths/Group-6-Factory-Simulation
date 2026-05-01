import greenfoot.*;

/**
 * This upgrade repairs all broken machines
 * 
 * @author Kolby Ng, with help from Ivan Ma
 * @version (a version number or a date)
 */
public class Repair extends Upgrades
{
    public Repair (int side) {
        super(side);
        image = new GreenfootImage("repair.png");
        setImage(image);
    }
    
    public void activate () {
        FactoryWorld w = (FactoryWorld) getWorld();
        super.activate(); //superclass method
        if (side == 1){ //left
            w.repairLeftMachines();
        } else { //right
            w.repairRightMachines();
        }
    }
}
