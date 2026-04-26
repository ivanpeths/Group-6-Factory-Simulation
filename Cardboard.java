import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cardboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cardboard extends Product
{
    public Cardboard (int owner) {
        super(owner);
    }
    
    public void sell () {
        FactoryWorld world = (FactoryWorld)getWorld();
    
        if (type == 1) // finished
        {
            if (owner == 1)
                world.addLeftScore(10);
            else
                world.addRightScore(10);
        }
        else if (type == 3) // expensive
        {
            if (owner == 1)
                world.addLeftScore(25);
            else
                world.addRightScore(25);
        }
    }
}
