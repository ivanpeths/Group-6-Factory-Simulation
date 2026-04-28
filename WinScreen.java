import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Win screen
 * 
 * Takes in the parameter of who won and the losing score to display
 * Button to return to SettingsWorld and replay
 * 
 * @author Kolby Ng
 * @version 20260424
 */
public class WinScreen extends World
{
    private Label titleLabel;
    private Label loseLabel;
    private Label restartLabel;
    private int size = 75;
    
    private GreenfootImage buttonImg;
    private Actor buttonActor;
    private Label buttonTitle;
    
    private GreenfootImage background;
    
    public WinScreen(String winner, int loseScore)
    {    
        super(1200, 800, 1); 
        setupLabel(winner, loseScore);
        setupButton();
        setBackground();
        
    }
    
    public void setupLabel(String winner, int loseScore){
        titleLabel = new Label(winner + " wins!", size);
        addObject(titleLabel, getWidth() / 2, getHeight() / 4);
        if (winner.equals("Left")){
            loseLabel = new Label("Right had $" + loseScore + " only!", size);
            addObject(loseLabel, getWidth() / 2, getHeight() / 4 * 2);
        } else {
            loseLabel = new Label("Left had $" + loseScore + " only!", size);
            addObject(loseLabel, getWidth() / 2, getHeight() / 4 * 2);
        }
        
    }
    
    public void setupButton(){
        buttonImg = new GreenfootImage("button.png");
        buttonActor = new BlankActor();
        buttonActor.setImage(buttonImg);
        restartLabel = new Label("Restart", size);
        addObject(buttonActor, getWidth() / 2, getHeight() / 4 * 3);
        addObject(restartLabel, getWidth() / 2, getHeight() / 4 * 3 - 10);
    }
    
    public void setBackground(){
        background = new GreenfootImage ("background.png");
        setBackground (background);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(buttonActor) || Greenfoot.mouseClicked(restartLabel)){
            Greenfoot.setWorld(new SettingsWorld());
        }
    }
}
