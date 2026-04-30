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
    protected int side;
    protected int cost = 50;
    
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
            rechargeTimer = 0;
            getImage().setTransparency(255);
        }
    }
    
    public void activate () { //activate upgrade, changed by each subclass
        getImage().setTransparency(50); //transparency down to show used
        activated = true; 
        rechargeTimer = 0;
        if (side == 1) {
            ((FactoryWorld)getWorld()).changeLeftScore(cost * -1); //costs $50
        } else {
            ((FactoryWorld)getWorld()).changeRightScore(cost * -1);
        }
    }
    
    public boolean getActivated () {
        return activated;
    }
}
