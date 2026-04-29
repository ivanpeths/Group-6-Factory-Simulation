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
 * Error: https://pixabay.com/sound-effects/film-special-effects-ui-error-pop-515668/
 * Click: https://pixabay.com/sound-effects/film-special-effects-mouse-click-290204/
 * Starting beep: https://pixabay.com/sound-effects/film-special-effects-race-start-beeps-125125/ but tuned down and edited
 * BGM: https://pixabay.com/music/electronic-fast-dynamic-rhythmic-music-499175/
 * Ambience: https://pixabay.com/sound-effects/technology-steam-engine-loop-43171/
 * Menu: https://pixabay.com/music/main-title-dramatic-436882/
 * Settings click: https://pixabay.com/sound-effects/film-special-effects-mouse-click-290204/ but tuned down
 * Break: https://pixabay.com/sound-effects/film-special-effects-powerful-cannon-254542/
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
    private GreenfootSound[] menuClickSounds;
    private GreenfootSound[] breakSounds;
    
    // Indexes
    private int leftCoinIndex = 0;
    private int rightCoinIndex = 0;
    private int errorIndex = 0;
    private int clickIndex = 0;
    private int menuClickIndex = 0;
    private int breakIndex = 0;
    
    // Volumes
    private int startingSoundVolume = 30;
    private int coinVolume = 30;
    // private int bgmVolume = 50;
    private int ambienceVolume = 20;
    private int menuVolume = 40;
    private int clickVolume = 50;
    private int errorVolume = 40;
    private int menuClickVolume = 30;
    private int breakVolume = 30;
    
    // Lengths
    private int coinLength = 5;
    private int errorLength = 5;
    private int clickLength = 3;
    private int menuClickLength = 3;
    private int breakLength = 2;
    
    
    public SoundManager(){
        setFiles();
    }
    
    public void setFiles(){
        startingSound = new GreenfootSound("starting_beep.mp3");
        startingSound.setVolume(startingSoundVolume);
        
        // bgm = new GreenfootSound("bgm.mp3");
        // bgm.setVolume(bgmVolume);
        
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
        
        menuClickSounds = new GreenfootSound[menuClickLength];
        for (int i = 0; i < menuClickLength; i++){
            menuClickSounds[i] = new GreenfootSound("menu_click.mp3");
            menuClickSounds[i].setVolume(menuClickVolume);
        }
        
        breakSounds = new GreenfootSound[clickLength];
        for (int i = 0; i < breakLength; i++){
            breakSounds[i] = new GreenfootSound("break.mp3");
            breakSounds[i].setVolume(breakVolume);
        }
    }
    
    // Coins
    public void playLeftCoin(){
        leftCoinSounds[leftCoinIndex].play();
        leftCoinIndex = (leftCoinIndex + 1) % coinLength;
    }
    
    public void playRightCoin(){
        rightCoinSounds[rightCoinIndex].play();
        rightCoinIndex = (rightCoinIndex + 1) % coinLength;
    }
    
    // Starting beep
    public void playStarting(){
        startingSound.play();
    }
    
    public void pauseStarting(){
        startingSound.pause();
    }
    
    /*
    // BGM
    public void playBgm(){
        bgm.playLoop();
    }
    
    public void pauseBgm(){
        bgm.pause();
    }
    */
    
    // Error
    public void playError(){
        errorSounds[errorIndex].play();
        errorIndex = (errorIndex + 1) % errorLength;
    }
    
    // Ambience
    public void playAmbience(){
        ambience.playLoop();
    }
    
    public void pauseAmbience(){
        ambience.pause();
    }  
    
    // Menu music
    public void playMenu(){
        menu.playLoop();
    }
    
    public void pauseMenu(){
        menu.pause();
    }
    
    public void stopMenu(){
        menu.stop();
    }
    
    public boolean menuPlaying(){
        return menu.isPlaying();
    }
    
    // Pointer click
    public void playClick(){
        clickSounds[clickIndex].play();
        clickIndex = (clickIndex + 1) % clickLength;
    }
    
    // Settings click
    public void playMenuClick(){
        menuClickSounds[menuClickIndex].play();
        menuClickIndex = (menuClickIndex + 1) % menuClickLength;
    }
    
    // Break machine
    public void playBreak(){
        breakSounds[breakIndex].play();
        breakIndex = (breakIndex + 1) % breakLength;
    }
}
