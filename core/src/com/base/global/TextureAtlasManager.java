/*
 * Copyright (C) 2017 Jonathan Crockett
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.base.global;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.HashMap;

/**
 *
 * @author cohib
 */
public class TextureAtlasManager {
    
    private static HashMap<String, TextureAtlas> atlasMap = new HashMap<String, TextureAtlas>();
    
    public static TextureRegion getRegion(String atlas, String name){
        if(atlasMap.containsKey(atlas)){
            TextureAtlas.AtlasRegion reg = atlasMap.get(atlas).findRegion(name);
            if(reg != null && reg.rotate){
                float temp = reg.getV2();
                reg.setV2(reg.getV());
                reg.setV(temp);
            }
            return reg;
        }
        
        return null;
    }
    
    /**
     *
     * @param atlas
     * @param name
     * @param idx
     * @return
     */
    public static TextureRegion getRegion(String atlas, String name, int idx){
        if(atlasMap.containsKey(atlas)){
            TextureAtlas.AtlasRegion reg = atlasMap.get(atlas).findRegion(name, idx);
            if(reg != null && reg.rotate){
                float temp = reg.getV2();
                reg.setV2(reg.getV());
                reg.setV(temp);
            }
            return reg;
        }
        
        return null;
        
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
