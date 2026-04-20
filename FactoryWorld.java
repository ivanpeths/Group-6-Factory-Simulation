import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FactoryWorld extends World
{
    private GreenfootImage background;
    
    // Score variables
    private Label leftScoreLabel;
    private Label rightScoreLabel;
    private int leftScore;
    private int rightScore;
    private int labelY = 75;
    private int labelSize = 50;
    /**
     * Factory World constructor. Add parameters if needed
     */
    public FactoryWorld()
    {    
        super(1200, 800, 1); 
        
        setBackground();
        drawLabels(1, 1);
        
    }
    
    public void setBackground(){
        background = new GreenfootImage ("background.png");
        setBackground (background);
    }
    
    public void drawLabels(int leftStarting, int rightStarting){
        leftScoreLabel = new Label("$" + leftStarting + "/$100", labelSize);
        leftScore = leftStarting;
        addObject(leftScoreLabel, getWidth() / 8 * 2, labelY);
        
        rightScoreLabel = new Label("$" + leftStarting + "/$100", labelSize);
        rightScore = rightStarting;
        addObject(rightScoreLabel, getWidth() / 8 * 6, labelY);
    }
}
