package com.util.input.processors;

import com.badlogic.gdx.Gdx;
import com.util.input.EngineSystem;
import com.engine.EngineBase;
import java.util.ArrayList;

/**
 *
 * @author Jonathan Crockett
 */
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
