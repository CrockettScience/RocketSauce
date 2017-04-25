package com.assets.scripts;

import com.global.AudioManager;
import com.util.script.Script;
import com.util.script.ScriptReturn;

/**
 *
 * @author Jonathan Crockett
 */
public class ScrVolume extends Script {
    private VolumeType vType;
    private float vLevel;

    public ScrVolume(VolumeType type, float level) {
        vType = type;
        vLevel = level;
    }
    
    @Override
    protected ScriptReturn scriptMain() {
        switch(vType) {
            case SOUND:
                AudioManager.setSoundVolume(AudioManager.getSoundVolume() + vLevel);
                break;
                
            case MUSIC:
                AudioManager.setMusicVolume(AudioManager.getMusicVolume() + vLevel);
                break;
                
            case MASTER:
                AudioManager.setMasterVolume(AudioManager.getMasterVolume() + vLevel);
                break;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Set " + vType + " Volume";
    }
    
    public enum VolumeType {
        MUSIC, SOUND, MASTER
    }
}
