package com.base.engine;


import com.base.util.scene.SceneManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.base.util.Ini;
import com.badlogic.gdx.graphics.GL20;
import com.base.assets.attributes.AttBckColor;
import com.base.global.Preferences;
import com.base.global.TextureAtlasManager;
import com.rocketsauce.assets.scenes.ScnRocketSauce;

public class EngineApplication extends ApplicationAdapter{
	
        public EngineApplication(Ini ini){
            super();
            Preferences.prefs = ini;
            
        }
        
	public void create(){
            //set up Engine
            EngineBase.initialize(1024);
            
            //DESIGNATE FIRST ENTRY SCENE HERE
            SceneManager.setScene(new ScnRocketSauce());
	}
        
	public void render (){
            SceneManager.getView().getViewport().getCamera().update();
            AttBckColor c = SceneManager.getScene().getAttribute(AttBckColor.class);
            
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
            TextureAtlasManager.clear();
	}
}
