package com.global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.BiConsumer;

/**
 *
 * @author Jonathan Crockett
 */
public class AudioManager {
    public static final String MUSIC_ROOT = "audio\\music\\";
    public static final String SOUND_ROOT = "audio\\sound\\";
    
    private static HashMap<String, Music> musicMap = new HashMap<String, Music>();
    private static HashMap<String, Sound> soundMap = new HashMap<String, Sound>();
    
    private static Music loadedMusic = null;
    private static float loopPosition = 0;
    private static boolean isLooping = false;
    
    private static float musicVolume = 1;
    private static float soundVolume = 1;
    private static float masterVolume = 1;
    
    public static boolean addMusic(String name, String path){
        try{
            Music msc = Gdx.audio.newMusic(Gdx.files.internal(MUSIC_ROOT + path));
            msc.setOnCompletionListener(new LoopingPosition());
            msc.setVolume(getActualMusicVolume());
            musicMap.put(name, msc);
        }
        catch(GdxRuntimeException e){
            System.out.println("AudioManager: Unable to load music file " + path);
            return false;
        }
        
        return true;
    }
    
    public static boolean addSound(String name, String path){
        try{
            Sound snd = Gdx.audio.newSound(Gdx.files.internal(SOUND_ROOT + path));
            soundMap.put(name, snd);
        }
        catch(GdxRuntimeException e){
            System.out.println("AudioManager: Unable to load sound file " + path);
            return false;
        }
        
        return true;
    }
    
    public static boolean disposeMusic(String name){
        if(musicMap.containsKey(name)){
            if(musicMap.get(name) == loadedMusic)
                loadedMusic = null;
            musicMap.get(name).stop();
            musicMap.remove(name).dispose();
            return true;
        }
        
        System.out.println("AudioManager: Cannot dispose; Music entry by the name of " + name + " could not be found.");
        return false;
    }
    
    public static boolean disposeSound(String name){
        if(soundMap.containsKey(name)){
            soundMap.get(name).stop();
            soundMap.remove(name).dispose();
            return true;
        }
        return false;
    }
    
    public static void clear(){
        Iterator<Music> itrM = musicMap.values().iterator();
        while(itrM.hasNext()){
            Music msc = itrM.next();
            msc.stop();
            msc.dispose();
        }
        
        Iterator<Sound> itrS = soundMap.values().iterator();
        while(itrS.hasNext()){
            Sound snd = itrS.next();
            snd.stop();
            snd.dispose();
        }
        
        musicMap.clear();
        loadedMusic = null;
    }
    
    public static boolean playMusic(){
        if(loadedMusic != null){
            loadedMusic.play();
            return true;
        }
        System.out.println("AudioManager: Cannot play; no music is currently loaded.");
        return false;
    }
    
    public static boolean playMusic(String name){
        if(musicMap.containsKey(name)) {
            if(musicMap.get(name) != loadedMusic && loadedMusic != null){
                loadedMusic.stop();
                loadedMusic = musicMap.get(name);
            }
            musicMap.get(name).play();
            return true;
        }
        System.out.println("AudioManager: Cannot play; music entry by the name of " + name + " could not be found.");
        return false;
    }
    
    public static boolean pauseMusic(){
        if(loadedMusic.isPlaying()){
            loadedMusic.pause();
            return true;
        }
        System.out.println("AudioManager: Cannot pause; no music is currently loaded.");
        return false;
    }
    
    public static boolean stopMusic(){
        if(loadedMusic != null){
            loadedMusic.stop();
            return true;
        }
        System.out.println("AudioManager: Cannot stop; no music is currently loaded.");
        return false;
    }
    
    public static boolean isMusicPlaying(String name){
        return musicMap.containsKey(name) ? musicMap.get(name).isPlaying() : false;
    }
    
    public static boolean isLoadedMusicPlaying() {
        return loadedMusic == null ? false : loadedMusic.isPlaying();
    }
    
    public static boolean isMusicLoaded() {
        return loadedMusic != null;
    }
    
    public static void setupMusicLoop(float position, boolean shouldLoop){
        loopPosition = position;
        isLooping = shouldLoop;
    }
    
    public static boolean playSound(String name){
        if(soundMap.containsKey(name)){
            soundMap.get(name).play(getActualSoundVolume());
            return true;
        }
        System.out.println("AudioManager: Cannot play: sound entry by the name of " + name + " could not be found.");
        return false;
    }
    
    public static boolean playSoundLoop(String name){
        if(soundMap.containsKey(name)){
            soundMap.get(name).loop(getActualSoundVolume());
            return true;
        }
        System.out.println("AudioManager: Cannot play loop: sound entry by the name of " + name + " could not be found.");
        return false;
    }
    
    public static boolean pauseSound(String name){
        if(soundMap.containsKey(name)){
            soundMap.get(name).pause();
            return true;
        }
        System.out.println("AudioManager: Cannot pause: sound entry by the name of " + name + " could not be found.");
        return false;
    }
    
    public static boolean resumeSound(String name){
        if(soundMap.containsKey(name)){
            soundMap.get(name).resume();
            return true;
        }
        System.out.println("AudioManager: Cannot resume: sound entry by the name of " + name + " could not be found.");
        return false;
    }
    
    public static boolean stopSound(String name){
        if(soundMap.containsKey(name)){
            soundMap.get(name).stop();
            return true;
        }
        System.out.println("AudioManager: Cannot stop: sound entry by the name of " + name + " could not be found.");
        return false;
    }
    
    public static float getMusicVolume(){
        return musicVolume;
    }
    
    public static void setMusicVolume(float vol){
        if(vol > 1)
            vol = 1;
        else if(vol < 0)
            vol = 0;
        musicVolume = vol;
        musicMap.forEach(new setVolumes());
    }
    
    public static float getActualMusicVolume(){
        return musicVolume * masterVolume;
    }
    
    public static float getSoundVolume(){
        return soundVolume;
    }
    
    public static void setSoundVolume(float vol){
        if(vol > 1)
            vol = 1;
        else if(vol < 0)
            vol = 0;
        soundVolume = vol;
    }
    
    public static float getActualSoundVolume(){
        return soundVolume * masterVolume;
    }
    
    public static float getMasterVolume(){
        return masterVolume;
    }
    
    public static void setMasterVolume(float vol){
        if(vol > 1)
            vol = 1;
        else if(vol < 0)
            vol = 0;
        masterVolume = vol;
        musicMap.forEach(new setVolumes());
    }
    
    private static class LoopingPosition implements Music.OnCompletionListener {

        @Override
        public void onCompletion(Music music) {
            if(isLooping){
                music.setPosition(loopPosition);
            }
        }
    }
    
    private static class setVolumes implements BiConsumer<String, Music> {

        @Override
        public void accept(String t, Music u) {
            u.setVolume(getActualMusicVolume());
        }
        
    }
}



