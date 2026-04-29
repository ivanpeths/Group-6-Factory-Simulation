import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Upgrades randomly used by the computer
 * 
 * @author Ivan
 */
public abstract class Upgrades extends Actor
{
    protected GreenfootImage image;
    protected int rechargeTimer; //timer for recharging
    protected boolean activated; //has this been used recently?
    protected int side;
    
    public Upgrades (int side) {
        if (side == 50) { //which pixel are products spawning?
            this.side = 1; //left
        } else if (side == 1150) {
            this.side = 2; //right
        }
    }
    
    public void act () {
        if (activated) { //start reset timer when activated
            rechargeTimer++;
        }
        if (rechargeTimer >= 900) { //15 seconds
            activated = false; //reactivate and become opaque
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
    
    public void activate () { //activate upgrade, changed by each subclass
        getImage().setTransparency(50); //transparency down to show used
        activated = true; 
        rechargeTimer = 0;
        if (side == 1) {
            ((FactoryWorld)getWorld()).changeLeftScore(-100); //costs $100
        } else {
            ((FactoryWorld)getWorld()).changeRightScore(-100);
        }
    }
    
    public boolean getActivated () {
        return activated;
    }
}
