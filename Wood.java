import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cardboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wood extends Product
{
    public Wood (int owner) {
        super(owner);
    }
    
    public void sell () {
        if (type == 0) {
            addScore(10);
        } else if (type == 1) {
            addScore(20);
        } else if (type == 2) {
            addScore(0);
        } else if (type == 3) {
            addScore(40);
        }
    }
}
