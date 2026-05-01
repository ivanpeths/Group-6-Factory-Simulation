import greenfoot.*;
import java.util.List;

/**
 * Product superclass
 * 
 * @author Isaac Law, with help from Ivan Ma, commented mostly by Ivan, including subclasses
 * 
 * All images by Gemini
 */

public abstract class Product extends SuperSmoothMover  
{
    protected int owner; // which player it belongs to 
    protected double speed; // movement speed

    protected int type; // affects products image and type
    protected GreenfootImage image;

    // machine interaction
    protected boolean inMachine; //see below
    protected boolean upgraded; //prevents upgrading multiple times at once

    // track machine collision (enter/exit)     
    protected boolean wasTouchingMachine;
    protected Machines currentMachine; //see above
    
    protected int machinesRemaining; //tracks how many more possible machines to enter

    //constructor
    public Product(int owner, double speed)
    {
        this.owner = owner;
        type = 1; //starts as material
        this.speed = speed;

        inMachine = false; //starts outside machine
        upgraded = false; //starts unupgraded
        wasTouchingMachine = false; //starts without touching machine
        currentMachine = null; //starts without a machine

        updateImage(); //updates image for material
    }

    //called every frame
    public void act()
    {
        moveDown(); //movement
        handleMachineInteraction(); 
        checkHitbox(); //check if product has reached a hitbox to upgrade
        checkEnd(); //check if product should be soldd
    }

    //different product should have different images
    public abstract void updateImage();

    //moving for products
    public void moveDown()
    {
        setLocation(getExactX(), getPreciseY() + speed);
    }

     /**
     * handles entering and exiting machines
     * detects collisions and updates machine interaction state
     */
    private void handleMachineInteraction()
    {
        List<Machines> machines = getIntersectingObjects(Machines.class);
        boolean touchingMachine = !machines.isEmpty();

        //enter machine after not being in one - prevents upgrading multiple times
        if (touchingMachine && !wasTouchingMachine) {
            Machines m = machines.get(0);

            if (!m.getBroken() && type != 0) { //makes sure both arent broken
                inMachine = true; //prevent upgrading 2+ times
                currentMachine = m;
                m.checkBreak(); //check if machine should break
            }
        }

        // exit machine
        if (!touchingMachine && wasTouchingMachine && inMachine) {
            inMachine = false; //reset machine touching
            currentMachine = null;
        }

        wasTouchingMachine = touchingMachine;
    }

    //changes type in a hitbox on machine to prevent changing outside
    private void checkHitbox() 
    {
        Hitbox h = (Hitbox)getOneIntersectingObject(Hitbox.class);
        Machines m = (Machines)getOneIntersectingObject(Machines.class);

        //both are touching and not upgraded currently
        //prevents products from upgrading outside machine
        if (h != null && m != null && !upgraded) {
            if (!m.getBroken()) {
                type++; //increases type once in order to upgrade
                FactoryWorld fw = (FactoryWorld) getWorld();
                //left
                if (owner == 1){
                    machinesRemaining = fw.leftMachinesRemaining();
                } else { //right
                    machinesRemaining = fw.rightMachinesRemaining();
                }
                int maxType = 2 + machinesRemaining;
                type = Math.min(type, maxType);

                // Broken chance (10%)
                if (Greenfoot.getRandomNumber(10) == 0) {
                    type = 0;
                }
                
                upgraded = true;
                updateImage(); //updates to new image
            }
        } 
        else if (h == null) {
            upgraded = false;
        }
    }

    //default add score method
    public void addScore (int score) 
    {
        FactoryWorld world = (FactoryWorld)getWorld();
        if (world == null) return; //makes sure its in a world

        if (owner == 1) { //left
            world.changeLeftScore(score);
        } else { //right
            world.changeRightScore(score);
        }
    }

    // checks if product reached the bottom of world
    private void checkEnd()
    {
        World w = getWorld();
        if (w == null) return; //fixed crashes if called on object already removed

        if (getY() > w.getHeight() - 10) //before leaving the world
        {
            FactoryWorld fw = (FactoryWorld) w;
            SoundManager soundMan = fw.getSoundMan();

            sell(); //sells

            if (owner == 1) soundMan.playLeftCoin();
            else soundMan.playRightCoin(); //sell sound

            w.removeObject(this); //remove
        }
    }

    public abstract void sell (); //each product should sell for its own price

    //getters for owner and type
    public int getOwner() { return owner; }
    public int getType() { return type; }
}
