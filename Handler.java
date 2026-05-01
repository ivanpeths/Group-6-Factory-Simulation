import greenfoot.*;

/**
 * Second machine
 * 
 * @author Ivan Ma
 */
public class Handler extends Machines
{
    //constructor
    public Handler () {
        image = new GreenfootImage("machine3.png");
        setImage(image);
    }
    
    //break machine
    public void breakMachine() {
        image = new GreenfootImage("brokenmachine3.png"); //broken image
        setImage(image);
        broken = true; //breaks
    }
    
    //fixes machine
    public void unbreakMachine(){
        image = new GreenfootImage("machine3.png"); //reverts image
        setImage(image);
        broken = false; //fixes
    }
}