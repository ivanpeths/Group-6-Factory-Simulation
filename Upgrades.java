import greenfoot.*;

/**
 * Upgrades superclass
 * 
 * Five upgrades in total
 * Break - breaks one machine on the other side
 * Buy - buys an extra machine on your side
 * Quality - increase chance of expensive products spawning
 * Repair - repair all your machines
 * Spawn - increase product spawn rate
 * 
 * @author Ivan Ma
 */
public abstract class Upgrades extends Actor
{
    protected GreenfootImage image;
    protected int rechargeTimer; //timer for recharging
    protected boolean activated; //has this been used recently?
    protected int side; //which lane?
    protected int cost = 50; //cost for each upgrade
    
    //constructor
    
    public Upgrades (int side) {
        if (side == 50) { //which pixel are products spawning?
            this.side = 1; //left
        } else if (side == 1150) {
            this.side = 2; //right
        }
    }
    
    //called every frame
    public void act () {
        if (activated) { //start reset timer when activated
            rechargeTimer++;
        }
        if (rechargeTimer >= 420) { //7 seconds
            activated = false; //reactivate and become opaque
            rechargeTimer = 0; //reset timer
            getImage().setTransparency(255);
        }
    }
    
    //activates upgrade
    public void activate () { //activate upgrade, changed by each subclass
        getImage().setTransparency(50); //transparency down to show used
        activated = true; //start counting for timer
        rechargeTimer = 0; //resets timer after activation
        if (side == 1) { //left
            ((FactoryWorld)getWorld()).changeLeftScore(cost * -1); //costs $50
        } else { //right
            ((FactoryWorld)getWorld()).changeRightScore(cost * -1);
        }
    }
    
    public boolean getActivated () { //returns to check if upgrade can be called again
        return activated;
    }
}
