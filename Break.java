import greenfoot.*;

/**
 * This upgrade breaks one of the other side's machine
 * 
 * @author Isaac Law with help from Ivan Ma
 */
public class Break extends Upgrades
{
    //constructor
    public Break (int side) {
        super(side); //superclass constructor
        image = new GreenfootImage("break.png");
        setImage(image);
    }
    
    //activates upgrade
    public void activate () {
        FactoryWorld w = (FactoryWorld) getWorld();
        super.activate(); //superclass method
        // break the enemy's machine
        if (side == 1){ //left
            w.breakRightMachine();
        } else { //right
            w.breakLeftMachine();
        }
    }
}
