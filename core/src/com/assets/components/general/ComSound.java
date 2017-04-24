package com.assets.components.general;

import com.badlogic.ashley.core.Component;
import com.global.AudioManager;
import java.util.HashMap;

/**
 *
 * @author Jonathan Crockett
 */
public class ComSound implements Component {
    
    private HashMap<String, String> sounds = new HashMap<String, String>();
    
    public void addSound(String name, String audioHandle){
        sounds.put(name, audioHandle);
    }
    
    public String removeSound(String name) {
        return sounds.remove(name);
    }
    
    public boolean play(String name){
        return AudioManager.playSound(sounds.get(name));
    }
    
    public boolean loop(String name){
        return AudioManager.playSoundLoop(sounds.get(name));
    }
    
    public boolean pause(String name){
        return AudioManager.pauseSound(sounds.get(name));
    }
    
    public boolean resume(String name){
        return AudioManager.resumeSound(sounds.get(name));
    }
    
    public boolean stop(String name){
        return AudioManager.stopSound(sounds.get(name));
    }
}
