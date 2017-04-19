package com.base.assets.scripts;

import com.badlogic.gdx.Gdx;
import com.base.assets.util.script.Script;

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
