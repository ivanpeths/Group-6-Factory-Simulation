import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pointer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pointer extends SuperSmoothMover
{
    private int xSize = 30;
    private int ySize = 50;
    private int startX = 0;
    private int startY = 0;
    private double targetX;
    private double targetY;
    private double speed;
    private boolean moving;
    private SoundManager soundMan;
    
    public Pointer(SoundManager soundMan){
        GreenfootImage img = new GreenfootImage("pointer.png");
        img.scale(xSize, ySize);
        setImage(img);
        this.soundMan = soundMan;
    }
    
    public void startMoving(double targetX, double targetY, double speed){
        this.targetX = targetX;
        this.targetY = targetY;
        this.speed = speed;
        moving = true;
    }
    
    public void act(){
        if (moving){
            slideTowards();
        }
    }
    
    public void slideTowards(){
        double dx = targetX - getPreciseX();
        double dy = targetY - getPreciseY();
        double distance = Math.sqrt(dx * dx + dy * dy);
    
        if (distance <= speed) {
            setLocation(targetX, targetY);
            moving = false;
            soundMan.playClick();
            setLocation(startX, startY);
        } else {
            turnTowards((int) targetX, (int) targetY);
            move(speed);
        }
    }
}
