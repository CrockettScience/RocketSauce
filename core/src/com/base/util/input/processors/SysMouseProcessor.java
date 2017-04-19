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
package com.base.util.input.processors;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.base.assets.util.EngineSystem;
import com.base.engine.EngineBase;
import java.util.ArrayList;

public class SysMouseProcessor extends EngineSystem {
    
    static SysMouseProcessor activeProcessor;
    
    private ArrayList<AbstractMouseInputProcessor> processors = new ArrayList<AbstractMouseInputProcessor>();
    
    private SysMouseProcessor(){
        activeProcessor = this;
    }
    
    public static void create(){
        if(activeProcessor == null){
            SysMouseProcessor smp = new SysMouseProcessor();
            EngineBase.addSystem(smp);
            activeProcessor = smp;
        }
    }
    
    public static void remove(){
        EngineBase.removeSystem(activeProcessor);
        activeProcessor = null;
    }
    
    public void update(float deltaTime) {
        for(AbstractMouseInputProcessor Amip : processors){
            Amip.update(0, Gdx.input.isButtonPressed(0));
            Amip.update(1, Gdx.input.isButtonPressed(1));
        }
    }
    
    void add(AbstractMouseInputProcessor Amip){
        processors.add(Amip);
    }
    
}
