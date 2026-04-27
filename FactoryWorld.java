import greenfoot.*;

public class FactoryWorld extends World  
{
    private GreenfootImage background;
    
    private boolean gameStarted = false;
    
    // Location variables
    private int leftSpawn;
    private int rightSpawn;
    
    private int productSpawn = 50;
    
    // Score variables
    private Label leftScoreLabel;
    private Label rightScoreLabel;
    private int leftScore;
    private int rightScore;
    private int labelY = 35;
    private int labelSize = 50;
    private int winCond = 500;
    
    // Bar variables
    private SuperStatBar leftBar;
    private SuperStatBar rightBar;
    private int barProgress = 180;
    private int barHeight = 30;
    
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
    
    // Product variables
    private int spawnDelay = 120;
    
    //Speed variables
    private double leftSpeed;
    private double rightSpeed;
    
    // Sound Manager
    private SoundManager soundMan = new SoundManager();

    /**
     * Factory World constructor. Add parameters if needed
     */
    public FactoryWorld(int leftStarting, int rightStarting, int leftPos, int rightPos, double leftSpeed, double rightSpeed)
    {    
        super(1200, 800, 1); 
        
        setPaintOrder(Label.class, BlankActor.class, SuperStatBar.class, Assembler.class, Product.class, Conveyor.class);
        setBackground();
        drawConveyor(leftPos, rightPos);
        setXPos(leftPos, rightPos);
        setProdSpeed(leftSpeed, rightSpeed);
        drawUpgrades();
        drawLabels(leftStarting, rightStarting);
        drawMachines(leftPos, rightPos);
        // Countdown above everything
        drawCountdown();
    }
        
    public boolean getStarted(){
        return gameStarted;
    }
    
    public void started(){
        if(!gameStarted){
            soundMan.playStarting();
        } else {
            soundMan.playBgm();
        }
    }
    
    public void stopped(){
        soundMan.pauseStarting();
        soundMan.pauseBgm();
    }
    
    public void setXPos(int leftPos, int rightPos){
        leftSpawn = leftPos;
        rightSpawn = rightPos;
    }
    
    public void setProdSpeed(double leftSpeed, double rightSpeed){
        this.leftSpeed = leftSpeed;
        this.rightSpeed = rightSpeed;
    }
    
    public void drawConveyor (int leftSpawn, int rightSpawn) {
        addObject(new Conveyor(), leftSpawn, getHeight() / 2);
        addObject(new Conveyor(), rightSpawn, getHeight() / 2);
    }
    
    public void drawMachines(int leftSpawn, int rightSpawn){
        leftMach = new Assembler();
        rightMach = new Assembler();
        addObject(leftMach, leftSpawn, getHeight() / 2);
        addObject(rightMach, rightSpawn, getHeight() / 2);
    }
    
    public void drawUpgrades () {
        for (int i = 50; i < 1200; i += 1100) {
            addObject(new Break(i), i, 750);
            addObject(new Buy(i), i, 663);
            addObject(new Quality(i), i, 576);
            addObject(new Repair(i), i, 489);
            addObject(new Spawn(i), i, 402);
        }
    }
    
    public void updateSpawnRate () {
        productSpawn -= 5;
    }
    
    public void setBackground(){
        background = new GreenfootImage ("background.png");
        setBackground (background);
    }
    
    public void drawLabels(int leftStarting, int rightStarting){
        leftScoreLabel = new Label("$" + leftStarting + "/$" + winCond, labelSize);
        leftScore = leftStarting;
        addObject(leftScoreLabel, getWidth() / 32 * 3, labelY);
        
        rightScoreLabel = new Label("$" + rightStarting + "/$" + winCond, labelSize);
        rightScore = rightStarting;
        addObject(rightScoreLabel, getWidth() / 32 * 29, labelY);
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
        leftScoreLabel.setValue("$" + leftScore + "/$" + winCond);
    }
    
    public void updateRightScore(){
        rightScoreLabel.setValue("$" + rightScore + "/$" + winCond);
    }
    
    public void changeLeftScore(int score){
        leftScore = leftScore + score;
        updateLeftScore();
    }
    
    public void changeRightScore(int score){
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
    
    public void checkWin(){
        if (leftScore >= winCond){
            Greenfoot.setWorld(new WinScreen("Left", rightScore));
        }
        else if (rightScore >= winCond){
            Greenfoot.setWorld(new WinScreen("Right", leftScore));
        }
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
                soundMan.playBgm();
            }
            updateCountdown();
            return;
        }

        // Product spawning
        if (Greenfoot.getRandomNumber(productSpawn) == 0 && lastLeft >= spawnDelay){
            addObject(new Cardboard(1, leftSpeed), leftSpawn, 0);
            lastLeft = 0;
        }
        
        if (Greenfoot.getRandomNumber(productSpawn) == 0 && lastRight >= spawnDelay){
            addObject(new Cardboard(2, rightSpeed), rightSpawn, 0);
            lastRight = 0;
        }
        lastLeft++;
        lastRight++;
        
        // Timer tick
        timer++;
        if (timer % 60 == 0){
            updateTimer();
        }
        
        // Check win
        checkWin();
        
    }
}
