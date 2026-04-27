import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wood here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wood extends Product
{
    public Wood (int owner, double speed) {
        super(owner, speed);
    }
    
    public void sell () {
        if (type == 0) {
            addScore(5);
        } else if (type == 1) {
            addScore(10);
        } else if (type == 2) {
            addScore(0);
        } else if (type == 3) {
            addScore(15);
        }
    }
    
    @Override
    public void updateImage() {return;}
}
