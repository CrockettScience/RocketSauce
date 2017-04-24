
package com.assets.components.group;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.assets.components.general.ComBbox;
import com.assets.components.general.ComSprite;
import com.assets.components.general.ComPosition;
import com.assets.components.general.ComLabel;

/**
 *
 * @author Jonathan Crockett
 */
public class ComTextField implements Component{
    
    private ComSprite spr = new ComSprite();
    private ComLabel label = new ComLabel();
    private ComBbox bbox = new ComBbox();
    private ComPosition pos = new ComPosition();
    private boolean focus = false;
    private int maxSize;

    private ComTextField(ComSprite cSpr, ComPosition cPos, ComLabel cLabel, ComBbox cBbox){
        pos = cPos == null ? pos : cPos;
        label = cLabel == null ? label : cLabel;
        spr = cSpr == null ? spr : cSpr;
        bbox = cBbox == null ? bbox : cBbox;
    }
    
    public static void buildInputBox(Entity ent, ComSprite spr, ComPosition pos, ComLabel label, ComBbox bbox, int maxSize){
        ComTextField inp = new ComTextField(spr, pos, label, bbox);
        inp.maxSize = maxSize;
        ent.add(inp);
        ent.add(inp.spr);
        ent.add(inp.label);
        ent.add(inp.bbox);
        ent.add(inp.pos);
    }

    /**
     * @return the spr
     */
    public ComSprite getSpr() {
        return spr;
    }

    /**
     * @return the label
     */
    public ComLabel getLabel() {
        return label;
    }

    /**
     * @return the bbox
     */
    public ComBbox getBbox() {
        return bbox;
    }

    /**
     * @param spr the spr to set
     */
    public void setSpr(ComSprite spr) {
        this.spr = spr;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(ComLabel label) {
        this.label = label;
    }

    /**
     * @param bbox the bbox to set
     */
    public void setBbox(ComBbox bbox) {
        this.bbox = bbox;
    }

    /**
     * @return the pos
     */
    public ComPosition getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(ComPosition pos) {
        this.pos = pos;
    }

    /**
     * @return the focus
     */
    public boolean isFocus() {
        return focus;
    }

    /**
     * @param focus the focus to set
     */
    public void setFocus(boolean focus) {
        this.focus = focus;
    }

    /**
     * @return the maxSize
     */
    public int getMaxSize() {
        return maxSize;
    }

}