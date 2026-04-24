import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingsWorld extends World
{
    
    private GreenfootImage buttonImg;
    private Actor buttonActor;
    private Label buttonTitle;
    public SettingsWorld()
    {    
        super(1200, 800, 1); 
        setupButton();
        
    }
    
    public void setupButton(){
        buttonImg = new GreenfootImage("button.png");
        buttonActor = new BlankActor();
        buttonActor.setImage(buttonImg);
        buttonTitle = new Label("Start", 75);
        addObject(buttonActor, getWidth() / 2, getHeight() / 8 * 7);
        addObject(buttonTitle, getWidth() / 2, getHeight() / 8 * 7 - 10);
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(buttonActor) || Greenfoot.mouseClicked(buttonTitle)){
            Greenfoot.setWorld(new FactoryWorld());
        }
    }
}
