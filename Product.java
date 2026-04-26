// Product made by Isaac, updated to an abstract superclass by Ivan

import greenfoot.*;

public abstract class Product extends SuperSmoothMover  
{
    protected int owner; // which player it belongs to
    protected double speed = 1.5; // movement speed

    protected int type;
    protected GreenfootImage image;

    protected SimpleTimer spawnTimer = new SimpleTimer();
    protected boolean processed = false;

    public Product(int owner)
    {
        this.owner = owner;
        type = 0; // material
        updateImage();
    }

    public void act()
    {
        moveDown();
        checkMachine();
        checkEnd();
        if (getWorld() == null) {
            return;
        }
        checkLeavingMachine();
    }

    public void updateImage() 
    {
        if (type == 0) image = new GreenfootImage("material.png");
        else if (type == 1) image = new GreenfootImage("finishBox.png");
        else if (type == 2) image = new GreenfootImage("brokenBox.png");
        else if (type == 3) image = new GreenfootImage("expensiveBox.png");
        
        image.scale(50, 50);
        setImage(image);
    }

    public void setType(int newType) 
    {
        type = newType;
        updateImage();
    }

    public void process() 
    {
        int rand = Greenfoot.getRandomNumber(100);

        if (rand < 25) {
            setType(2); // broken
        } 
        else if (rand < 95) {
            setType(1); // finished
        } 
        else {
            setType(3); // expensive
        }
    }

    public void moveDown()
    {
        setLocation(getExactX(), getPreciseY() + speed);
    }

    private void checkMachine()
    {
        Machines m = (Machines)getOneIntersectingObject(Machines.class);
        
        if (m != null && type == 0 && !processed && spawnTimer.millisElapsed() > 300)
        {
            if (!((Assembler)m).getBroken()) {
                process();
                processed = true;
                ((Assembler)m).checkBreak();
            }
            getImage().setTransparency(0);
        }
    }
    
    private void checkLeavingMachine() {
        Machines m = (Machines)getOneIntersectingObject(Machines.class);
        
        if (m == null) {
            getImage().setTransparency(255);
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