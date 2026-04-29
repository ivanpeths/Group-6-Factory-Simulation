import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Second machine
 * 
 * @author Ivan
 */
public class Handler extends Machines
{
    public Handler () {
        image = new GreenfootImage("machine3.png");
        setImage(image);
    }
    
    public void breakMachine() {
        image = new GreenfootImage("brokenmachine3.png");
        setImage(image);
        broken = true;
    }
    
    public void unbreakMachine(){
        image = new GreenfootImage("machine3.png");
        setImage(image);
        broken = false;
    }
}