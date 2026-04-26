import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Assembler here.
 * 
 * @author (your name)
 * @version (a version number or a date)
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
}