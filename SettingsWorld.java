import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Second screen of the game, can tweak the following
 * - Starting scores
 * - Starting positions
 * - Product spawn rate
 * 
 * Click on arrows to adjust value
 * Hold Shift while clicking on arrows to adjust with a larger increment
 * 
 * Makes a sound when the minimum or maximum value is reached
 * 
 * @author Kolby Ng
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
    
    // Left quality
    private Label leftQualityLabel;
    private Actor leftQualityLeft;
    private Label leftQualityAmtLabel;
    private int leftQualityAmt = 6;
    private Actor leftQualityRight;
    
    // Right quality
    private Label rightQualityLabel;
    private Actor rightQualityLeft;
    private Label rightQualityAmtLabel;
    private int rightQualityAmt = 6;
    private Actor rightQualityRight;
    
    // Left spawn rate
    private Label leftRateLabel;
    private Actor leftRateLeft;
    private Label leftRateAmtLabel;
    private int leftRateAmt = 50;
    private Actor leftRateRight;
    
    // Right spawn rate
    private Label rightRateLabel;
    private Actor rightRateLeft;
    private Label rightRateAmtLabel;
    private int rightRateAmt = 50;
    private Actor rightRateRight;
    
    // Label constants
    private int labelSize = 50;
    private int leftScoreY = 100;
    private int rightScoreY = 190;
    private int leftQualityY = 280;
    private int rightQualityY = 370;
    private int leftRateY = 460;
    private int rightRateY = 550;
    private int scoreIncrements = 10;
    private int scoreShiftIncrements = 20;
    private int qualityIncrements = 1;
    private int qualityShiftIncrements = 2;
    private int rateIncrements = 5;
    private int rateShiftIncrements = 10;
    
    // Arrow images
    private GreenfootImage leftImg;
    private GreenfootImage rightImg;
    private int imgSize = 75;
    
    private GreenfootImage background;
    private SoundManager soundMan;
    
    public SettingsWorld(SoundManager soundMan)
    {    
        super(1200, 800, 1); 
        setupButton();
        setupImages();
        setupLeftScore();
        setupRightScore();
        setupLeftQuality();
        setupRightQuality();
        setupLeftRate();
        setupRightRate();
        setBackground();
        
        this.soundMan = soundMan;
        
    }
    
    public void stopped(){
        soundMan.pauseMenu();
    }
    
    public void started(){
        if (!soundMan.menuPlaying()){
            soundMan.playMenu();
        }
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
        } else {
            soundMan.playMenuClick();
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
        } else {
            soundMan.playMenuClick();
        }
    }
    
    public void setupLeftQuality(){
        leftQualityLabel = new Label("Left Starting Quality", labelSize);
        leftQualityAmtLabel = new Label(leftQualityAmt, labelSize);
        leftQualityLeft = new BlankActor();
        leftQualityRight = new BlankActor();
        leftQualityLeft.setImage(leftImg);
        leftQualityRight.setImage(rightImg);
        
        addObject(leftQualityLabel, getWidth() / 4, leftQualityY);
        addObject(leftQualityLeft, getWidth() / 8 * 5, leftQualityY);
        addObject(leftQualityAmtLabel, getWidth() / 8 * 6, leftQualityY);
        addObject(leftQualityRight, getWidth() / 8 * 7, leftQualityY);
        
    }
    
    // Clamp min and max
    public void changeLeftQuality(int amt){
        int oldAmt = leftQualityAmt;
        leftQualityAmt = (Math.max(Math.min(10, leftQualityAmt + amt), 1));
        leftQualityAmtLabel.setValue(leftQualityAmt);
        if (oldAmt == leftQualityAmt){
            soundMan.playError();
        } else {
            soundMan.playMenuClick();
        }
    }
    
    public void setupRightQuality(){
        rightQualityLabel = new Label("Right Starting Quality", labelSize);
        rightQualityAmtLabel = new Label(rightQualityAmt, labelSize);
        rightQualityLeft = new BlankActor();
        rightQualityRight = new BlankActor();
        rightQualityLeft.setImage(leftImg);
        rightQualityRight.setImage(rightImg);
        
        addObject(rightQualityLabel, getWidth() / 4, rightQualityY);
        addObject(rightQualityLeft, getWidth() / 8 * 5, rightQualityY);
        addObject(rightQualityAmtLabel, getWidth() / 8 * 6, rightQualityY);
        addObject(rightQualityRight, getWidth() / 8 * 7, rightQualityY);
        
    }
    
    // Clamp min and max
    public void changeRightQuality(int amt){
        int oldAmt = rightQualityAmt;
        rightQualityAmt = (Math.max(Math.min(10, rightQualityAmt + amt), 1));
        rightQualityAmtLabel.setValue(rightQualityAmt);
        if (oldAmt == rightQualityAmt){
            soundMan.playError();
        } else {
            soundMan.playMenuClick();
        }
    }
    
    public void setupLeftRate(){
        leftRateLabel = new Label("Left Starting Rate", labelSize);
        leftRateAmtLabel = new Label(leftRateAmt, labelSize);
        leftRateLeft = new BlankActor();
        leftRateRight = new BlankActor();
        leftRateLeft.setImage(leftImg);
        leftRateRight.setImage(rightImg);
        
        addObject(leftRateLabel, getWidth() / 4, leftRateY);
        addObject(leftRateLeft, getWidth() / 8 * 5, leftRateY);
        addObject(leftRateAmtLabel, getWidth() / 8 * 6, leftRateY);
        addObject(leftRateRight, getWidth() / 8 * 7, leftRateY);
        
    }
    
    // Clamp min and max
    public void changeLeftRate(int amt){
        int oldAmt = leftRateAmt;
        leftRateAmt = (Math.max(Math.min(100, leftRateAmt + amt), 1));
        leftRateAmtLabel.setValue(leftRateAmt);
        if (oldAmt == leftRateAmt){
            soundMan.playError();
        } else {
            soundMan.playMenuClick();
        }
    }
    
    public void setupRightRate(){
        rightRateLabel = new Label("Right Starting Rate", labelSize);
        rightRateAmtLabel = new Label(rightRateAmt, labelSize);
        rightRateLeft = new BlankActor();
        rightRateRight = new BlankActor();
        rightRateLeft.setImage(leftImg);
        rightRateRight.setImage(rightImg);
        
        addObject(rightRateLabel, getWidth() / 4, rightRateY);
        addObject(rightRateLeft, getWidth() / 8 * 5, rightRateY);
        addObject(rightRateAmtLabel, getWidth() / 8 * 6, rightRateY);
        addObject(rightRateRight, getWidth() / 8 * 7, rightRateY);
        
    }
    
    // Clamp min and max
    public void changeRightRate(int amt){
        int oldAmt = rightRateAmt;
        rightRateAmt = (Math.max(Math.min(100, rightRateAmt + amt), 1));
        rightRateAmtLabel.setValue(rightRateAmt);
        if (oldAmt == rightRateAmt){
            soundMan.playError();
        } else {
            soundMan.playMenuClick();
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
            Greenfoot.setWorld(new FactoryWorld(leftScoreAmt, rightScoreAmt, leftQualityAmt, rightQualityAmt, leftRateAmt, rightRateAmt, soundMan));
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
        
        // Quality increments while holding Shift
        if (Greenfoot.mouseClicked(leftQualityLeft) && Greenfoot.isKeyDown("shift")){
            changeLeftQuality(qualityShiftIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(leftQualityRight) && Greenfoot.isKeyDown("shift")){
            changeLeftQuality(qualityShiftIncrements);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightQualityLeft) && Greenfoot.isKeyDown("shift")){
            changeRightQuality(qualityShiftIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightQualityRight) && Greenfoot.isKeyDown("shift")){
            changeRightQuality(qualityShiftIncrements);
            return;
        }
        
        // Quality increments
        if (Greenfoot.mouseClicked(leftQualityLeft)){
            changeLeftQuality(qualityIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(leftQualityRight)){
            changeLeftQuality(qualityIncrements);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightQualityLeft)){
            changeRightQuality(qualityIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightQualityRight)){
            changeRightQuality(qualityIncrements);
            return;
        }
        
        // Rate increments while holding Shift
        if (Greenfoot.mouseClicked(leftRateLeft) && Greenfoot.isKeyDown("shift")){
            changeLeftRate(rateShiftIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(leftRateRight) && Greenfoot.isKeyDown("shift")){
            changeLeftRate(rateShiftIncrements);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightRateLeft) && Greenfoot.isKeyDown("shift")){
            changeRightRate(rateShiftIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightRateRight) && Greenfoot.isKeyDown("shift")){
            changeRightRate(rateShiftIncrements);
            return;
        }
        
        // Rate increments
        if (Greenfoot.mouseClicked(leftRateLeft)){
            changeLeftRate(rateIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(leftRateRight)){
            changeLeftRate(rateIncrements);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightRateLeft)){
            changeRightRate(rateIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightRateRight)){
            changeRightRate(rateIncrements);
            return;
        }
    }
}

