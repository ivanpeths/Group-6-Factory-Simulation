import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Metal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Metal extends Product
{
    public Metal (int owner, double speed) {
        super(owner, speed);
    }
    
    public void sell () {
        if (type == 0) {
            addScore(20);
        } else if (type == 1) {
            addScore(40);
        } else if (type == 2) {
            addScore(5);
        } else if (type == 3) {
            addScore(60);
        }
    }
    
    @Override
    public void updateImage() {return;}
}
