import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SoundManager
{
    private GreenfootSound startingSound;
    private GreenfootSound[] leftCoinSounds;
    private GreenfootSound[] rightCoinSounds;
    private int leftCoinIndex = 0;
    private int rightCoinIndex = 0;
    
    private int coinLength = 10;
    private int coinVolume = 100;
    
    public SoundManager(){
        setFiles();
    }
    
    public void setFiles(){
        startingSound = new GreenfootSound("starting_beep.mp3");
        leftCoinSounds = new GreenfootSound[coinLength];
        for (int i = 0; i < coinLength; i++){
            leftCoinSounds[i] = new GreenfootSound("left_coin.mp3");
            leftCoinSounds[i].setVolume(coinVolume);
        }
        rightCoinSounds = new GreenfootSound[coinLength];
        for (int i = 0; i < coinLength; i++){
            rightCoinSounds[i] = new GreenfootSound("right_coin.mp3");
            rightCoinSounds[i].setVolume(coinVolume);
        }
    }
    
    public void playLeftCoin(){
        leftCoinSounds[leftCoinIndex].play();
        leftCoinIndex = (leftCoinIndex + 1) % coinLength;
    }
    
    public void playRightCoin(){
        rightCoinSounds[rightCoinIndex].play();
        rightCoinIndex = (rightCoinIndex + 1) % coinLength;
    }
    
    public void playStarting(){
        startingSound.play();
    }
    
    public void pauseStarting(){
        startingSound.pause();
    }
}
