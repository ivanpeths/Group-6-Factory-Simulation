import greenfoot.*;

/**
 * This upgrade repairs all broken machines
 * 
 * @author Kolby Ng, with help from Ivan Ma
 * @version (a version number or a date)
 */
public class Repair extends Upgrades
{
    //constructor
    public Repair (int side) {
        super(side); //calls superclass constructor
        image = new GreenfootImage("repair.png");
        setImage(image);
    }
    
    //activates upgrade
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
