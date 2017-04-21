package com.global;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.HashMap;

/**
 *
 * @author Jonathan Crockett
 */
public class TextureManager {
    public static final String IMAGE_ROOT = "img\\";
    
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
        System.out.println("TextureManager: Unable to load texture in atlas '" + atlas + "' called '" + name + "'");
        return new TextureRegion(new Texture(Gdx.files.internal("engine\\img_missing.png")));
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
        
        System.out.println("TextureManager: Unable to load texture in atlas '" + atlas + "' called '" + name + "'");
        return new TextureRegion(new Texture(Gdx.files.internal("engine\\img_missing.png")));
        
    }
    
    public static boolean addRegion(String atlas, String name, String path){
        if(atlasMap.containsKey(atlas)){
            try{
                atlasMap.get(atlas).addRegion(name, new TextureRegion(new Texture(Gdx.files.internal(IMAGE_ROOT + path))));
            }
            catch(GdxRuntimeException e){
                System.out.println("TextureManager: Unable to find image " + path);
                return false;
            }
            return true;
        }
        
        return false;
    }
    
    public static boolean addRegion(String atlas, String name, String path, int width, int height){
        if(atlasMap.containsKey(atlas)){
            try{
                atlasMap.get(atlas).addRegion(name, new TextureRegion(new Texture(Gdx.files.internal(IMAGE_ROOT + path)), width, height));
            }
            catch(GdxRuntimeException e){
                System.out.println("TextureManager: Unable to find image " + path);
                return false;
            }
            return true;
        }
        
        return false;
    }
    
    public static boolean addRegion(String atlas, String name, String path, int x, int y, int width, int height){
        if(atlasMap.containsKey(atlas)){
            try{
                atlasMap.get(atlas).addRegion(name, new Texture(Gdx.files.internal(IMAGE_ROOT + path)), x, y, width, height);
            }
            catch(GdxRuntimeException e){
                System.out.println("TextureManager: Unable to find image " + path);
                return false;
            }
            return true;
        }
        
        return false;
    }
    
    public static boolean createAtlas(String atlas){
        if(!atlasMap.containsKey(atlas)){
            atlasMap.put(atlas, new TextureAtlas());
            return true;
        }
        System.out.println("TextureManager: Could not create atlas; atlas " + atlas + " already exists.");
        return false;
    }
    
    public static boolean disposeAtlas(String atlas){
        if(atlasMap.containsKey(atlas)){
            atlasMap.get(atlas).dispose();
            atlasMap.remove(atlas);
            return true;
        }
        System.out.println("TextureManager: Could not dispose atlas; atlas " + atlas + " does not exist.");
        return false;
    }
    
    public static void clear(){
        for(TextureAtlas atlas : atlasMap.values()){
            atlas.dispose();
        }
        
        atlasMap.clear();
    }
}
