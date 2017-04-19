package com.rocketsauce.assets.scenes;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.base.assets.components.general.ComBbox;
import com.base.assets.components.general.ComFunction;
import com.base.assets.components.general.ComLabel;
import com.base.assets.components.general.ComPosition;
import com.base.assets.components.general.ComSprite;
import com.base.assets.util.script.Script;
import com.base.global.TextureAtlasManager;
import com.base.util.Tools;
import com.base.util.graphics.Sprite;
import com.base.util.scene.Scene;
import com.rocketsauce.assets.components.componentGroups.ComButton;
import com.rocketsauce.assets.components.componentGroups.ComTextField;

/**
 *
 * @author Jonathan Crockett
 */
public class ScnRocketSauce extends Scene {
    private static BitmapFont menuFont;
    
    @Override
    protected void loadResources() {
        //Load Textures
        TextureAtlasManager.createAtlas("RocketSauce");
        
        TextureAtlasManager.addRegion("RocketSauce", "button", new TextureRegion(new Texture(Gdx.files.internal("ui_button.png")), 384, 32));
        TextureAtlasManager.addRegion("RocketSauce", "back", new TextureRegion(new Texture(Gdx.files.internal("bg_triangles.png"))));
        TextureAtlasManager.addRegion("RocketSauce", "inputbox", new TextureRegion(new Texture(Gdx.files.internal("ui_inputbox.png"))));
        
        
        menuFont = Tools.makeBitmapFont("font\\MenuFont.ttf", 28, Color.WHITE);
    }

    @Override
    protected void destroyResources() {
        
    }
    
    private Entity menuButton(String bLabel, float x, float y, Script script) {
        Entity button = new Entity();
            
            ComPosition pos = new ComPosition();
            pos.setX(x);
            pos.setY(y);

            ComSprite spr = new ComSprite();
            spr.setSprite(new Sprite(TextureAtlasManager.getRegion("main", "button"), 1, 2, 2, 10, true, true));
            spr.setOffsetX(spr.getSprite().getWidth() / 2);

            ComBbox bbox = new ComBbox();
            bbox.setX(pos.getX() - spr.getOffsetX());
            bbox.setY(pos.getY() - spr.getOffsetY());
            bbox.setWidth(spr.getSprite().getWidth());
            bbox.setHeight(spr.getSprite().getHeight());
            
            ComLabel label = new ComLabel();
            label.setFont(menuFont);
            label.setX(0);
            label.setY(23);
            label.setHAlign(ComLabel.HAlignment.CENTER);
            label.setLabel(bLabel);
            
            ComFunction function = new ComFunction();
            function.setFunction(script);
            
        ComButton.buildButton(button, pos, label, spr, bbox, function);
        
        return button;
    }

    private Entity menuInputBox(String message, float x, float y, int maxSize) {
        Entity ent = new Entity();
        
            ComPosition pos = new ComPosition();
            pos.setX(x);
            pos.setY(y);
            
            ComSprite spr = new ComSprite();
            spr.setSprite(new Sprite(TextureAtlasManager.getRegion("main", "inputBox"), 1, 2, 2, 1, true, true));
            spr.setOffsetX(spr.getSprite().getWidth() / 2);
            
            ComBbox bbox = new ComBbox();
            bbox.setX(pos.getX() - spr.getOffsetX());
            bbox.setY(pos.getY());
            bbox.setWidth(spr.getSprite().getWidth());
            bbox.setHeight(spr.getSprite().getHeight());
            
            ComLabel label = new ComLabel();
            label.setFont(menuFont);
            label.setX(0);
            label.setY(23);
            label.setHAlign(ComLabel.HAlignment.CENTER);
            label.setLabel(message);
            
                        
            ComTextField.buildInputBox(ent, spr, pos, label, bbox, maxSize);
            
            
        return ent;
    }
    
}
