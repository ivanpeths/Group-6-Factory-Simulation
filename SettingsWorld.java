import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Second screen of the game, can tweak the following
 * - Starting scores
<<<<<<< Updated upstream
 * - Starting positions
 * - Product speed
=======
 * - Starting quality
 * - Product spawn rate
>>>>>>> Stashed changes
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
    
    // Left speed
    private Label leftSpeedLabel;
    private Actor leftSpeedLeft;
    private Label leftSpeedAmtLabel;
    private double leftSpeedAmt = 1.5;
    private Actor leftSpeedRight;
    
    // Right speed
    private Label rightSpeedLabel;
    private Actor rightSpeedLeft;
    private Label rightSpeedAmtLabel;
    private double rightSpeedAmt = 1.5;
    private Actor rightSpeedRight;
    
    // Label constants
    private int labelSize = 50;
    private int leftScoreY = 100;
    private int rightScoreY = 190;
<<<<<<< Updated upstream
    private int leftPosY = 280;
    private int rightPosY = 370;
    private int leftSpeedY = 460;
    private int rightSpeedY = 550;
=======
    private int leftQualityY = 280;
    private int rightQualityY = 370;
    private int leftRateY = 460;
    private int rightRateY = 550;
>>>>>>> Stashed changes
    private int scoreIncrements = 10;
    private int scoreShiftIncrements = 20;
    private int posIncrements = 10;
    private int posShiftIncrements = 20;
    private double speedIncrements = 0.5;
    private double speedShiftIncrements = 1.0;
    
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
        setupLeftPos();
        setupRightPos();
        setupLeftSpeed();
        setupRightSpeed();
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
    
<<<<<<< Updated upstream
    public void setupLeftPos(){
        leftPosLabel = new Label("Left Starting Position", labelSize);
        leftPosAmtLabel = new Label(leftPosAmt, labelSize);
        leftPosLeft = new BlankActor();
        leftPosRight = new BlankActor();
        leftPosLeft.setImage(leftImg);
        leftPosRight.setImage(rightImg);
=======
    public void setupLeftQuality(){
        leftQualityLabel = new Label("Left Starting Quality", labelSize);
        leftQualityAmtLabel = new Label(leftQualityAmt, labelSize);
        leftQualityLeft = new BlankActor();
        leftQualityRight = new BlankActor();
        leftQualityLeft.setImage(leftImg);
        leftQualityRight.setImage(rightImg);
>>>>>>> Stashed changes
        
        addObject(leftPosLabel, getWidth() / 4, leftPosY);
        addObject(leftPosLeft, getWidth() / 8 * 5, leftPosY);
        addObject(leftPosAmtLabel, getWidth() / 8 * 6, leftPosY);
        addObject(leftPosRight, getWidth() / 8 * 7, leftPosY);
        
    }
    
    // Clamp min and max
    public void changeLeftPos(int amt){
        int oldAmt = leftPosAmt;
        leftPosAmt = (Math.max(Math.min(530, leftPosAmt + amt), 170));
        leftPosAmtLabel.setValue(leftPosAmt);
        if (oldAmt == leftPosAmt){
            soundMan.playError();
        }
    }
    
<<<<<<< Updated upstream
    public void setupRightPos(){
        rightPosLabel = new Label("Right Starting Position", labelSize);
        rightPosAmtLabel = new Label(rightPosAmt, labelSize);
        rightPosLeft = new BlankActor();
        rightPosRight = new BlankActor();
        rightPosLeft.setImage(leftImg);
        rightPosRight.setImage(rightImg);
=======
    public void setupRightQuality(){
        rightQualityLabel = new Label("Right Starting Quality", labelSize);
        rightQualityAmtLabel = new Label(rightQualityAmt, labelSize);
        rightQualityLeft = new BlankActor();
        rightQualityRight = new BlankActor();
        rightQualityLeft.setImage(leftImg);
        rightQualityRight.setImage(rightImg);
>>>>>>> Stashed changes
        
        addObject(rightPosLabel, getWidth() / 4, rightPosY);
        addObject(rightPosLeft, getWidth() / 8 * 5, rightPosY);
        addObject(rightPosAmtLabel, getWidth() / 8 * 6, rightPosY);
        addObject(rightPosRight, getWidth() / 8 * 7, rightPosY);
        
    }
    
    // Clamp min and max
    public void changeRightPos(int amt){
        int oldAmt = rightPosAmt;
        rightPosAmt = (Math.max(Math.min(1040, rightPosAmt + amt), 680));
        rightPosAmtLabel.setValue(rightPosAmt);
        if (oldAmt == rightPosAmt){
            soundMan.playError();
        }
    }
    
        public void setupLeftSpeed(){
        leftSpeedLabel = new Label("Left Starting Speed", labelSize);
        leftSpeedAmtLabel = new Label(Double.toString(leftSpeedAmt), labelSize);
        leftSpeedLeft = new BlankActor();
        leftSpeedRight = new BlankActor();
        leftSpeedLeft.setImage(leftImg);
        leftSpeedRight.setImage(rightImg);
        
        addObject(leftSpeedLabel, getWidth() / 4, leftSpeedY);
        addObject(leftSpeedLeft, getWidth() / 8 * 5, leftSpeedY);
        addObject(leftSpeedAmtLabel, getWidth() / 8 * 6, leftSpeedY);
        addObject(leftSpeedRight, getWidth() / 8 * 7, leftSpeedY);
        
    }
    
    // Clamp min and max
    public void changeLeftSpeed(double amt){
        double oldAmt = leftSpeedAmt;
        leftSpeedAmt = (Math.max(Math.min(5, leftSpeedAmt + amt), 0.5));
        leftSpeedAmtLabel.setValue(Double.toString(leftSpeedAmt));
        if (oldAmt == leftSpeedAmt){
            soundMan.playError();
        }
    }
    
    public void setupRightSpeed(){
        rightSpeedLabel = new Label("Right Starting Speed", labelSize);
        rightSpeedAmtLabel = new Label(Double.toString(rightSpeedAmt), labelSize);
        rightSpeedLeft = new BlankActor();
        rightSpeedRight = new BlankActor();
        rightSpeedLeft.setImage(leftImg);
        rightSpeedRight.setImage(rightImg);
        
        addObject(rightSpeedLabel, getWidth() / 4, rightSpeedY);
        addObject(rightSpeedLeft, getWidth() / 8 * 5, rightSpeedY);
        addObject(rightSpeedAmtLabel, getWidth() / 8 * 6, rightSpeedY);
        addObject(rightSpeedRight, getWidth() / 8 * 7, rightSpeedY);
        
    }
    
    // Clamp min and max
    public void changeRightSpeed(double amt){
        double oldAmt = rightSpeedAmt;
        rightSpeedAmt = (Math.max(Math.min(5, rightSpeedAmt + amt), 0.5));
        rightSpeedAmtLabel.setValue(Double.toString(rightSpeedAmt));
        if (oldAmt == rightSpeedAmt){
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
            Greenfoot.setWorld(new FactoryWorld(leftScoreAmt, rightScoreAmt, leftPosAmt, rightPosAmt, leftSpeedAmt, rightSpeedAmt, soundMan));
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
        
        // Speed increments while holding Shift
        if (Greenfoot.mouseClicked(leftSpeedLeft) && Greenfoot.isKeyDown("shift")){
            changeLeftSpeed(speedShiftIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(leftSpeedRight) && Greenfoot.isKeyDown("shift")){
            changeLeftSpeed(speedShiftIncrements);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightSpeedLeft) && Greenfoot.isKeyDown("shift")){
            changeRightSpeed(speedShiftIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightSpeedRight) && Greenfoot.isKeyDown("shift")){
            changeRightSpeed(speedShiftIncrements);
            return;
        }
        
        // Speed increments
        if (Greenfoot.mouseClicked(leftSpeedLeft)){
            changeLeftSpeed(speedIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(leftSpeedRight)){
            changeLeftSpeed(speedIncrements);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightSpeedLeft)){
            changeRightSpeed(speedIncrements * -1);
            return;
        }
        
        if (Greenfoot.mouseClicked(rightSpeedRight)){
            changeRightSpeed(speedIncrements);
            return;
        }
    }
}
