import greenfoot.*;

/**
 * This upgrade breaks one of the other side's machine
 * 
 * @author Isaac Law
 */
public class Break extends Upgrades
{
    public Break (int side) {
        super(side);
        image = new GreenfootImage("break.png");
        setImage(image);
    }
    
    public void activate () {
        FactoryWorld w = (FactoryWorld) getWorld();
        super.activate();
        if (side == 1){
            w.breakRightMachine();
        } else {
            w.breakLeftMachine();
        }
    }
}
