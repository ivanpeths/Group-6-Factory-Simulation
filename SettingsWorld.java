import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingsWorld extends World
{
    // Start button
    private GreenfootImage buttonImg;
    private Actor buttonActor;
    private Label buttonTitle;
    
    // Left starting score
    private Label leftScoreLabel;
    private Actor leftScoreLeft;
    private Label leftScoreAmtLabel;
    private int leftScoreAmt = 0;
    private Actor leftScoreRight;

    // Right starting score
    private Label rightScoreLabel;
    private Actor rightScoreLeft;
    private Label rightScoreAmtLabel;
    private int rightScoreAmt = 0;
    private Actor rightScoreRight;
    
    // Label constants
    private int labelSize = 50;
    private int leftScoreY = 100;
    private int rightScoreY = 250;
    private int scoreIncrements = 10;
    private int scoreShiftIncrements = 20;
    
    // Arrow images
    private GreenfootImage leftImg;
    private GreenfootImage rightImg;
    private int imgSize = 75;
    
    private GreenfootImage background;
    public SettingsWorld()
    {    
        super(1200, 800, 1); 
        setupButton();
        setupImages();
        setupLeftScore();
        setupRightScore();
        setBackground();
        
    }
    
    public void setupImages(){
        leftImg = new GreenfootImage("left_arrow.png");
        leftImg.scale(imgSize, imgSize);
        rightImg = new GreenfootImage("right_arrow.png");
        rightImg.scale(imgSize, imgSize);
    }
    
    public void setupLeftScore(){
        leftScoreLabel = new Label("Left Starting Score", labelSize);
        leftScoreAmtLabel = new Label(leftScoreAmt, labelSize);
        leftScoreLeft = new BlankActor();
        leftScoreRight = new BlankActor();
        leftScoreLeft.setImage(leftImg);
        leftScoreRight.setImage(rightImg);
        
        addObject(leftScoreLabel, getWidth() / 4, leftScoreY);
        addObject(leftScoreLeft, getWidth() / 8 * 5, leftScoreY);
        addObject(leftScoreAmtLabel, getWidth() / 8 * 6, leftScoreY);
        addObject(leftScoreRight, getWidth() / 8 * 7, leftScoreY);
        
    }
    
    // No clamping so negative values are allowed
    public void changeLeftScore(int amt){
        leftScoreAmt = leftScoreAmt + amt;
        leftScoreAmtLabel.setValue(leftScoreAmt);
    }
    
    public void setupRightScore(){
        rightScoreLabel = new Label("Right Starting Score", labelSize);
        rightScoreAmtLabel = new Label(rightScoreAmt, labelSize);
        rightScoreLeft = new BlankActor();
        rightScoreRight = new BlankActor();
        rightScoreLeft.setImage(leftImg);
        rightScoreRight.setImage(rightImg);
        
        addObject(rightScoreLabel, getWidth() / 4, rightScoreY);
        addObject(rightScoreLeft, getWidth() / 8 * 5, rightScoreY);
        addObject(rightScoreAmtLabel, getWidth() / 8 * 6, rightScoreY);
        addObject(rightScoreRight, getWidth() / 8 * 7, rightScoreY);
    }
    
    // No clamping so negative values are allowed
    public void changeRightScore(int amt){
        rightScoreAmt = rightScoreAmt + amt;
        rightScoreAmtLabel.setValue(rightScoreAmt);
    }
    
    public void setupButton(){
        buttonImg = new GreenfootImage("button.png");
        buttonActor = new BlankActor();
        buttonActor.setImage(buttonImg);
        buttonTitle = new Label("Start", 75);
        addObject(buttonActor, getWidth() / 2, getHeight() / 4 * 3);
        addObject(buttonTitle, getWidth() / 2, getHeight() / 4 * 3 - 10);
    }
    
    public void setBackground(){
        background = new GreenfootImage ("background.png");
        setBackground (background);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(buttonActor) || Greenfoot.mouseClicked(buttonTitle)){
            Greenfoot.setWorld(new FactoryWorld(leftScoreAmt, rightScoreAmt));
        }
        
        // Score increments
        if (Greenfoot.mouseClicked(leftScoreLeft)){
            changeLeftScore(scoreIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(leftScoreRight)){
            changeLeftScore(scoreIncrements);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightScoreLeft)){
            changeRightScore(scoreIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightScoreRight)){
            changeRightScore(scoreIncrements);
            return;
        }
        
        // Score increments while holding Shift
        if (Greenfoot.mouseClicked(leftScoreLeft) && Greenfoot.isKeyDown("shift")){
            changeLeftScore(scoreShiftIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(leftScoreRight) && Greenfoot.isKeyDown("shift")){
            changeLeftScore(scoreShiftIncrements);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightScoreLeft) && Greenfoot.isKeyDown("shift")){
            changeRightScore(scoreShiftIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightScoreRight) && Greenfoot.isKeyDown("shift")){
            changeRightScore(scoreShiftIncrements);
            return;
        }
    }
}
