import greenfoot.*;

public abstract class Product extends SuperSmoothMover  
{
    protected int owner; // which player it belongs to
    protected double speed; // movement speed

    protected int type;
    protected GreenfootImage image;
    
    protected boolean inMachine;

    public Product(int owner, double speed)
    {
        this.owner = owner;
        type = 1; // material
        this.speed = speed;
        updateImage();
        inMachine = false;
    }

    public void act()
    {
        moveDown();
        checkMachine();
        checkLeavingMachine();
        checkEnd();
        if (getWorld() == null) {
            return;
        }
    }

    public abstract void updateImage();

    public void moveDown()
    {
        setLocation(getExactX(), getPreciseY() + speed);
    }

    private void checkMachine()
    {
        Machines m = (Machines)getOneIntersectingObject(Machines.class);
        
        if (m != null) {
            if (!(m.getBroken()) && type != 0) {
                inMachine = true;
                updateImage();
            }
        }
    }
   
    public void addScore (int score) {
        FactoryWorld world = (FactoryWorld)getWorld();
        if (owner == 1) {
            world.changeLeftScore(score);
        } else {
            world.changeRightScore(score);
        }
    }
    
    private void checkLeavingMachine() {
        Machines m = (Machines)getOneIntersectingObject(Machines.class);
        
        if (m == null && inMachine) {
            type++;
            if (Greenfoot.getRandomNumber(10) == 0) {
                type = 0;
            }
            inMachine = false;
            updateImage();
        }
    }

    private void checkEnd()
    {
        if (getY() > getWorld().getHeight() - 10)
        {
            sell();
            getWorld().removeObject(this);
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
