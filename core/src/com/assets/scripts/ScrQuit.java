package com.assets.scripts;

import com.badlogic.gdx.Gdx;
import com.util.script.Script;
import com.util.script.ScriptReturn;

/**
 *
 * @author Jonathan Crockett
 */
public class ScrQuit extends Script{
    
    @Override
    public ScriptReturn scriptMain(){
        Gdx.app.exit();
        return null;
    }

    @Override
    public String toString() {
        return "Quit";
    }
}
