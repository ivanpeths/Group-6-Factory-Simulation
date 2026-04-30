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
    private double idleX;
    private double idleY;
    private double upgradeSpeed = 8.0;
    private double idleSpeed = 4.0;
    private boolean movingToUpgrade = false;
    private boolean movingToStart = false;
    private boolean finishedIdle = true;
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
        finishedIdle = true;
    }
    
    public void act(){
        if (movingToUpgrade){
            slideTowardsUpgrade();
        }
        
        if (movingToStart){
            slideTowardsStart();
        }
        
        if (!movingToStart && !movingToUpgrade){
            if (finishedIdle){
                newIdlePos();
            } else {
                idle();
            }
        }
    }
    
    public void newIdlePos(){
        World w = getWorld();
        finishedIdle = false;
        if (owner == 1){
            idleX = getRandomNumber(0, w.getWidth() / 2);
            idleY = getRandomNumber(0, w.getHeight());
        } else {
            idleX = getRandomNumber(w.getWidth() / 2, w.getWidth());
            idleY = getRandomNumber(0, w.getHeight());
        }
    }
    
    public void slideTowardsUpgrade(){
        // Get difference in x and y
        double dx = targetX - getPreciseX();
        double dy = targetY - getPreciseY();
        // Hypotenuse
        double distance = Math.sqrt(dx * dx + dy * dy);

        // If close to target
        if (distance <= upgradeSpeed) {
            // Snap to target
            setLocation(targetX, targetY);
            movingToUpgrade = false;
            movingToStart = true;
            soundMan.playClick();
            curUpgrade.activate();
            playSound();
            curUpgrade = null;
        } else {
            double ratio = upgradeSpeed / distance;
            setLocation(getPreciseX() + dx * ratio, getPreciseY() + dy * ratio);
        }
    }
    
    public void playSound(){
        FactoryWorld fw = (FactoryWorld) getWorld();
        if (curUpgrade instanceof Break){
            soundMan.playBreak();
            if (owner == 1){
                fw.addLeftBreakLabel();
            } else {
                fw.addRightBreakLabel();
            }
        } else if (curUpgrade instanceof Repair){
            soundMan.playRepair();
            if (owner == 1){
                fw.addLeftRepairLabel();
            } else {
                fw.addRightRepairLabel();
            }
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
            if (owner == 1){
                fw.addLeftBuyLabel();
            } else {
                fw.addRightBuyLabel();
            }
        }
    }
    
    public void idle(){
        // Get difference in x and y
        double dx = idleX - getPreciseX();
        double dy = idleY - getPreciseY();
        // Hypotenuse
        double distance = Math.sqrt(dx * dx + dy * dy);
    
        // If close to target
        if (distance <= idleSpeed) {
            setLocation(idleX, idleY);
            finishedIdle = true;
        } else {
            double ratio = idleSpeed / distance;
            setLocation(getPreciseX() + dx * ratio, getPreciseY() + dy * ratio);
        }
    }
    
    // From https://www.greenfoot.org/topics/1986
    public int getRandomNumber(int start,int end)
    {
       int normal = Greenfoot.getRandomNumber(end-start+1);
       return normal+start;
    }

    public void slideTowardsStart(){
        // Get difference in x and y
        double dx = startX - getPreciseX();
        double dy = startY - getPreciseY();
        // Hypotenuse
        double distance = Math.sqrt(dx * dx + dy * dy);
    
        // If close to target
        if (distance <= upgradeSpeed) {
            // Snap to target
            setLocation(startX, startY);
            movingToStart = false;
        } else {
            double ratio = upgradeSpeed / distance;
            setLocation(getPreciseX() + dx * ratio, getPreciseY() + dy * ratio);
        }
    }
}
