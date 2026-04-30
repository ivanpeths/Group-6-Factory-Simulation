import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RepairMachine here.
 * 
 * @author (your name) 
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
        super.activate();
        if (side == 1){
            w.repairLeftMachines();
        } else {
            w.repairRightMachines();
        }
    }
}
