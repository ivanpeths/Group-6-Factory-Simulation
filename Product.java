import greenfoot.*;

public abstract class Product extends SuperSmoothMover  
{
    protected int owner; // which player it belongs to
    protected double speed; // movement speed

    protected int type;
    protected GreenfootImage image;
    protected int transparency;
    
    protected boolean inMachine;

    public Product(int owner, double speed)
    {
        this.owner = owner;
        type = 0; // material
        this.speed = speed;
        updateImage();
        inMachine = false;
        transparency = 255;
    }

    public void act()
    {
        moveDown();
        checkMachine();
        // checkLeavingMachine();
        checkEnd();
        if (getWorld() == null) {
            return;
        }
    }

    public abstract void updateImage() 
    {
        if (type == 0) image = new GreenfootImage("broken_cardboard.png");
        else if (type == 1) image = new GreenfootImage("material_cardboard.png");
        else if (type == 2) image = new GreenfootImage("finish_cardboard.png");
        else image = new GreenfootImage("expensive_cardboard.png");
        
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
        
        if (m instanceof Assembler && !((Assembler)m).getBroken() && !inMachine) {
            inMachine = true;
            transparency = 0;
            updateImage();
        }
    }
    
    /*
    private void checkLeavingMachine() {
        Machines m = (Machines)getOneIntersectingObject(Machines.class);
        
        if (m == null && inMachine) {
            int random = Greenfoot.getRandomNumber(100);
            if (random < 25) {
                type = 0; // broken
            }
            else if (random < 95) {
                type = 2; // finished
            }
            else {
                type = 3; // expensive
            }
            transparency = 255;
            inMachine = false;
            updateImage();
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
    */

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
