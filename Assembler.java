import greenfoot.*;

/**
 * Starting machine
 * 
 * @author Ivan Ma
 */
public class Assembler extends Machines
{
    public Assembler () {
        image = new GreenfootImage("machine.png");
        setImage(image);
    }
    
    public void breakMachine() {
        image = new GreenfootImage("brokenmachine.png");
        setImage(image);
        broken = true;
    }
    
    public void unbreakMachine(){
        image = new GreenfootImage("machine.png");
        setImage(image);
        broken = false;
    }
}