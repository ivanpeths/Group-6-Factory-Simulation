import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title screen
 * 
 * @author Kolby Ng
 * @version 20260424
 */
public class TitleScreen extends World
{
    private Label titleLabel;
    private Label startLabel;
    private GreenfootImage buttonImg;
    private Actor buttonActor;
    private Label buttonTitle;
    private GreenfootImage background;
    
    public TitleScreen()
    {    
        super(1200, 800, 1); 
        setupLabel();
        setupButton();
        setBackground();
        
    }
    
    public void setupLabel(){
        titleLabel = new Label("Factory Simulation", 75);
        addObject(titleLabel, getWidth() / 2, getHeight() / 4);
    }
    
    public void setupButton(){
        buttonImg = new GreenfootImage("button.png");
        buttonActor = new BlankActor();
        buttonActor.setImage(buttonImg);
        startLabel = new Label("Start", 75);
        addObject(buttonActor, getWidth() / 2, getHeight() / 4 * 3);
        addObject(startLabel, getWidth() / 2, getHeight() / 4 * 3 - 10);
    }
    
    public void setBackground(){
        background = new GreenfootImage ("background.png");
        setBackground(background);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(buttonActor) || Greenfoot.mouseClicked(startLabel)){
            Greenfoot.setWorld(new SettingsWorld());
        }
    }
}
