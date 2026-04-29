import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Fake pointer the simulated player use
 * to click on upgrades
 * 
 * 
 * 
 * @author Kolby Ng 
 */
public class Pointer extends SuperSmoothMover
{
    private int xSize = 30;
    private int ySize = 50;
    private int startX = 0;
    private int startY = 0;
    private double targetX;
    private double targetY;
    private double speed = 8.0;
    private boolean movingToUpgrade;
    private boolean movingToStart;
    private SoundManager soundMan;
    private Upgrades curUpgrade;
    
    public Pointer(SoundManager soundMan, int startX, int startY){
        GreenfootImage img = new GreenfootImage("pointer.png");
        img.scale(xSize, ySize);
        setImage(img);
        this.soundMan = soundMan;
        this.startX = startX;
        this.startY = startY;
    }
    
    public void activate(double targetX, double targetY, Upgrades upgrade){
        this.targetX = targetX;
        this.targetY = targetY;
        this.curUpgrade = upgrade;
        movingToUpgrade = true;
    }
    
    public void act(){
        if (movingToUpgrade){
            slideTowardsUpgrade();
        }
        
        if (movingToStart){
            slideTowardsStart();
        }
    }
    
    public void slideTowardsUpgrade(){
        double dx = targetX - getPreciseX();
        double dy = targetY - getPreciseY();
        double distance = Math.sqrt(dx * dx + dy * dy);
    
        if (distance <= speed) {
            setLocation(targetX, targetY);
            movingToUpgrade = false;
            movingToStart = true;
            soundMan.playClick();
            curUpgrade.activate();
            curUpgrade = null;
        } else {
            double ratio = speed / distance;
            setLocation(getPreciseX() + dx * ratio, getPreciseY() + dy * ratio);
        }
    }
    
    public void slideTowardsStart(){
        double dx = startX - getPreciseX();
        double dy = startY - getPreciseY();
        double distance = Math.sqrt(dx * dx + dy * dy);
    
        if (distance <= speed) {
            setLocation(startX, startY);
            movingToStart = false;
        } else {
            double ratio = speed / distance;
            setLocation(getPreciseX() + dx * ratio, getPreciseY() + dy * ratio);
        }
    }
}
