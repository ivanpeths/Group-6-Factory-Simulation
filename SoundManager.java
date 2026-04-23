import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SoundManager extends Actor
{
    GreenfootSound startingSound;
    GreenfootSound leftCoinSound;
    GreenfootSound rightCoinSound;
    
    public SoundManager(){
        startingSound = new GreenfootSound("starting_beep.mp3");
        leftCoinSound = new GreenfootSound("left_coin.mp3");
        rightCoinSound = new GreenfootSound("right_coin.mp3");
    }
    
    public void started(){
        FactoryWorld w = (FactoryWorld) getWorld();
        if (!w.getStarted()){
            startingSound.play();
        }
    }
    
    public void stopped(){
        startingSound.pause();
    }
}
