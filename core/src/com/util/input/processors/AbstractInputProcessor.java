package com.util.input.processors;

import com.badlogic.gdx.InputProcessor;

/**
 *
 * @author Jonathan Crockett
 */
public abstract class AbstractInputProcessor implements InputProcessor {

    public boolean keyDown(int i) {
        return false;
    }
    
    public boolean keyUp(int i) {
        return false;
    }
    
    public boolean keyTyped(char c) {
        return false;
    }
    
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }
    
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }
    
    /**
     *
     * @param i
     * @param i1
     * @param i2
     * @return
     */
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }
    
    public boolean mouseMoved(int i, int i1) {
        return false;
    }
    
    public boolean scrolled(int i) {
        return false;
    }
}
