import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sound Manager for entire game
 * 
 * Manages creating, playing and pausing of all game sounds
 * 
 * Coins and Error sound effects uses arrays to allow simultatneous playing of the same sound
 * 
 * Credits
 * Left coin: https://pixabay.com/sound-effects/film-special-effects-drop-coin-384921/ but tuned down
 * Right coin: https://pixabay.com/sound-effects/film-special-effects-drop-coin-384921/
 * Error: 
 * Click: https://pixabay.com/sound-effects/film-special-effects-mouse-click-290204/
 * Starting beep: 
 * BGM: 
 * Ambience: 
 * Menu: https://pixabay.com/music/main-title-dramatic-436882/
 * 
 * @author Kolby Ng
 */

public class SoundManager
{
    // Sound variables
    private GreenfootSound startingSound;
    private GreenfootSound bgm;
    private GreenfootSound ambience;
    private GreenfootSound menu;
    
    private GreenfootSound[] leftCoinSounds;
    private GreenfootSound[] rightCoinSounds;
    private GreenfootSound[] errorSounds;
    private GreenfootSound[] clickSounds;
    
    // Indexes
    private int leftCoinIndex = 0;
    private int rightCoinIndex = 0;
    private int errorIndex = 0;
    private int clickIndex = 0;
    
    // Volumes
    private int coinVolume = 100;
    private int bgmVolume = 50;
    private int ambienceVolume = 20;
    private int menuVolume = 50;
    private int clickVolume = 50;
    private int errorVolume = 50;
    
    // Lengths
    private int coinLength = 5;
    private int errorLength = 5;
    private int clickLength = 3;
    
    
    public SoundManager(){
        setFiles();
    }
    
    public void setFiles(){
        startingSound = new GreenfootSound("starting_beep.mp3");
        
        bgm = new GreenfootSound("bgm.mp3");
        bgm.setVolume(bgmVolume);
        
        ambience = new GreenfootSound("ambience.mp3");
        ambience.setVolume(ambienceVolume);
        
        menu = new GreenfootSound("menu.mp3");
        menu.setVolume(menuVolume);

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
        
        errorSounds = new GreenfootSound[errorLength];
        for (int i = 0; i < errorLength; i++){
            errorSounds[i] = new GreenfootSound("error.mp3");
            errorSounds[i].setVolume(errorVolume);
        }

        clickSounds = new GreenfootSound[clickLength];
        for (int i = 0; i < clickLength; i++){
            clickSounds[i] = new GreenfootSound("click.mp3");
            clickSounds[i].setVolume(clickVolume);
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
    
    public void playBgm(){
        bgm.playLoop();
    }
    
    public void pauseBgm(){
        bgm.pause();
    }
    
    public void playError(){
        errorSounds[errorIndex].play();
        errorIndex = (errorIndex + 1) % errorLength;
    }
    
    public void playAmbience(){
        ambience.playLoop();
    }
    
    public void pauseAmbience(){
        ambience.pause();
    }  
    
    public void playMenu(){
        menu.playLoop();
    }
    
    public void pauseMenu(){
        menu.pause();
    }
    
    public boolean menuPlaying(){
        return menu.isPlaying();
    }
    
    public void playClick(){
        clickSounds[clickIndex].play();
        clickIndex = (clickIndex + 1) % clickLength;
    }
}
