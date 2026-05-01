import greenfoot.*;

/**
 * Second screen of the game, can tweak the following
 * - Starting scores
 * - Spawn rate of more expensive items, the larger the value the more common it is
 * - Product spawn rate, the larger the value the faster products spawn
 * 
 * Click on arrows to adjust value
 * Hold Shift while clicking on arrows to adjust with a larger increment
 * 
 * Makes error sound when the minimum or maximum value is reached
 * 
 * @author Kolby Ng
 */
public class SettingsWorld extends World
{
    // Start button
    private GreenfootImage buttonImg;
    private Button buttonActor;
    private Label buttonTitle;
    
    // Left starting score
    private Label leftScoreLabel;
    private Button leftScoreLeft;
    private Label leftScoreAmtLabel;
    private int leftScoreAmt = 0;
    private Button leftScoreRight;

    // Right starting score
    private Label rightScoreLabel;
    private Button rightScoreLeft;
    private Label rightScoreAmtLabel;
    private int rightScoreAmt = 0;
    private Button rightScoreRight;
    
    // Left quality
    private Label leftQualityLabel;
    private Button leftQualityLeft;
    private Label leftQualityAmtLabel;
    private int leftQualityAmt = 6;
    private Button leftQualityRight;
    
    // Right quality
    private Label rightQualityLabel;
    private Button rightQualityLeft;
    private Label rightQualityAmtLabel;
    private int rightQualityAmt = 6;
    private Button rightQualityRight;
    
    // Left spawn rate
    private Label leftRateLabel;
    private Button leftRateLeft;
    private Label leftRateAmtLabel;
    private int leftRateAmt = 50;
    private Button leftRateRight;
    
    // Right spawn rate
    private Label rightRateLabel;
    private Button rightRateLeft;
    private Label rightRateAmtLabel;
    private int rightRateAmt = 50;
    private Button rightRateRight;
    
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
    
    // Pause menu music when game is stopped
    public void stopped(){
        soundMan.pauseMenu();
    }
    
    // Play menu music when game starts
    public void started(){
        soundMan.playMenu();
    }
    
    // Set left and right arrow images
    public void setupImages(){
        leftImg = new GreenfootImage("left_arrow.png");
        leftImg.scale(imgSize, imgSize);
        rightImg = new GreenfootImage("right_arrow.png");
        rightImg.scale(imgSize, imgSize);
    }
    
    // Draw left score buttons
    public void setupLeftScore(){
        leftScoreLabel = new Label("Left Starting Score", labelSize);
        leftScoreAmtLabel = new Label(leftScoreAmt, labelSize);
        leftScoreLeft = new Button(leftImg);
        leftScoreRight = new Button(rightImg);
        
        addObject(leftScoreLabel, getWidth() / 4, leftScoreY);
        addObject(leftScoreLeft, getWidth() / 8 * 5, leftScoreY);
        addObject(leftScoreAmtLabel, getWidth() / 8 * 6, leftScoreY);
        addObject(leftScoreRight, getWidth() / 8 * 7, leftScoreY);
        
    }
    
    public void changeLeftScore(int amt){
        int oldAmt = leftScoreAmt;
        // Clamp min and max
        leftScoreAmt = (Math.max(Math.min(1000, leftScoreAmt + amt), 0));
        leftScoreAmtLabel.setValue(leftScoreAmt);
        // If new value is same as old one i.e. clamped
        if (oldAmt == leftScoreAmt){
            soundMan.playError();
        } else {
            soundMan.playMenuClick();
        }
    }
    
    // Draw right score buttons
    public void setupRightScore(){
        rightScoreLabel = new Label("Right Starting Score", labelSize);
        rightScoreAmtLabel = new Label(rightScoreAmt, labelSize);
        rightScoreLeft = new Button(leftImg);
        rightScoreRight = new Button(rightImg);
        
        addObject(rightScoreLabel, getWidth() / 4, rightScoreY);
        addObject(rightScoreLeft, getWidth() / 8 * 5, rightScoreY);
        addObject(rightScoreAmtLabel, getWidth() / 8 * 6, rightScoreY);
        addObject(rightScoreRight, getWidth() / 8 * 7, rightScoreY);
    }
    
    public void changeRightScore(int amt){
        int oldAmt = rightScoreAmt;
        // Clamp min and max
        rightScoreAmt = (Math.max(Math.min(1000, rightScoreAmt + amt), 0));
        rightScoreAmtLabel.setValue(rightScoreAmt);
        // If new value is same as old one i.e. clamped
        if (oldAmt == rightScoreAmt){
            soundMan.playError();
        } else {
            soundMan.playMenuClick();
        }
    }
    
    // Draw left quality buttons
    public void setupLeftQuality(){
        leftQualityLabel = new Label("Left Starting Quality", labelSize);
        leftQualityAmtLabel = new Label(leftQualityAmt, labelSize);
        leftQualityLeft = new Button(leftImg);
        leftQualityRight = new Button(rightImg);
        
        addObject(leftQualityLabel, getWidth() / 4, leftQualityY);
        addObject(leftQualityLeft, getWidth() / 8 * 5, leftQualityY);
        addObject(leftQualityAmtLabel, getWidth() / 8 * 6, leftQualityY);
        addObject(leftQualityRight, getWidth() / 8 * 7, leftQualityY);
        
    }
    
    public void changeLeftQuality(int amt){
        int oldAmt = leftQualityAmt;
        // Clamp min and max
        leftQualityAmt = (Math.max(Math.min(10, leftQualityAmt + amt), 1));
        leftQualityAmtLabel.setValue(leftQualityAmt);
        // If new value is same as old one i.e. clamped
        if (oldAmt == leftQualityAmt){
            soundMan.playError();
        } else {
            soundMan.playMenuClick();
        }
    }
    
    // Draw right quality buttons
    public void setupRightQuality(){
        rightQualityLabel = new Label("Right Starting Quality", labelSize);
        rightQualityAmtLabel = new Label(rightQualityAmt, labelSize);
        rightQualityLeft = new Button(leftImg);
        rightQualityRight = new Button(rightImg);
        
        addObject(rightQualityLabel, getWidth() / 4, rightQualityY);
        addObject(rightQualityLeft, getWidth() / 8 * 5, rightQualityY);
        addObject(rightQualityAmtLabel, getWidth() / 8 * 6, rightQualityY);
        addObject(rightQualityRight, getWidth() / 8 * 7, rightQualityY);
    }
    
    public void changeRightQuality(int amt){
        int oldAmt = rightQualityAmt;
        // Clamp min and max
        rightQualityAmt = (Math.max(Math.min(10, rightQualityAmt + amt), 1));
        rightQualityAmtLabel.setValue(rightQualityAmt);
        // If new value is same as old one i.e. clamped
        if (oldAmt == rightQualityAmt){
            soundMan.playError();
        } else {
            soundMan.playMenuClick();
        }
    }
    
    // Draw left product spawn rate buttons
    public void setupLeftRate(){
        leftRateLabel = new Label("Left Starting Rate", labelSize);
        leftRateAmtLabel = new Label(leftRateAmt, labelSize);
        leftRateLeft = new Button(leftImg);
        leftRateRight = new Button(rightImg);
        
        addObject(leftRateLabel, getWidth() / 4, leftRateY);
        addObject(leftRateLeft, getWidth() / 8 * 5, leftRateY);
        addObject(leftRateAmtLabel, getWidth() / 8 * 6, leftRateY);
        addObject(leftRateRight, getWidth() / 8 * 7, leftRateY);
        
    }

    public void changeLeftRate(int amt){
        int oldAmt = leftRateAmt;
        // Clamp min and max
        leftRateAmt = (Math.max(Math.min(100, leftRateAmt + amt), 1));
        // Since clamped value is 1, if you add 5 or 10 it'll become 6 and 11, decrease by 1
        if (oldAmt == 1 && amt > 0){
            leftRateAmt--;
        }
        leftRateAmtLabel.setValue(leftRateAmt);
        if (oldAmt == leftRateAmt){
            soundMan.playError();
        } else {
            soundMan.playMenuClick();
        }
    }
    
    // Right product spawn rate buttons
    public void setupRightRate(){
        rightRateLabel = new Label("Right Starting Rate", labelSize);
        rightRateAmtLabel = new Label(rightRateAmt, labelSize);
        rightRateLeft = new Button(leftImg);
        rightRateRight = new Button(rightImg);
        
        addObject(rightRateLabel, getWidth() / 4, rightRateY);
        addObject(rightRateLeft, getWidth() / 8 * 5, rightRateY);
        addObject(rightRateAmtLabel, getWidth() / 8 * 6, rightRateY);
        addObject(rightRateRight, getWidth() / 8 * 7, rightRateY);
        
    }
    
    public void changeRightRate(int amt){
        int oldAmt = rightRateAmt;
        // Clamp min and max
        rightRateAmt = (Math.max(Math.min(100, rightRateAmt + amt), 1));
        // Since clamped value is 1, if you add 5 or 10 it'll become 6 and 11, decrease by 1
        if (oldAmt == 1 && amt > 0){
            rightRateAmt--;
        }
        rightRateAmtLabel.setValue(rightRateAmt);
        if (oldAmt == rightRateAmt){
            soundMan.playError();
        } else {
            soundMan.playMenuClick();
        }
    }
    
    // Draw Start button
    public void setupButton(){
        buttonImg = new GreenfootImage("button.png");
        buttonActor = new Button(buttonImg);
        buttonTitle = new Label("Start", 75);
        addObject(buttonActor, getWidth() / 2, getHeight() / 8 * 7);
        addObject(buttonTitle, getWidth() / 2, getHeight() / 8 * 7 - 10);
    }
    
    public void setBackground(){
        background = new GreenfootImage ("background.png");
        setBackground (background);
    }
    
    // Check for button clicks every act
    public void act(){
        // Pass arguments to FactoryWorld
        if(Greenfoot.mouseClicked(buttonActor) || Greenfoot.mouseClicked(buttonTitle)){
            soundMan.playMenuClick();
            Greenfoot.setWorld(new FactoryWorld(leftScoreAmt, rightScoreAmt, 11 - leftQualityAmt, 11 - rightQualityAmt, 101 - leftRateAmt, 101 - rightRateAmt, soundMan));
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
