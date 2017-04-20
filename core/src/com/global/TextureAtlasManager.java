package com.global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.HashMap;

/**
 *
 * @author Jonathan Crockett
 */
public class TextureAtlasManager {
    
    private static HashMap<String, TextureAtlas> atlasMap = new HashMap<String, TextureAtlas>();
    
    public static TextureRegion getRegion(String atlas, String name){
        if(atlasMap.containsKey(atlas)){
            TextureAtlas.AtlasRegion reg = atlasMap.get(atlas).findRegion(name);
            if(reg != null){
                if(reg.rotate) {
                    float temp = reg.getV2();
                    reg.setV2(reg.getV());
                    reg.setV(temp);
                }
                return reg;
            }
        }
        
        return new TextureRegion(new Texture(Gdx.files.internal("img\\Blank.png")));
    }
    
    public static TextureRegion getRegion(String atlas, String name, int idx){
        if(atlasMap.containsKey(atlas)){
            TextureAtlas.AtlasRegion reg = atlasMap.get(atlas).findRegion(name, idx);
            if(reg != null) {
                if(reg.rotate) {
                    float temp = reg.getV2();
                    reg.setV2(reg.getV());
                    reg.setV(temp);
                }
                return reg;
            }
        }
        
        return new TextureRegion(new Texture(Gdx.files.internal("img\\Blank.png")));
        
    }
    
    public static boolean addRegion(String atlas, String name, TextureRegion tex){
        if(atlasMap.containsKey(atlas)){
            atlasMap.get(atlas).addRegion(name, tex);
        }
        
        return false;
    }
    
    public static boolean addRegion(String atlas, String name, Texture tex, int x, int y, int width, int height){
        if(atlasMap.containsKey(atlas)){
            atlasMap.get(atlas).addRegion(name, tex, x, y, width, height);
        }
        
        return false;
    }
    
    public static boolean createAtlas(String atlas){
        if(!atlasMap.containsKey(atlas)){
            atlasMap.put(atlas, new TextureAtlas());
            return true;
        }
        
        return false;
    }
    
    public static boolean disposeAtlas(String atlas){
        if(atlasMap.containsKey(atlas)){
            atlasMap.get(atlas).dispose();
            atlasMap.remove(atlas);
            return true;
        }
        
        return false;
    }
    
    public static void clear(){
        for(TextureAtlas atlas : atlasMap.values()){
            atlas.dispose();
        }
        
        atlasMap.clear();
    }
}
