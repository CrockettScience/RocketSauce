package com.assets.scenes;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.assets.attributes.AttParallax;
import com.assets.components.general.ComBbox;
import com.assets.components.general.ComFunction;
import com.assets.components.general.ComLabel;
import com.assets.components.general.ComPosition;
import com.assets.components.general.ComSound;
import com.assets.components.general.ComSprite;
import com.assets.scripts.ScrQuit;
import com.util.input.EngineSystem;
import com.util.script.Script;
import com.global.TextureManager;
import com.util.Tools;
import com.util.graphics.Parallax;
import com.util.graphics.Sprite;
import com.util.scene.Scene;
import com.assets.components.group.ComButton;
import com.assets.components.group.ComTextField;
import com.assets.scripts.ScrVolume;
import com.assets.systems.group.SysButton;
import com.assets.systems.group.SysTextField;
import com.global.AudioManager;

/**
 *
 * @author Jonathan Crockett
 */
public class ScnMain extends Scene {
    private static BitmapFont menuFont;
    
    @Override
    protected void loadResources() {
        //Load textures
        TextureManager.createAtlas("RocketSauce");
        
        TextureManager.addRegion("RocketSauce", "button", "main\\ui_button.png", 384, 32);
        TextureManager.addRegion("RocketSauce", "arrow", "main\\ui_arrow.png");
        TextureManager.addRegion("RocketSauce", "back", "main\\bg_triangles.png");
        TextureManager.addRegion("RocketSauce", "inputbox", "main\\ui_inputbox.png");
        TextureManager.addRegion("RocketSauce", "textbox", "main\\ui_textbox.png");
        
        //load audio
        AudioManager.addMusic("carefree", "msc_carefree.mp3");
        AudioManager.addSound("select", "snd_click.wav");
        
        //load font
        menuFont = Tools.makeBitmapFont("fnt_main.ttf", 28, Color.WHITE);
        
        //load systems
        EngineSystem.addToEngine(new SysButton());
        EngineSystem.addToEngine(new SysTextField());
        
        //load scene attributes
        AttParallax parallax = new AttParallax();
        parallax.background_0 = new Parallax(TextureManager.getRegion("RocketSauce", "back"), 10, 0);
        addAttribute(parallax);
        
        Entity volumeLevels = new Entity();
            
            ComPosition vPos = new ComPosition();
            vPos.setX(Gdx.graphics.getWidth() * 0.85f);
            vPos.setY(128);

            ComSprite vSpr = new ComSprite();
            vSpr.setSprite(new Sprite(TextureManager.getRegion("RocketSauce", "textbox")));
            vSpr.setOffsetX(vSpr.getSprite().getWidth() / 2);
            
            ComLabel vLabel = new ComLabel();
            vLabel.setFont(menuFont);
            vLabel.setX(0);
            vLabel.setY(23);
            vLabel.setHAlign(ComLabel.HAlignment.CENTER);
            vLabel.setLabel("Volume");
            
            volumeLevels.add(vPos);
            volumeLevels.add(vSpr);
            volumeLevels.add(vLabel);
            
        Entity musicVol = new Entity();
            
            ComPosition pos = new ComPosition();
            pos.setX(vPos.getX());
            pos.setY(vPos.getY() - 32);

            ComSprite spr = new ComSprite();
            spr.setSprite(new Sprite(TextureManager.getRegion("RocketSauce", "textbox")));
            spr.setOffsetX(spr.getSprite().getWidth() / 2);
            
            ComLabel label = new ComLabel();
            label.setFont(menuFont);
            label.setX(0);
            label.setY(23);
            label.setHAlign(ComLabel.HAlignment.CENTER);
            label.setLabel("Music");
            
            musicVol.add(pos);
            musicVol.add(spr);
            musicVol.add(label);
            
        Entity soundVol = new Entity();
            
            pos = new ComPosition();
            pos.setX(vPos.getX());
            pos.setY(vPos.getY() - 64);

            spr = new ComSprite();
            spr.setSprite(new Sprite(TextureManager.getRegion("RocketSauce", "textbox")));
            spr.setOffsetX(spr.getSprite().getWidth() / 2);
            
            label = new ComLabel();
            label.setFont(menuFont);
            label.setX(0);
            label.setY(23);
            label.setHAlign(ComLabel.HAlignment.CENTER);
            label.setLabel("Sound");
            
            soundVol.add(pos);
            soundVol.add(spr);
            soundVol.add(label);
        
        Entity masterVol = new Entity();
            
            pos = new ComPosition();
            pos.setX(vPos.getX());
            pos.setY(vPos.getY() - 96);

            spr = new ComSprite();
            spr.setSprite(new Sprite(TextureManager.getRegion("RocketSauce", "textbox")));
            spr.setOffsetX(spr.getSprite().getWidth() / 2);
            
            label = new ComLabel();
            label.setFont(menuFont);
            label.setX(0);
            label.setY(23);
            label.setHAlign(ComLabel.HAlignment.CENTER);
            label.setLabel("Master");
            
            masterVol.add(pos);
            masterVol.add(spr);
            masterVol.add(label);
        
        putEntity("volume", volumeLevels);
        putEntity("musicVol", musicVol);
        putEntity("soundVol", soundVol);
        putEntity("masterVol", masterVol);
        
        putEntity("musicVolDown", buttonArrow("", vPos.getX() - 80, vPos.getY() - 32, -1, 1, new ScrVolume(ScrVolume.VolumeType.MUSIC, -0.01f)));
        putEntity("musicVolUp", buttonArrow("", vPos.getX() + 80, vPos.getY() - 32, 1, 1, new ScrVolume(ScrVolume.VolumeType.MUSIC, 0.01f)));
        
        putEntity("soundVolDown", buttonArrow("", vPos.getX() - 80, vPos.getY() - 64, -1, 1, new ScrVolume(ScrVolume.VolumeType.SOUND, -0.01f)));
        putEntity("soundVolUp", buttonArrow("", vPos.getX() + 80, vPos.getY() - 64, 1, 1, new ScrVolume(ScrVolume.VolumeType.SOUND, 0.01f)));
        
        putEntity("masterVolDown", buttonArrow("", vPos.getX() - 80, vPos.getY() - 96, -1, 1, new ScrVolume(ScrVolume.VolumeType.MASTER, -0.01f)));
        putEntity("masterVolUp", buttonArrow("", vPos.getX() + 80, vPos.getY() - 96, 1, 1, new ScrVolume(ScrVolume.VolumeType.MASTER, 0.01f)));
        
        putEntity("hey", buttonSquare("Goodbye World", Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() * 0.25f, new ScrQuit()));
        putEntity("type", inputBox("RocketSauce!", Gdx.graphics.getWidth() * 0.5f, Gdx.graphics.getHeight() * 0.5f, 44));
    
    }

    @Override
    protected void destroyResources() {
        removeAttribute(AttParallax.class);
        
        TextureManager.disposeAtlas("RocketSauce");
        
        menuFont.dispose();
        
        EngineSystem.removeFromEngine(SysButton.class);
        EngineSystem.removeFromEngine(SysTextField.class);
        
        this.removeEntities();
    }

    @Override
    protected void sceneMain() {
        activateEntity("volume");
        activateEntity("musicVol");
        activateEntity("soundVol");
        activateEntity("masterVol");
        
        activateEntity("musicVolDown");
        activateEntity("musicVolUp");
        
        activateEntity("soundVolDown");
        activateEntity("soundVolUp");
        
        activateEntity("masterVolDown");
        activateEntity("masterVolUp");
        
        activateEntity("hey");
        activateEntity("type");
        
        AudioManager.playMusic("carefree");
    }
    
    private Entity buttonSquare(String bLabel, float x, float y, Script script) {
        Entity button = new Entity();
            
            ComPosition pos = new ComPosition();
            pos.setX(x);
            pos.setY(y);

            ComSprite spr = new ComSprite();
            spr.setSprite(new Sprite(TextureManager.getRegion("RocketSauce", "button"), 1, 2, 2, 10, true, true));
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
            
            ComSound sound = new ComSound();
            sound.addSound("highlight", "select");
            
        ComButton.buildButton(button, pos, label, spr, bbox, function, sound);
        
        return button;
    }
    
    private Entity buttonArrow(String bLabel, float x, float y, float scaleX, float scaleY, Script script) {
        Entity button = new Entity();
            
            ComPosition pos = new ComPosition();
            pos.setX(x);
            pos.setY(y);

            ComSprite spr = new ComSprite();
            spr.setSprite(new Sprite(TextureManager.getRegion("RocketSauce", "arrow"), 1, 2, 2, 10, true, true));
            spr.setOffsetX(spr.getSprite().getWidth() / 2);
            spr.setScaleX(scaleX);
            spr.setScaleY(scaleY);

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
            
            ComSound sound = new ComSound();
            sound.addSound("highlight", "select");
            
        ComButton.buildButton(button, pos, label, spr, bbox, function, sound);
        
        return button;
    }

    private Entity inputBox(String message, float x, float y, int maxSize) {
        Entity ent = new Entity();
        
            ComPosition pos = new ComPosition();
            pos.setX(x);
            pos.setY(y);
            
            ComSprite spr = new ComSprite();
            spr.setSprite(new Sprite(TextureManager.getRegion("RocketSauce", "inputbox"), 1, 2, 2, 1, true, true));
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
