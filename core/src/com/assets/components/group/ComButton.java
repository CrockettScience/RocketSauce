package com.assets.components.group;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.assets.components.general.ComBbox;
import com.assets.components.general.ComScript;
import com.assets.components.general.ComPosition;
import com.assets.components.general.ComSprite;
import com.assets.components.general.ComLabel;
import com.assets.components.general.ComSound;

/**
 *
 * @author Jonathan Crockett
 */
public class ComButton implements Component{
    
    private ComLabel label = new ComLabel();
    private ComPosition pos = new ComPosition();
    private ComSprite spr = new ComSprite();
    private ComScript funct = new ComScript();
    private ComBbox bbox = new ComBbox();
    private ComSound sound = new ComSound();
    private boolean highlighted = false;

    private ComButton(ComPosition cPos, ComLabel cLabel, ComSprite cSpr, ComBbox cBbox, ComScript cFunct, ComSound cSound){
        pos = cPos == null ? pos : cPos;
        label = cLabel == null ? label : cLabel;
        spr = cSpr == null ? spr : cSpr;
        bbox = cBbox == null ? bbox : cBbox;
        funct = cFunct == null ? funct : cFunct;
        sound = cSound == null ? sound : cSound;
    }
    
    public static void buildButton(Entity ent, ComPosition pos, ComLabel label, ComSprite spr, ComBbox bbox, ComScript funct, ComSound sound){
        ComButton btn = new ComButton(pos, label, spr, bbox, funct, sound);
        ent.add(btn);
        ent.add(btn.pos);
        ent.add(btn.label);
        ent.add(btn.spr);
        ent.add(btn.bbox);
        ent.add(btn.funct);
        ent.add(btn.getSound());
        
        
    }

    /**
     * @return the label
     */
    public ComLabel getLabel() {
        return label;
    }

    /**
     * @return the pos
     */
    public ComPosition getPos() {
        return pos;
    }

    /**
     * @return the spr
     */
    public ComSprite getSpr() {
        return spr;
    }

    /**
     * @return the funct
     */
    public ComScript getFunct() {
        return funct;
    }

    /**
     * @return the bbox
     */
    public ComBbox getBbox() {
        return bbox;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(ComLabel label) {
        this.label = label;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(ComPosition pos) {
        this.pos = pos;
    }

    /**
     * @param spr the spr to set
     */
    public void setSpr(ComSprite spr) {
        this.spr = spr;
    }

    /**
     * @param funct the funct to set
     */
    public void setFunct(ComScript funct) {
        this.funct = funct;
    }

    /**
     * @param bbox the bbox to set
     */
    public void setBbox(ComBbox bbox) {
        this.bbox = bbox;
    }

    public ComSound getSound() {
        return sound;
    }

    public void setSound(ComSound sound) {
        this.sound = sound;
    }

    public boolean isHighlighted() {
        return highlighted;
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }

}