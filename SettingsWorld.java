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
    
    // Left position
    private Label leftPosLabel;
    private Actor leftPosLeft;
    private Label leftPosAmtLabel;
    private int leftPosAmt = 400;
    private Actor leftPosRight;
    
    // Right position
    private Label rightPosLabel;
    private Actor rightPosLeft;
    private Label rightPosAmtLabel;
    private int rightPosAmt = 800;
    private Actor rightPosRight;
    
    // Label constants
    private int labelSize = 50;
    private int leftScoreY = 100;
    private int rightScoreY = 190;
    private int leftPosY = 280;
    private int rightPosY = 370;
    private int scoreIncrements = 10;
    private int scoreShiftIncrements = 20;
    private int posIncrements = 10;
    private int posShiftIncrements = 20;
    
    // Arrow images
    private GreenfootImage leftImg;
    private GreenfootImage rightImg;
    private int imgSize = 75;
    
    private GreenfootImage background;
    private SoundManager soundMan = new SoundManager();
    
    public SettingsWorld()
    {    
        super(1200, 800, 1); 
        setupButton();
        setupImages();
        setupLeftScore();
        setupRightScore();
        setupLeftPos();
        setupRightPos();
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
    
    // Clamp max
    public void changeLeftScore(int amt){
        int oldAmt = leftScoreAmt;
        leftScoreAmt = Math.min(500, leftScoreAmt + amt);
        leftScoreAmtLabel.setValue(leftScoreAmt);
        if (oldAmt == leftScoreAmt){
            soundMan.playError();
        }
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
    
    // Clamp max
    public void changeRightScore(int amt){
        int oldAmt = rightScoreAmt;
        rightScoreAmt = Math.min(500, rightScoreAmt + amt);
        rightScoreAmtLabel.setValue(rightScoreAmt);
        if (oldAmt == rightScoreAmt){
            soundMan.playError();
        }
    }
    
    public void setupLeftPos(){
        leftPosLabel = new Label("Left Starting Position", labelSize);
        leftPosAmtLabel = new Label(leftPosAmt, labelSize);
        leftPosLeft = new BlankActor();
        leftPosRight = new BlankActor();
        leftPosLeft.setImage(leftImg);
        leftPosRight.setImage(rightImg);
        
        addObject(leftPosLabel, getWidth() / 4, leftPosY);
        addObject(leftPosLeft, getWidth() / 8 * 5, leftPosY);
        addObject(leftPosAmtLabel, getWidth() / 8 * 6, leftPosY);
        addObject(leftPosRight, getWidth() / 8 * 7, leftPosY);
        
    }
    
    // Clamp max
    public void changeLeftPos(int amt){
        int oldAmt = leftPosAmt;
        leftPosAmt = (Math.max(Math.min(530, leftPosAmt + amt), 170));
        leftPosAmtLabel.setValue(leftPosAmt);
        if (oldAmt == leftPosAmt){
            soundMan.playError();
        }
    }
    
    public void setupRightPos(){
        rightPosLabel = new Label("Right Starting Position", labelSize);
        rightPosAmtLabel = new Label(rightPosAmt, labelSize);
        rightPosLeft = new BlankActor();
        rightPosRight = new BlankActor();
        rightPosLeft.setImage(leftImg);
        rightPosRight.setImage(rightImg);
        
        addObject(rightPosLabel, getWidth() / 4, rightPosY);
        addObject(rightPosLeft, getWidth() / 8 * 5, rightPosY);
        addObject(rightPosAmtLabel, getWidth() / 8 * 6, rightPosY);
        addObject(rightPosRight, getWidth() / 8 * 7, rightPosY);
        
    }
    
    // Clamp max
    public void changeRightPos(int amt){
        int oldAmt = rightPosAmt;
        rightPosAmt = (Math.max(Math.min(1040, rightPosAmt + amt), 680));
        rightPosAmtLabel.setValue(rightPosAmt);
        if (oldAmt == rightPosAmt){
            soundMan.playError();
        }
    }
    
    public void setupButton(){
        buttonImg = new GreenfootImage("button.png");
        buttonActor = new BlankActor();
        buttonActor.setImage(buttonImg);
        buttonTitle = new Label("Start", 75);
        addObject(buttonActor, getWidth() / 2, getHeight() / 8 * 7);
        addObject(buttonTitle, getWidth() / 2, getHeight() / 8 * 7 - 10);
    }
    
    public void setBackground(){
        background = new GreenfootImage ("background.png");
        setBackground (background);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(buttonActor) || Greenfoot.mouseClicked(buttonTitle)){
            Greenfoot.setWorld(new FactoryWorld(leftScoreAmt, rightScoreAmt, leftPosAmt, rightPosAmt));
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
        
        // Position increments while holding Shift
        if (Greenfoot.mouseClicked(leftPosLeft) && Greenfoot.isKeyDown("shift")){
            changeLeftPos(posShiftIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(leftPosRight) && Greenfoot.isKeyDown("shift")){
            changeLeftPos(posShiftIncrements);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightPosLeft) && Greenfoot.isKeyDown("shift")){
            changeRightPos(posShiftIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightPosRight) && Greenfoot.isKeyDown("shift")){
            changeRightPos(posShiftIncrements);
            return;
        }
        
        // Position increments
        if (Greenfoot.mouseClicked(leftPosLeft)){
            changeLeftPos(posIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(leftPosRight)){
            changeLeftPos(posIncrements);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightPosLeft)){
            changeRightPos(posIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightPosRight)){
            changeRightPos(posIncrements);
            return;
        }
    }
}
