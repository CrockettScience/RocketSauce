package com.assets.systems.general;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.assets.components.general.ComPosition;
import com.assets.components.general.ComVelocity;
import com.assets.systems.EngineSystem;
import com.global.ComponentMap;

/**
 *
 * @author Jonathan Crockett
 */
public class SysMove extends EngineSystem {
    private ImmutableArray<Entity> entities;
    
    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(ComPosition.class, ComVelocity.class).get());
    }
    
    @Override
    public void update(float deltaTime) {
        for(Entity ent: entities){
            ComPosition pos = ComponentMap.POSITION.get(ent);
            ComVelocity vel = ComponentMap.VELOCITY.get(ent);
            
            pos.setX(pos.getX() + vel.getX() * deltaTime);
            pos.setY(pos.getY() + vel.getY() * deltaTime);
        }
    }
}
