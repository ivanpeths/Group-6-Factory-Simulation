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
    private double speed = 5.0;
    private boolean moving;
    private SoundManager soundMan;
    private Upgrades curUpgrade;
    
    public Pointer(SoundManager soundMan, int startX, int startY){
        GreenfootImage img = new GreenfootImage("pointer.png");
        img.scale(xSize, ySize);
        img.setTransparency(0);
        setImage(img);
        this.soundMan = soundMan;
        this.startX = startX;
        this.startY = startY;
    }
    
    public void activate(double targetX, double targetY, Upgrades upgrade){
        this.targetX = targetX;
        this.targetY = targetY;
        this.curUpgrade = upgrade;
        getImage().setTransparency(255);
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
            getImage().setTransparency(0);
            curUpgrade.activate();
            setLocation(startX, startY);
            curUpgrade = null;
        } else {
            turnTowards((int) targetX, (int) targetY);
            move(speed);
        }
    }
}
