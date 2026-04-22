import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main game world
 * 
 * @author Kolby Ng
 * @version 0.1
 */
public class FactoryWorld extends World
{
    private GreenfootImage background;
    
    private boolean gameStarted = false;
    
    private static int LEFT_MIDDLE = 300;
    private static int RIGHT_MIDDLE = 900;
    
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
    
    // Starting timer and countdown variables
    private int startingTimer = 180;
    private Label countdownLabel;
    private int countdownSize = 100;
    private Actor overlay; 
    
    // Starting beep
    private GreenfootSound startingSound;

    // Left variables
    private Machines leftMach;

    // Right variables
    private Machines rightMach;

    
    /**
     * Factory World constructor. Add parameters if needed
     */
    public FactoryWorld()
    {    
        super(1200, 800, 1); 
        
        setBackground();
        drawLabels(0, 0);
        drawMachines();

        // Countdown above everything
        drawCountdown();
        playStartingBeep();
    }
    
    public void playStartingBeep(){
        startingSound = new GreenfootSound("starting_beep.mp3");
        startingSound.play();
    }
    
    public void started(){
        if (!gameStarted){
            startingSound.play();
        }
    }
    
    public void drawMachines(){
        leftMach = new Machines();
        rightMach = new Machines();
        addObject(leftMach, getWidth() / 8, getHeight() / 2);
        addObject(rightMach, getWidth() / 8 * 7, getHeight() / 2);
    }

    public void stopped(){
        startingSound.pause();

    }
    
    public void setBackground(){
        background = new GreenfootImage ("background.png");
        setBackground (background);
    }
    
    public void drawLabels(int leftStarting, int rightStarting){
        leftScoreLabel = new Label("" + leftStarting + "/$100", labelSize);
        leftScore = leftStarting;
        addObject(leftScoreLabel, getWidth() / 4, labelY);
        
        rightScoreLabel = new Label("" + rightStarting + "/$100", labelSize);
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
        if (!gameStarted){
            startingTimer--;
            countdownLabel.setValue(startingTimer / 60 + 1);
            if (startingTimer <= 0){
                gameStarted = true;
                removeCountdown();
                startingScenario();
            }
            updateCountdown();
        }
    }
    
    public void startingScenario () {
        addObject (new Assembler(), LEFT_MIDDLE, 300);
        addObject (new Assembler(), RIGHT_MIDDLE, 300);
    }
}
