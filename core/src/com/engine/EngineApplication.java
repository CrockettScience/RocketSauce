package com.engine;

import com.util.scene.SceneManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.util.Ini;
import com.badlogic.gdx.graphics.GL20;
import com.assets.attributes.AttBckColor;
import com.global.Preferences;
import com.global.TextureManager;
import com.assets.scenes.ScnMain;

/**
 *
 * @author Jonathan Crockett
 */
public class EngineApplication extends ApplicationAdapter {
	
        public EngineApplication(Ini ini){
            super();
            Preferences.prefs = ini;
            
        }
        
	public void create(){
            //set up Engine
            EngineBase.initialize(1024);
            
            //DESIGNATE FIRST ENTRY SCENE HERE
            SceneManager.setScene(new ScnMain());
	}
        
	public void render (){
            SceneManager.getView().getViewport().getCamera().update();
            AttBckColor c = SceneManager.getCurrentScene().getAttribute(AttBckColor.class);
            
            if(c == null){
                c = new AttBckColor();
                c.red = c.green = c.blue = 0.5f;
            }
            
            EngineBase.getFbo().begin();
            Gdx.gl.glClearColor(c.red, c.green, c.blue, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            EngineBase.getFbo().end();
            
            EngineBase.update(Gdx.graphics.getDeltaTime());
	}
        
        //SHOULD MOVE THIS
        public void resize(int width, int height){
            SceneManager.getView().getViewport().update(width, height, true);
        }
	
	public void dispose(){
            TextureManager.clear();
	}
}