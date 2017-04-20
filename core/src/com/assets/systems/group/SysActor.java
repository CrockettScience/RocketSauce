package com.assets.systems.group;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.assets.components.group.ComActor;
import com.util.input.EngineSystem;
import com.global.ComponentMap;

/**
 *
 * @author Jonathan Crockett
 */
public class SysActor extends EngineSystem {
    private ImmutableArray<Entity> entities;
    
    @Override
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(ComActor.class).get());
    }
    
    @Override
    public void update(float deltaTime) {
        for(Entity ent: entities){
            ComActor actor = ComponentMap.ACTOR.get(ent);
            
            actor.getPos().setX(actor.getPos().getX() + actor.getVel().getX());
            actor.getPos().setY(actor.getPos().getY() + actor.getVel().getY());
            actor.getBbox().setX((int)actor.getPos().getX() - actor.getSpr().getOffsetX());
            actor.getBbox().setY((int)actor.getPos().getY() - actor.getSpr().getOffsetY());
        }
        
    }
    
}
