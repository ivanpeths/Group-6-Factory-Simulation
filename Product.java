import greenfoot.*;
import java.util.List;

public abstract class Product extends SuperSmoothMover  
{
    protected int owner; // which player it belongs to 
    protected double speed; // movement speed 

    protected int type;
    protected GreenfootImage image;
    
    protected boolean inMachine;
    protected boolean upgraded;

    private boolean wasTouchingMachine;

    public Product(int owner, double speed)
    {
        this.owner = owner;
        type = 1; // material
        this.speed = speed;

        inMachine = false;
        upgraded = false;
        wasTouchingMachine = false;

        updateImage();
    }

    public void act()
    {
        moveDown();
        handleMachineInteraction(); 
        checkHitbox();
        checkEnd();
    }

    public abstract void updateImage();

    public void moveDown()
    {
        setLocation(getExactX(), getPreciseY() + speed);
    }

    private void handleMachineInteraction()
    {
        List<Machines> machines = getIntersectingObjects(Machines.class);
        boolean touchingMachine = !machines.isEmpty();

        // ENTER machine
        if (touchingMachine && !wasTouchingMachine) {
            Machines m = machines.get(0);

            if (!m.getBroken() && type != 0) {
                inMachine = true;
            }
        }

        // LEAVE machine
        if (!touchingMachine && wasTouchingMachine && inMachine) {
            type++;

            // 10% chance broken
            if (Greenfoot.getRandomNumber(10) == 0) {
                type = 0;
            }

            inMachine = false;
            updateImage();
        }

        wasTouchingMachine = touchingMachine;
    }

    private void checkHitbox() 
    {
        Hitbox h = (Hitbox)getOneIntersectingObject(Hitbox.class);

        if (h != null && !upgraded) {
            type++;

            if (Greenfoot.getRandomNumber(10) == 0) {
                type = 0;
            }

            upgraded = true;
            updateImage();
        } 
        else if (h == null) {
            upgraded = false;
        }
    }

    public void addScore (int score) 
    {
        FactoryWorld world = (FactoryWorld)getWorld();

        if (world == null) return; // safety

        if (owner == 1) {
            world.changeLeftScore(score);
        } else {
            world.changeRightScore(score);
        }
    }
    
    private void checkEnd()
    {
        World w = getWorld();
        if (w == null) return;

        if (getY() > w.getHeight() - 10)
        {
            FactoryWorld fw = (FactoryWorld) w;
            SoundManager soundMan = fw.getSoundMan();

            sell();

            if (owner == 1) {
                soundMan.playLeftCoin();
            } else {
                soundMan.playRightCoin();
            }

            w.removeObject(this);
        }
    }

    public abstract void sell ();

    public int getOwner()
    {
        return owner;
    }

    public int getType()
    {
        return type;
    }
}
