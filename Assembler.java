import greenfoot.*;

/**
 * Starting machine
 * 
 * @author Ivan Ma
 */
public class Assembler extends Machines
{
    //constructor
    public Assembler () {
        image = new GreenfootImage("machine.png");
        setImage(image);
    }
    
    //breaks machine
    public void breakMachine() {
        image = new GreenfootImage("brokenmachine.png");
        setImage(image);
        broken = true;
    }
    
    //fixes machine
    public void unbreakMachine(){
        image = new GreenfootImage("machine.png"); //reverts image
        setImage(image);
        broken = false; //fixes
    }
}