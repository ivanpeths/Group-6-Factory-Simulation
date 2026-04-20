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
    
    private boolean started = false;
    
    // Score variables
    private Label leftScoreLabel;
    private Label rightScoreLabel;
    private int leftScore;
    private int rightScore;
    private int labelY = 75;
    private int labelSize = 50;
    
    // Bar variables
    private SuperStatBar leftBar;
    private SuperStatBar rightBar;
    private int leftBarProgress = 180;
    private int rightBarProgress = 0;
    private int barHeight = 40;
    
    // Starting timer variables;
    private int startingTimer = 180;
    
    /**
     * Factory World constructor. Add parameters if needed
     */
    public FactoryWorld()
    {    
        super(1200, 800, 1); 
        
        setBackground();
        drawLabels(1, 1);
        drawBars();
        
    }
    
    public void setBackground(){
        background = new GreenfootImage ("background.png");
        setBackground (background);
    }
    
    public void drawLabels(int leftStarting, int rightStarting){
        leftScoreLabel = new Label("$" + leftStarting + "/$100", labelSize);
        leftScore = leftStarting;
        addObject(leftScoreLabel, getWidth() / 4, labelY);
        
        rightScoreLabel = new Label("$" + leftStarting + "/$100", labelSize);
        rightScore = rightStarting;
        addObject(rightScoreLabel, getWidth() / 4 * 3, labelY);
    }
    
    public void drawBars(){
        leftBar = new SuperStatBar(leftBarProgress, 0, null, getWidth() / 2, barHeight, 0, Color.GREEN, Color.GRAY);
        rightBar = new SuperStatBar(rightBarProgress, 180, null, getWidth() / 2, barHeight, 0, Color.GREEN, Color.GRAY);
        addObject(leftBar, getWidth() / 4, 0);
        addObject(rightBar, getWidth() / 4 * 3, 0);
    }
    
    public void updateBars(){
        leftBarProgress--;
        rightBarProgress--;
        leftBar.update(leftBarProgress);
        rightBar.update(rightBarProgress);
    }
    
    public void act(){
        if (!started){
            startingTimer--;
            if (startingTimer <= 0){
                started = true;
                removeObject(leftBar);
                removeObject(rightBar);
            }
            updateBars();
        }
    }
}
