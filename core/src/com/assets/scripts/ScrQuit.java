package com.assets.scripts;

import com.badlogic.gdx.Gdx;
import com.util.script.Argument;
import com.util.script.Script;
import com.util.script.Return;

/**
 *
 * @author Jonathan Crockett
 */
public class ScrQuit extends Script{
    
    @Override
    public Return scriptMain(Argument args){
        Gdx.app.exit();
        return null;
    }

    @Override
    public String toString() {
        return "Quit";
    }
}
