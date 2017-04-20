/*
 * Copyright (C) 2017 Jonathan Crockett
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.util.input;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerListener;
import com.badlogic.gdx.controllers.PovDirection;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author cohib
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
