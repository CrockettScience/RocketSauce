package com.assets.systems.group;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Cursor;
import com.assets.components.group.ComTextField;
import com.assets.components.general.ComBbox;
import com.assets.components.general.ComLabel;
import com.assets.components.general.ComPosition;
import com.assets.components.general.ComSprite;
import com.util.input.EngineSystem;
import com.global.ComponentMap;
import com.util.input.processors.TextInputProcessor;
import com.util.Tools;

/**
 *
 * @author Jonathan Crockett
 */
public class SysTextField extends EngineSystem{
    private TextInputProcessor text = new TextInputProcessor();
    private ImmutableArray<Entity> entities;
    
    @Override
    public void addedToEngine(Engine engine) {
        Gdx.input.setInputProcessor(text);
        entities = engine.getEntitiesFor(Family.all(ComTextField.class).get());
    }
    
    @Override
    public void update(float deltaTime) {
        for(Entity ent: entities){
            ComBbox box = ComponentMap.INPUTBOX.get(ent).getBbox();
            ComSprite spr = ComponentMap.INPUTBOX.get(ent).getSpr();
            ComLabel label = ComponentMap.INPUTBOX.get(ent).getLabel();
            ComPosition pos = ComponentMap.INPUTBOX.get(ent).getPos();
            ComTextField inBox = ComponentMap.INPUTBOX.get(ent);
            
            
            
            if(Tools.pointInBBox(Tools.getMouseX(), Tools.getMouseY(), box)){
                spr.getSprite().setAnimationIndex(1);
                Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Ibeam);
                
                if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
                    inBox.setFocus(true);
                    label.setLabel("");
                }
                    
            }else{
                spr.getSprite().setAnimationIndex(0);
                Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
                
                if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
                    inBox.setFocus(false);
                }
            
            }
            
            if(inBox.isFocus()){
                if(text.peekText().contains("\b") && label.getLabel().length() > 0){
                    label.setLabel(label.getLabel().substring(0, label.getLabel().length() - 1));
                    text.returnText();
                }else if(label.getLabel().length() < inBox.getMaxSize()){
                    label.setLabel(label.getLabel() + text.returnText());
                }
            }
            
        }
        
    }
    
}
