import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Assembler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Packager extends Machines
{
    public Packager () {
        image = new GreenfootImage("machine2.png");
        setImage(image);
    }
    
    public void breakMachine() {
        image = new GreenfootImage("brokenmachine2.png");
        image.scale(150, 170);
        setImage(image);
        broken = true;
    }
    
    public void unbreakMachine(){
        image = new GreenfootImage("machine2.png");
        image.scale(150, 170);
        setImage(image);
        broken = false;
    }
}
