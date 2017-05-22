package com.util.input.devices;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.PovDirection;
import com.util.input.core.InputDevice;

/**
 *
 * @author Jonathan Crockett
 */
public class InputDeviceKeyboard extends InputDevice implements InputProcessor {

    
    @Override
    public boolean keyDown(int i) {
        createEvent("key press", i);
        return true;
    }

    @Override
    public boolean keyUp(int i) {
        createEvent("key release", i);
        return true;
    }

    @Override
    public boolean keyTyped(char c) {
        createEvent(String.valueOf(c), 1);        
        return true;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }

    @Override
    protected void activateDevice() {
        Gdx.input.setInputProcessor(this);
    }

}
