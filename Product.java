import greenfoot.*;

public abstract class Product extends SuperSmoothMover  
{
    protected int owner; // which player it belongs to
    protected double speed = 1.5; // movement speed

    protected int type;
    protected GreenfootImage image;
    protected int transparency;
    
    protected boolean inMachine;

    protected SimpleTimer spawnTimer = new SimpleTimer();

    public Product(int owner)
    {
        this.owner = owner;
        type = 1; // material
        updateImage();
        inMachine = false;
        transparency = 255;
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
        updateImage();
    }

    public void updateImage() 
    {
        if (type == 0) image = new GreenfootImage("broken_cardboard.png");
        else if (type == 1) image = new GreenfootImage("material_cardboard.png");
        else if (type == 2) image = new GreenfootImage("finish_cardboard.png");
        else if (type >= 3) image = new GreenfootImage("expensive_cardboard.png");
        
        image.scale(50, 50);
        setImage(image);
        getImage().setTransparency(transparency);
    }

    public void moveDown()
    {
        setLocation(getExactX(), getPreciseY() + speed);
    }

    private void checkMachine()
    {
        Machines m = (Machines)getOneIntersectingObject(Machines.class);
        
        if (m != null) {
            if (!((Assembler)m).getBroken() && type != 0) {
                inMachine = true;
                transparency = 0;
            }
        }
    }
    
    private void checkLeavingMachine() {
        Machines m = (Machines)getOneIntersectingObject(Machines.class);
        
        if (m == null && inMachine == true) {
            type++;
            if (Greenfoot.getRandomNumber(10) == 0) {
                type = 0;
            }
            transparency = 255;
            inMachine = false;
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