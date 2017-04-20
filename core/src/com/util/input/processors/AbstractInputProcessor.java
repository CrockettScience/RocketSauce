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

package com.util.input.processors;

import com.badlogic.gdx.InputProcessor;

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
