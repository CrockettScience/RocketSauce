package com.assets.systems.group;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.assets.util.EngineSystem;
import com.global.Preferences;
import com.util.Tools;
import com.assets.components.group.ComButton;
import com.global.ComponentMap;

/**
 *
 * @author Jonathan Crockett
 */
public class SysButton extends EngineSystem {
    private ImmutableArray<Entity> entities;
    
    public void addedToEngine(Engine engine) {
        entities = engine.getEntitiesFor(Family.all(ComButton.class).get());
    }
    
    public void update(float deltaTime){
        if(Preferences.prefs.read("CONTROLS", "ControllerID", "Mouse & Keyboard").equals("Mouse & Keyboard")){
            for(Entity ent: entities){
                ComButton btn = ComponentMap.BUTTON.get(ent);

                if(Tools.pointInBBox(Tools.getMouseX(), Tools.getMouseY(), btn.getBbox())){
                    btn.getSpr().getSprite().setAnimationIndex(1);

                    if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
                        btn.getFunct().executeFunction();
                    }

                }else{
                    btn.getSpr().getSprite().setAnimationIndex(0);
                }
            }
        }
    }
}
