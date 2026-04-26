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
        if (!activated) {
            rechargeTimer++;
        }
        if (rechargeTimer == 900) {
            activated = false;
            getImage().setTransparency(255);
        }
    }
    
    public void activate () {
        FactoryWorld world = (FactoryWorld)getWorld();
        getImage().setTransparency(50);
        activated = true;
        if (side == 1) {
            world.changeLeftScore(-200);
        } else {
            world.changeRightScore(-200);
        }
    }
    
    public boolean getActivated () {
        return activated;
    }
}