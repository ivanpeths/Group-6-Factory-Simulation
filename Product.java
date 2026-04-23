import greenfoot.*;

public class Product extends SuperSmoothMover  
{
    protected int owner; // which player it belongs to
    protected double speed = 1.5; // movement speed

    private int type;
    GreenfootImage img;

    public Product(int owner)
    {
        this.owner = owner;
        type = 0;
        updateImage();
    }

    public void act()
    {
        moveDown();
        checkMachineZone();
        checkMachine();
        checkEnd();
    }

    public void updateImage() {
        if (type == 0) img = new GreenfootImage("material.png");
        else if (type == 1) img = new GreenfootImage("finishBox.png");
        else if (type == 2) img = new GreenfootImage("brokenBox.png");
        else if (type == 3) img = new GreenfootImage("expensiveBox.png");
        
        img.scale(50, 50);
        setImage(img);
    }

    public void setType(int newType) 
    {
        type = newType;
        updateImage();
    }

    public void process(Product p) 
    {
        int rand = Greenfoot.getRandomNumber(100);

        if (rand < 20) {
            setType(2); // broken
        } 
        else if (rand < 80) {
            setType(1); // finished
        } 
        else {
            setType(3); // expensive
        }
    }

    public void moveDown()
    {
        setLocation(getExactX(), getPreciseY() + speed); // getExactX(), getPreciseY()
    }

    private void checkMachine()
    {
        Machines m = (Machines)getOneIntersectingObject(Machines.class);
        
        if (m != null && type == 0)
        {
            process(this);
        }
    }

    private void checkEnd()
    {
        if (getY() > getWorld().getHeight() - 10)
        {
            giveMoney();
            getWorld().removeObject(this);
        }
    }

    private void giveMoney()
    {
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

    private void checkMachineZone()
    {
        if (getPreciseY() > 00 && type == 0)
        {
            process();
        }
    }

    public int getOwner()
    {
        return owner;
    }
    
    public void process() //temporary process method to allow compiling
    {
        
    }

    public int getType()
    {
        return type;
    }
}
