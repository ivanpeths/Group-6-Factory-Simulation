import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Assembler here.
 * 
 * @author (your name)
 * @version (a version number or a date)
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
}