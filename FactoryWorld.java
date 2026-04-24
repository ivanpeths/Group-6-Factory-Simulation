import greenfoot.*;

public class FactoryWorld extends World  
{
    private GreenfootImage background;
    
    private boolean gameStarted = false;
    
    //location variables
    private int leftSpawn = 400;
    private int rightSpawn = 800;
    
    // Score variables
    private Label leftScoreLabel;
    private Label rightScoreLabel;
    private int leftScore;
    private int rightScore;
    private int labelY = 30;
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
    private int lastLeft = 120;

    // Right variables
    private Machines rightMach;
    private int lastRight = 120;
    
    // Game timer
    private int timer = 0;
    private Label timerLabel;

    private int spawnDelay = 120;
    
    // Sound Manager
    private SoundManager soundMan = new SoundManager();

    /**
     * Factory World constructor. Add parameters if needed
     */
    public FactoryWorld()
    {    
        super(1200, 800, 1); 
        
        setBackground();
        drawConveyor();
        drawLabels(0, 0);
        drawMachines();
        // Countdown above everything
        drawCountdown();
    }
        
    public boolean getStarted(){
        return gameStarted;
    }
    
    public void started(){
        if(!gameStarted){
            soundMan.playStarting();
        }
    }
    
    public void stopped(){
        soundMan.pauseStarting();
    }
    
    public void drawConveyor () {
        addObject(new Conveyor(), leftSpawn, getHeight() / 2);
        addObject(new Conveyor(), rightSpawn, getHeight() / 2);
    }
    
    public void drawMachines(){
        if (Greenfoot.getRandomNumber(5) == 0) {
            leftMach = new BrokenAssembler();
            rightMach = new BrokenAssembler();
        }
        leftMach = new Assembler();
        rightMach = new Assembler();
        addObject(leftMach, leftSpawn, getHeight() / 2);
        addObject(rightMach, rightSpawn, getHeight() / 2);
    }
    
    public void setBackground(){
        background = new GreenfootImage ("background.png");
        setBackground (background);
    }
    
    public void drawLabels(int leftStarting, int rightStarting){
        leftScoreLabel = new Label("$" + leftStarting + "/$1000", labelSize);
        leftScore = leftStarting;
        addObject(leftScoreLabel, getWidth() / 32 * 2, labelY);
        
        rightScoreLabel = new Label("$" + rightStarting + "/$1000", labelSize);
        rightScore = rightStarting;
        addObject(rightScoreLabel, getWidth() / 32 * 30, labelY);
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
        leftScoreLabel.setValue("$" + leftScore + "/$1000");
    }
    
    public void updateRightScore(){
        rightScoreLabel.setValue("$" + rightScore + "/$1000");
    }
    
    public void addLeftScore(int score){
        leftScore = leftScore + score;
        updateLeftScore();
    }
    
    public void addRightScore(int score){
        rightScore = rightScore + score;
        updateRightScore();
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
    
    public void updateTimer(){
        timerLabel.setValue(timer / 60 + "s");
    }
    
    public void drawTimer(){
        timerLabel = new Label("0s", labelSize);
        addObject(timerLabel, getWidth() / 2, labelY);
    }
    
    public void act(){
        // Countdown logic
        if (!gameStarted){
            startingTimer--;
            countdownLabel.setValue(startingTimer / 60 + 1);
            if (startingTimer <= 0){
                gameStarted = true;
                removeCountdown();
                drawTimer();
            }
            updateCountdown();
            return;
        }

        // Product spawning
        if (Greenfoot.getRandomNumber(60) == 0 && lastLeft >= spawnDelay){
            addObject(new Product(1), leftSpawn, 0);
            lastLeft = 0;
        }
        
        if (Greenfoot.getRandomNumber(60) == 0 && lastRight >= spawnDelay){
            addObject(new Product(2), rightSpawn, 0);
            lastRight = 0;
        }
        lastLeft++;
        lastRight++;
        
        // Timer tick
        timer++;
        if (timer % 60 == 0){
            updateTimer();
        }
        
    }
}
