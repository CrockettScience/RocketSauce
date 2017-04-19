package com.base.util;

import com.base.util.scene.View;
import com.base.assets.components.general.ComBbox;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.base.assets.components.general.ComPosition;
import com.base.util.scene.SceneManager;

public class Tools{
    
    //Processing
    public static boolean outOfSight(ComPosition pos, View v){
        return        (pos.getX() < v.getX() - v.getWidth()
                    || pos.getX() > v.getX() + (2 * v.getWidth())
                    || pos.getY() < v.getY() - v.getHeight()
                    || pos.getY() > v.getY() + (2 * v.getHeight()));
    }
    
    public static boolean outOfMind(ComPosition pos, View v){
        return        (pos.getX() < v.getX() - (2 * v.getWidth())
                    || pos.getX() > v.getX() + (3 * v.getWidth())
                    || pos.getY() < v.getY() - (2 * v.getHeight())
                    || pos.getY() > v.getY() + (3 * v.getHeight()));
    }
    
    //Collision
    public static boolean pointInBBox(float x, float y, ComBbox box){
        return( x < (box.getWidth() + box.getX()) &&
                x > box.getX() &&
                y < (box.getHeight() + box.getY()) &&
                y > box.getY());
    }
    
    public static boolean bBoxInBBox(ComBbox boxA, ComBbox boxB){
        return( boxA.getX() < boxB.getX() + boxB.getWidth() &&
                boxA.getY() < boxB.getY() + boxB.getHeight() &&
                boxA.getX() + boxA.getWidth() > boxB.getX() &&
                boxA.getY() + boxA.getHeight() > boxB.getY());
    }
    
    //Misc    
    public static BitmapFont makeBitmapFont(String fontPath, int size, Color color){
        
        FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal(fontPath));
        FreeTypeFontParameter par = new FreeTypeFontParameter();
        
        par.size = size;
        par.color = color;
        
        BitmapFont font = gen.generateFont(par);
        
        gen.dispose();
        return font;
    }
    
    public static float getMouseX(){
        return Gdx.input.getX() * (SceneManager.getView().getWidth() / Gdx.graphics.getWidth());
    }
    
    public static float getMouseY(){
        return (Gdx.graphics.getHeight() - Gdx.input.getY()) * (SceneManager.getView().getHeight() / Gdx.graphics.getHeight());
    }
    
}
