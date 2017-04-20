package com.assets.scripts;

import com.badlogic.gdx.Gdx;
import com.util.input.Script;

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
