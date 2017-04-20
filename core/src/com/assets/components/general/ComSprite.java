
package com.assets.components.general;
import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.util.graphics.Sprite;

public class ComSprite implements Component{
    
    private Sprite sprite;
    private int offsetX = 0;
    private int offsetY = 0;
    private float scaleX = 1;
    private float scaleY = 1;
    
    public ComSprite(){
        Texture tex = new Texture("img\\Blank.png");
        TextureRegion reg = new TextureRegion();
        reg.setTexture(tex);
        sprite = new Sprite(reg);
    }

    /**
     * @return the sprite
     */
    public Sprite getSprite() {
        return sprite;
    }

    /**
     * @return the offsetX
     */
    public int getOffsetX() {
        return offsetX;
    }

    /**
     * @return the offsetY
     */
    public int getOffsetY() {
        return offsetY;
    }

    /**
     * @return the scaleX
     */
    public float getScaleX() {
        return scaleX;
    }

    /**
     * @return the scaleY
     */
    public float getScaleY() {
        return scaleY;
    }

    /**
     * @param sprite the sprite to set
     */
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    /**
     * @param offsetX the offsetX to set
     */
    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    /**
     * @param offsetY the offsetY to set
     */
    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

    /**
     * @param scaleX the scaleX to set
     */
    public void setScaleX(float scaleX) {
        this.scaleX = scaleX;
    }

    /**
     * @param scaleY the scaleY to set
     */
    public void setScaleY(float scaleY) {
        this.scaleY = scaleY;
    }
}
