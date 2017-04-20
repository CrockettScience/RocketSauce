package com.assets.scenes;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.assets.attributes.AttParallax;
import com.assets.components.general.ComBbox;
import com.assets.components.general.ComFunction;
import com.assets.components.general.ComLabel;
import com.assets.components.general.ComPosition;
import com.assets.components.general.ComSprite;
import com.assets.scripts.ScrQuit;
import com.assets.scripts.ScrVoid;
import com.assets.util.EngineSystem;
import com.assets.util.script.Script;
import com.global.TextureAtlasManager;
import com.util.Tools;
import com.util.graphics.Parallax;
import com.util.graphics.Sprite;
import com.util.scene.Attribute;
import com.util.scene.Scene;
import com.assets.components.group.ComButton;
import com.assets.components.group.ComTextField;
import com.assets.systems.group.SysButton;
import com.assets.systems.group.SysTextField;
import com.engine.EngineBase;
import javafx.scene.control.MenuButton;

/**
 *
 * @author Jonathan Crockett
 */
public class ScnMain extends Scene {
    private static BitmapFont menuFont;
    
    @Override
    protected void loadResources() {
        //Load Textures
        TextureAtlasManager.createAtlas("RocketSauce");
        
        TextureAtlasManager.addRegion("RocketSauce", "button", new TextureRegion(new Texture(Gdx.files.internal("img\\main\\ui_button.png")), 384, 32));
        TextureAtlasManager.addRegion("RocketSauce", "back", new TextureRegion(new Texture(Gdx.files.internal("img\\main\\bg_triangles.png"))));
        TextureAtlasManager.addRegion("RocketSauce", "inputbox", new TextureRegion(new Texture(Gdx.files.internal("img\\main\\ui_inputbox.png"))));
        
        //load font
        menuFont = Tools.makeBitmapFont("font\\MenuFont.ttf", 28, Color.WHITE);
        
        //load systems
        EngineSystem.addToEngine(new SysButton());
        EngineSystem.addToEngine(new SysTextField());
        
        //load scene attributes
        AttParallax parallax = new AttParallax();
        parallax.background_0 = new Parallax(TextureAtlasManager.getRegion("RocketSauce", "back"), 10, 0);
        addAttribute(parallax);
        
        putEntity("hey", button("Goodbye World", Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() * 0.25f, new ScrQuit()));
        putEntity("type", inputBox("RocketSauce!", Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() * 0.5f, 28));
    
    }

    @Override
    protected void destroyResources() {
        removeAttribute(AttParallax.class);
        
        TextureAtlasManager.disposeAtlas("RocketSauce");
        
        menuFont.dispose();
        
        EngineSystem.removeFromEngine(SysButton.class);
        EngineSystem.removeFromEngine(SysTextField.class);
        
        this.removeEntities();
    }

    @Override
    protected void sceneMain() {
        activateEntity("hey");
        activateEntity("type");
    }
    
    private Entity button(String bLabel, float x, float y, Script script) {
        Entity button = new Entity();
            
            ComPosition pos = new ComPosition();
            pos.setX(x);
            pos.setY(y);

            ComSprite spr = new ComSprite();
            spr.setSprite(new Sprite(TextureAtlasManager.getRegion("RocketSauce", "button"), 1, 2, 2, 10, true, true));
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

    private Entity inputBox(String message, float x, float y, int maxSize) {
        Entity ent = new Entity();
        
            ComPosition pos = new ComPosition();
            pos.setX(x);
            pos.setY(y);
            
            ComSprite spr = new ComSprite();
            spr.setSprite(new Sprite(TextureAtlasManager.getRegion("RocketSauce", "inputbox"), 1, 2, 2, 1, true, true));
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
