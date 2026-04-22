import greenfoot.*;

public class Product extends SuperSmoothMover  
{
    private GreenfootImage background;
    
    private boolean gameStarted = false;
    
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

    private int type;
    GreenfootImage img;

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
        if (type == 0) img = new GreenfootImage("material.png");
        else if (type == 1) img = new GreenfootImage("finishedBox.png");
        else if (type == 2) img = new GreenfootImage("brokenBox.png");
        else if (type == 3) img = new GreenfootImage("expensiveBox.png");
        
        img.scale(50, 50);
        setImage(img);
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
        addObject (new Assembler(), getWidth() / 4, getHeight() / 2);
        addObject (new Assembler(), getWidth() / 4 * 3, getHeight() / 2);
    }
}
