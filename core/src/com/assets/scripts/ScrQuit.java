package com.assets.scripts;

import com.badlogic.gdx.Gdx;
import com.assets.util.script.Script;

/**
 *
 * @author Jonathan Crockett
 */
public class ScrQuit extends Script{
    
    @Override
    public void scriptMain(){
        Gdx.app.exit();
    }

    @Override
    public String toString() {
        return "Quit";
    }
}
