import greenfoot.*;

/**
 * Fake pointer the simulated player use
 * to click on upgrades
 * 
 * Uses SuperSmoothMover to move smoothly
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
    private int owner;
    
    public Pointer(SoundManager soundMan, int startX, int startY, int owner){
        GreenfootImage img = new GreenfootImage("pointer.png");
        img.scale(xSize, ySize);
        setImage(img);
        this.soundMan = soundMan;
        this.startX = startX;
        this.startY = startY;
        this.owner = owner;
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
        // Get difference in x and y
        double dx = targetX - getPreciseX();
        double dy = targetY - getPreciseY();
        // Hypotenuse
        double distance = Math.sqrt(dx * dx + dy * dy);

        // If close to target
        if (distance <= speed) {
            // Snap to target
            setLocation(targetX, targetY);
            movingToUpgrade = false;
            movingToStart = true;
            soundMan.playClick();
            curUpgrade.activate();
            playSound();
            curUpgrade = null;
        } else {
            double ratio = speed / distance;
            setLocation(getPreciseX() + dx * ratio, getPreciseY() + dy * ratio);
        }
    }
    
    public void playSound(){
        FactoryWorld fw = (FactoryWorld) getWorld();
        if (curUpgrade instanceof Break){
            soundMan.playBreak();
        } else if (curUpgrade instanceof Repair){
            soundMan.playRepair();
        } else if (curUpgrade instanceof Quality){
            soundMan.playQuality();
            if (owner == 1){
                fw.addLeftQualityLabel();
            } else {
                fw.addRightQualityLabel();
            }
        } else if (curUpgrade instanceof Spawn){
            soundMan.playSpawn();
            if (owner == 1){
                fw.addLeftSpawnLabel();
            } else {
                fw.addRightSpawnLabel();
            }
        } else{
            soundMan.playBuy();
        }
    }
    
    public void slideTowardsStart(){
        // Get difference in x and y
        double dx = startX - getPreciseX();
        double dy = startY - getPreciseY();
        // Hypotenuse
        double distance = Math.sqrt(dx * dx + dy * dy);
    
        // If close to target
        if (distance <= speed) {
            // Snap to target
            setLocation(startX, startY);
            movingToStart = false;
        } else {
            double ratio = speed / distance;
            setLocation(getPreciseX() + dx * ratio, getPreciseY() + dy * ratio);
        }
    }
}
