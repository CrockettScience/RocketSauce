package com.assets.components.group;
import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.assets.components.general.ComBbox;
import com.assets.components.general.ComPosition;
import com.assets.components.general.ComSprite;
import com.assets.components.general.ComVelocity;

/**
 *
 * @author Jonathan Crockett
 */
public class ComActor implements Component {
    
    private ComPosition pos = new ComPosition();
    private ComVelocity vel = new ComVelocity();
    private ComSprite spr = new ComSprite();
    private ComBbox bbox = new ComBbox();
    
    private ComActor(ComPosition cPos, ComVelocity cVel, ComSprite cSpr, ComBbox cBbox){
        pos = cPos == null ? pos : cPos;
        vel = cVel == null ? vel : cVel;
        spr = cSpr == null ? spr : cSpr;
        bbox = cBbox == null ? bbox : cBbox;
    }
    
    public static void buildActor(Entity ent, ComPosition pos, ComVelocity vel, ComSprite spr, ComBbox bbox){
        ComActor actor = new ComActor(pos, vel, spr, bbox);
        ent.add(actor);
        ent.add(actor.pos);
        ent.add(actor.vel);
        ent.add(actor.spr);
        ent.add(actor.bbox);
    }
    
    /**
     * @return the pos
     */
    public ComPosition getPos() {
        return pos;
    }

    /**
     * @return the vel
     */
    public ComVelocity getVel() {
        return vel;
    }

    /**
     * @return the spr
     */
    public ComSprite getSpr() {
        return spr;
    }

    /**
     * @return the bbox
     */
    public ComBbox getBbox() {
        return bbox;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(ComPosition pos) {
        this.pos = pos;
    }

    /**
     * @param vel the vel to set
     */
    public void setVel(ComVelocity vel) {
        this.vel = vel;
    }

    /**
     * @param spr the spr to set
     */
    public void setSpr(ComSprite spr) {
        this.spr = spr;
    }

    /**
     * @param bbox the bbox to set
     */
    public void setBbox(ComBbox bbox) {
        this.bbox = bbox;
    }
    
    
}
