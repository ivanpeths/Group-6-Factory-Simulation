import greenfoot.*;

/**
 * Third machine
 * 
 * @author Ivan Ma
 */
public class Packager extends Machines
{
    //constructor
    public Packager () {
        image = new GreenfootImage("machine2.png");
        setImage(image);
    }
    
    //breaks image
    public void breakMachine() {
        image = new GreenfootImage("brokenmachine2.png"); //broken image
        image.scale(150, 170);
        setImage(image);
        broken = true; //breaks
    }
    
    //fixes machine
    public void unbreakMachine(){
        image = new GreenfootImage("machine2.png"); //reverts image
        image.scale(150, 170);
        setImage(image);
        broken = false; //fixes
    }
}
