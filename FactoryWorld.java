import greenfoot.*;

/**
 * Main game world
 * 
 * Features
 * - Countdown with overlay and bars
 * - Score management
 * - Timer management
 * - Product spawning
 * 
 * @author Kolby Ng
 */

public class FactoryWorld extends World  
{
    private GreenfootImage background;
    
    private boolean gameStarted = false;
    
    // Location variables
    private int leftSpawn;
    private int rightSpawn;
    
    private int rightProductSpawn = 50;
    private int leftProductSpawn = 50;
    
    private int rightProductQuality = 6;
    private int leftProductQuality = 6;
    
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
    
    // Product variables
    private int spawnDelay = 120;
    
    // Left variables
    private Machines leftMach;
    private int lastLeft = spawnDelay;

    // Right variables
    private Machines rightMach;
    private int lastRight = spawnDelay;
    
    // Game timer
    private int timer = 0;
    private Label timerLabel;
    
    // Speed variables
    private double leftSpeed;
    private double rightSpeed;
    
    // Upgrade variables
    private int leftUpgradeX = 50;
    private Break leftBreak;
    private Buy leftBuy;
    private Quality leftQuality;
    private Repair leftRepair;
    private Spawn leftSpawnUpgrade;
    
    private int rightUpgradeX = 50;
    private Break rightBreak;
    private Buy rightBuy;
    private Quality rightQuality;
    private Repair rightRepair;
    private Spawn rightSpawnUpgrade;

    private SoundManager soundMan;
    public FactoryWorld(int leftStarting, int rightStarting, int leftPos, int rightPos, double leftSpeed, double rightSpeed, SoundManager soundMan)
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
        drawCountdown();
        
        this.soundMan = soundMan;
    }
        
    public boolean getStarted(){
        return gameStarted;
    }
    
    public void started(){
        if(!gameStarted){
            soundMan.playStarting();
        } else {
            soundMan.playBgm();
            soundMan.playAmbience();
        }
    }
    
    public void stopped(){
        soundMan.pauseStarting();
        soundMan.pauseBgm();
        soundMan.pauseAmbience();
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
        leftBreak = new Break(leftUpgradeX);
        leftBuy = new Buy(leftUpgradeX);
        leftQuality = new Quality(leftUpgradeX);
        leftRepair = new Repair(leftUpgradeX);
        leftSpawnUpgrade = new Spawn(leftUpgradeX);
        
        addObject(leftBreak, leftUpgradeX, 750);
        addObject(leftBuy, leftUpgradeX, 663);
        addObject(leftQuality, leftUpgradeX, 576);
        addObject(leftRepair, leftUpgradeX, 489);
        addObject(leftSpawnUpgrade, leftUpgradeX, 402);
        
        rightBreak = new Break(rightUpgradeX);
        rightBuy = new Buy(rightUpgradeX);
        rightQuality = new Quality(rightUpgradeX);
        rightRepair = new Repair(rightUpgradeX);
        rightSpawnUpgrade = new Spawn(rightUpgradeX);
        
        addObject(rightBreak, rightUpgradeX, 750);
        addObject(rightBuy, rightUpgradeX, 663);
        addObject(rightQuality, rightUpgradeX, 576);
        addObject(rightRepair, rightUpgradeX, 489);
        addObject(rightSpawnUpgrade, rightUpgradeX, 402);
    }
    
    public void updateRightSpawn () {
        rightProductSpawn -= 5;
    }
    
    public void updateLeftSpawn () {
        leftProductSpawn -= 5;
    }
    
    public void updateLeftQuality () {
        leftProductQuality--;
    }
    
    public void updateRightQuality () {
        rightProductQuality--;
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
            Greenfoot.setWorld(new WinScreen("Left", rightScore, soundMan));
        }
        else if (rightScore >= winCond){
            Greenfoot.setWorld(new WinScreen("Right", leftScore, soundMan));
        }
    }
    
    public void canUpgrade(){
        if (leftScore > 250){
            if (leftMach.getBroken()){
                leftRepair.activate();
            }
        }
        
        if (rightScore > 250){
            if (rightMach.getBroken()){
                rightRepair.activate();
            }
        }
    }
    
    public Machines getLeftMachine(){
        return leftMach;
    }
    
    public Machines getRightMachine(){
        return rightMach;
    }
    
    public void act(){
        if (!gameStarted){
            startingTimer--;
            countdownLabel.setValue(startingTimer / 60 + 1);
            if (startingTimer <= 0){
                gameStarted = true;
                removeCountdown();
                drawTimer();
                soundMan.playBgm();
                soundMan.playAmbience();
            }
            updateCountdown();
            return;
        }

        if (lastLeft >= spawnDelay) {
            if (Greenfoot.getRandomNumber(leftProductSpawn) == 0) {
                
                int rand = Greenfoot.getRandomNumber(leftProductQuality); // 0 or 1
                
                if (rand == 0) {
                    addObject(new Metal(1, leftSpeed), leftSpawn, 0);
                } else if (rand == 1 || rand == 2) {
                    addObject(new Wood(1, leftSpeed), leftSpawn, 0);
                } else {
                    addObject(new Cardboard(1, leftSpeed), leftSpawn, 0);
                }
                
                lastLeft = 0;
            }
        }

        if (lastRight >= spawnDelay) {
            if (Greenfoot.getRandomNumber(rightProductSpawn) == 0) {
                
                int rand = Greenfoot.getRandomNumber(rightProductQuality);
                
                if (rand == 0) {
                    addObject(new Metal(2, rightSpeed), rightSpawn, 0);
                } else if (rand == 1 || rand == 2) {
                    addObject(new Wood(2, rightSpeed), rightSpawn, 0);
                } else {
                    addObject(new Cardboard(2, rightSpeed), rightSpawn, 0);
                }
                
                lastRight = 0;
            }
        }

        lastLeft++;
        lastRight++;
        
        timer++;
        if (timer % 60 == 0){
            updateTimer();
        }
        canUpgrade();
        checkWin();
    }
}
