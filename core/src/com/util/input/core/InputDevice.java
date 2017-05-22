package com.util.input.core;

import com.badlogic.gdx.Gdx;


/**
 *
 * @author Jonathan Crockett
 */
public abstract class InputDevice{
    
    protected abstract void activateDevice();
    
    protected final void createEvent(String identifier, int magnitude){
        InputDispatcher.dispatchEvent(new InputEvent(identifier, magnitude, this));
    }
}
