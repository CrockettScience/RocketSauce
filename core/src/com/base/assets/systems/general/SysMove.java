package com.base.assets.systems.general;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.base.assets.components.general.ComPosition;
import com.base.assets.components.general.ComVelocity;
import com.base.assets.util.EngineSystem;
import com.base.global.BaseComponentMap;

public class SysMove extends EngineSystem {
    private ImmutableArray<Entity> entities;
    
    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(ComPosition.class, ComVelocity.class).get());
    }
    
    @Override
    public void update(float deltaTime) {
        for(Entity ent: entities){
            ComPosition pos = BaseComponentMap.POSITION.get(ent);
            ComVelocity vel = BaseComponentMap.VELOCITY.get(ent);
            
            pos.setX(pos.getX() + vel.getX() * deltaTime);
            pos.setY(pos.getY() + vel.getY() * deltaTime);
        }
    }
}
