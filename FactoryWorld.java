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
    private int barProgress = 180;
    private int barHeight = 40;
    
    // Starting timer and countdown variables;
    private int startingTimer = 180;
    private Label countdownLabel;
    private int countdownSize = 100;
    private Actor overlay; 
    
    /**
     * Factory World constructor. Add parameters if needed
     */
    public FactoryWorld()
    {    
        super(1200, 800, 1); 
        
        setBackground();
        drawLabels(1, 1);
        drawCountdown();
        
    }
    
    public void setBackground(){
        background = new GreenfootImage ("background.png");
        setBackground (background);
    }
    
    public void drawLabels(int leftStarting, int rightStarting){
        leftScoreLabel = new Label("$" + leftStarting + "/$100", labelSize);
        leftScore = leftStarting;
        addObject(leftScoreLabel, getWidth() / 4, labelY);
        
        rightScoreLabel = new Label("$" + rightStarting + "/$100", labelSize);
        rightScore = rightStarting;
        addObject(rightScoreLabel, getWidth() / 4 * 3, labelY);
    }
    
    public void drawCountdown(){
        leftBar = new SuperStatBar(barProgress, 0, null, getWidth() / 2, barHeight, 0, Color.GREEN, Color.GRAY);
        rightBar = new SuperStatBar(barProgress, 0, null, getWidth() / 2, barHeight, 0, Color.GREEN, Color.GRAY);
        rightBar.setRotation(180);
        addObject(leftBar, getWidth() / 4, 0);
        addObject(rightBar, getWidth() / 4 * 3, 0);
        
        GreenfootImage overlayColour = new GreenfootImage(getWidth(), getHeight());
        overlayColour.setColor(new Color(0, 0, 0, 150));
        overlayColour.fill();
        
        overlay = new BlankActor();
        overlay.setImage(overlayColour);
        addObject(overlay, getWidth() / 2, getHeight() / 2);
        
        countdownLabel = new Label(3, countdownSize);
        addObject(countdownLabel, getWidth() / 2, getHeight() / 2);
    }
    
    public void updateLeftScore(){
        leftScoreLabel.setValue(leftScore);
    }
    
    public void updateRightScore(){
        rightScoreLabel.setValue(rightScore);
    }
    
    public void updateCountdown(){
        barProgress--;
        leftBar.update(barProgress);
        rightBar.update(barProgress);
    }
    
    public void removeCountdown(){
        removeObject(leftBar);
        removeObject(rightBar);
        removeObject(countdownLabel);
        removeObject(overlay);
    }

    public void act(){
        if (!started){
            startingTimer--;
            countdownLabel.setValue(startingTimer / 60 + 1);
            if (startingTimer <= 0){
                started = true;
                removeCountdown();
            }
            updateCountdown();
        }
    }
}
