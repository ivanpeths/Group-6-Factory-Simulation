import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Powerups here.
 * 
 * @author (your name) 
 * @version (a version number or a date) 
 */
public abstract class Upgrades extends Actor
{
    protected GreenfootImage image;
    protected int rechargeTimer;
    protected boolean activated;
    protected int side;
    
    public Upgrades (int side) {
        if (side == 50) {
            this.side = 1;
        } else if (side == 1150) {
            this.side = 2;
        }
    }
    
    public void act () {
        if (activated) {
            rechargeTimer++;
        }
        if (rechargeTimer >= 900) {
            activated = false;
            getImage().setTransparency(255);
        }
            
        /* Not the effect I had in mind - Kolby
        if (isTouching(Pointer.class) && !activated) { // Remove after pointer works
            if (side == 1) {
                if (((FactoryWorld)getWorld()).getLeftScore() >= 100) {
                    activate();
                }
            } else {
                if (((FactoryWorld)getWorld()).getRightScore() >= 100) {
                    activate();
                }
            }       
        }
        */
    }
    
    public void activate () {
        getImage().setTransparency(50);
        activated = true;
        rechargeTimer = 0;
        if (side == 1) {
            ((FactoryWorld)getWorld()).changeLeftScore(-100);
        } else {
            ((FactoryWorld)getWorld()).changeRightScore(-100);
        }
    }
    
    public boolean getActivated () {
        return activated;
    }
}
