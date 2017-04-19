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
package com.base.assets.util;

import com.badlogic.ashley.core.EntitySystem;
import com.base.engine.EngineBase;

public abstract class EngineSystem extends EntitySystem{
    
    //only exists to guarentee default 
    public EngineSystem(){}
    
    public abstract void update(float deltaTime);
    
    public static <T extends EngineSystem> EngineSystem addToEngine(T sys) {        
        if(EngineBase.getSystem(sys.getClass()) == null)
            EngineBase.addSystem(sys);
        
        EngineSystem realSys = EngineBase.getSystem(sys.getClass());
        realSys.setProcessing(true);
        return realSys;
    }
    
    public static <T extends EngineSystem> void removeFromEngine(Class<T> sysType) {
        EngineSystem sys = EngineBase.getSystem(sysType);
        if(sys == null)
            return;
        
        sys.setProcessing(false);
        
    }
    
}
