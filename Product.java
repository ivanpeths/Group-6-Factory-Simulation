import greenfoot.*;

public class Product extends SuperSmoothMover  
{
    protected int owner; // which player it belongs to
    protected double speed = 1.5; // movement speed

    private int type;

    public Product(int owner)
    {
        this.owner = owner;
        type = 0;
        updateImage();
    }

    public void act()
    {
        moveDown();
    }

    public void updateImage() {
        if (type == 0) setImage("matrial.png");
        else if (type == 1) setImage("finishedBox.png");
        else if (type == 2) setImage("brokenBox.png");
        else if (type == 3) setImage("expensiveBox.png");
    }

    public void setType(int newType) {
        type = newType;
        updateImage();
    }

    public void process(Product p) {
        int rand = Greenfoot.getRandomNumber(100);

        if (rand < 20) {
            p.setType(2); // broken
        } 
        else if (rand < 80) {
            p.setType(1); // finished
        } 
        else {
            p.setType(3); // expensive
        }
    }

    public void moveDown()
    {
        setLocation(getExactX(), getPreciseY() + speed);
    }

    public int getOwner()
    {
        return owner;
    }

    public int getType()
    {
        return type;
    }
}
