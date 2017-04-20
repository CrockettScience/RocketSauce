package com.util.input;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author Jonathan Crockett
 */
public abstract class AbstractControllerListener implements ControllerListener{

    
    public void connected(Controller pad) {}
    
    /**
     *
     * @param pad
     */
    public void disconnected(Controller pad) {}
    
    public boolean xSliderMoved(Controller pad, int i, boolean bln) {
        return false;
    }
    
    public boolean ySliderMoved(Controller pad, int i, boolean bln) {
        return false;
    }
    
    public boolean accelerometerMoved(Controller pad, int i, Vector3 vctr) {
        return false;
    }
    
}
