import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title screen
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    private Label title;
    private GreenfootImage buttonImg;
    private Actor buttonActor;
    private Label buttonTitle;
    public TitleScreen()
    {    
        super(1200, 800, 1); 
        setupLabel();
        setupButton();
        
    }
    
    public void setupLabel(){
        title = new Label("Factory Simulation", 75);
        addObject(title, getWidth() / 2, getHeight() / 4);
    }
    
    public void setupButton(){
        buttonImg = new GreenfootImage("button.png");
        buttonActor = new BlankActor();
        buttonActor.setImage(buttonImg);
        title = new Label("Start", 75);
        addObject(buttonActor, getWidth() / 2, getHeight() / 4 * 3);
        addObject(title, getWidth() / 2, getHeight() / 4 * 3 - 10);
    }
    
    public void act(){
        
    }
}
