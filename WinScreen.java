import greenfoot.*;

/**
 * Win screen
 * 
 * Takes in the parameter of who won and the losing score to display
 * Button to return to SettingsWorld and replay
 * 
 * @author Kolby Ng
 */
public class WinScreen extends World
{
    private Label titleLabel;
    private Label loseLabel;
    private Label restartLabel;
    private Label buttonTitle;
    private int size = 75;
    private GreenfootImage buttonImg;
    private GreenfootImage background;
    private Button buttonActor;
    private SoundManager soundMan;
    
    public WinScreen(String winner, int loseScore, SoundManager soundMan)
    {    
        super(1200, 800, 1); 
        setupLabel(winner, loseScore);
        setupButton();
        setBackground();
        
        this.soundMan = soundMan;
        
    }
    
    // Start and stop music as needed
    public void started(){
        soundMan.playMenu();
    }
    
    public void stopped(){
        soundMan.pauseMenu();
    }
    
    // Draw winner and loser score, restart button, background
    public void setupLabel(String winner, int loseScore){
        titleLabel = new Label(winner + " wins!", size);
        addObject(titleLabel, getWidth() / 2, getHeight() / 4);
        if (winner.equals("Left")){
            loseLabel = new Label("Right only had $" + loseScore + "!", size);
            addObject(loseLabel, getWidth() / 2, getHeight() / 4 * 2);
        } else {
            loseLabel = new Label("Left only had $" + loseScore + "!", size);
            addObject(loseLabel, getWidth() / 2, getHeight() / 4 * 2);
        }
    }
    
    public void setupButton(){
        buttonImg = new GreenfootImage("button.png");
        buttonActor = new Button(buttonImg);
        restartLabel = new Label("Restart", size);
        addObject(buttonActor, getWidth() / 2, getHeight() / 4 * 3);
        addObject(restartLabel, getWidth() / 2, getHeight() / 4 * 3 - 10);
    }
    
    public void setBackground(){
        background = new GreenfootImage ("background.png");
        setBackground (background);
    }
    
    // Change world back to SetttingsWorld to restart simulation
    public void act(){
        if(Greenfoot.mouseClicked(buttonActor) || Greenfoot.mouseClicked(restartLabel)){
            soundMan.playMenuClick();
            Greenfoot.setWorld(new SettingsWorld(soundMan));
        }
    }
}
