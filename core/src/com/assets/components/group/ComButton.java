package com.assets.components.group;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.assets.components.general.ComBbox;
import com.assets.components.general.ComFunction;
import com.assets.components.general.ComPosition;
import com.assets.components.general.ComSprite;
import com.assets.components.general.ComLabel;

/**
 *
 * @author Jonathan Crockett
 */
public class ComButton implements Component{
    
    private ComLabel label = new ComLabel();
    private ComPosition pos = new ComPosition();
    private ComSprite spr = new ComSprite();
    private ComFunction funct = new ComFunction();
    private ComBbox bbox = new ComBbox();

    private ComButton(ComPosition pos, ComLabel label, ComSprite spr, ComBbox bbox, ComFunction funct){
        if(pos != null){
            this.pos = pos;
        }
        if(label != null){
            this.label = label;
        }
        if(spr != null){
            this.spr = spr;
        }
        if(bbox != null){
            this.bbox = bbox;
        }
        if(funct != null){
            this.funct = funct;
        }
    }
    
    public static void buildButton(Entity ent, ComPosition pos, ComLabel label, ComSprite spr, ComBbox bbox, ComFunction funct){
        ComButton btn = new ComButton(pos, label, spr, bbox, funct);
        ent.add(btn);
        ent.add(btn.pos);
        ent.add(btn.label);
        ent.add(btn.spr);
        ent.add(btn.bbox);
        ent.add(btn.funct);
        
        
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
    public ComFunction getFunct() {
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
    public void setFunct(ComFunction funct) {
        this.funct = funct;
    }

    /**
     * @param bbox the bbox to set
     */
    public void setBbox(ComBbox bbox) {
        this.bbox = bbox;
    }

}