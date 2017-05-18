package com.util.input;

import com.badlogic.ashley.core.EntitySystem;
import com.engine.EngineBase;

/**
 *
 * @author Jonathan Crockett
 */
public abstract class EngineSystem extends EntitySystem{
    
    //only exists to guarentee default constructor
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