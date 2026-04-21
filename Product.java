public class Product extends SuperSmoothMover  
{
    protected int owner;     // which player it belongs to
    protected double speed = 1.5; // movement speed

    public Product(int owner)
    {
        this.owner = owner;
    }

    public void act()
    {
        moveDown();
    }

    public void moveDown()
    {
        setLocation(getExactX(), getExactY() + speed);
    }

    public int getOwner()
    {
        return owner;
    }
}
