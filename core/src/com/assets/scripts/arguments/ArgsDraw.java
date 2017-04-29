package com.assets.scripts.arguments;

import com.badlogic.ashley.core.Entity;
import com.util.script.Argument;

/**
 *
 * @author Jonathan Crockett
 */
public class ArgsDraw extends Argument {
    private Entity self;
    private float deltaTime;
    
    public ArgsDraw(Entity ent, float delta){
        self = ent;
        deltaTime = delta;
    }

    public Entity getSelf() {
        return self;
    }

    public float getDeltaTime() {
        return deltaTime;
    }

    public void setSelf(Entity self) {
        this.self = self;
    }

    public void setDeltaTime(float deltaTime) {
        this.deltaTime = deltaTime;
    }
}
