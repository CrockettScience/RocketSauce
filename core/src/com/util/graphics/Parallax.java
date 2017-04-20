package com.util.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
import com.util.scene.SceneManager;
import com.util.scene.View;
import static java.lang.Math.abs;

/**
 *
 * @author Jonathan Crockett
 */
public class Parallax{
    private TiledDrawable background;
    private final int x;
    private final int y;
    private float updateX = 0;
    private float updateY = 0;
    private final int tileWidth;
    private final int tileHeight;
    private float speedX;
    private float speedY;
    private float lastViewX = SceneManager.getView().getX();
    private float lastViewY = SceneManager.getView().getY();
    
    public Parallax(TextureRegion region, int speedX, int speedY){
        background = new TiledDrawable(region);
        tileWidth = region.getRegionWidth();
        tileHeight = region.getRegionHeight();
        this.speedX = speedX;
        this.speedY = speedY;
        this.x = -tileWidth;
        this.y = -tileHeight;
    }
    
    /**
     * @return the background
     */
    public TiledDrawable getTexture() {
        return background;
    }

    /**
     * @param background the background to set
     */
    public void setTexture(TiledDrawable background) {
        this.background = background;
    }

    /**
     *
     * @param batch
     */
    public void updateTexture(SpriteBatch batch){
        View v = SceneManager.getView();
        
        updateX += (speedX * Gdx.graphics.getDeltaTime()) - (v.getX() - lastViewX);
        updateY += (speedY * Gdx.graphics.getDeltaTime()) - (v.getY() - lastViewY);
        
        lastViewX = v.getX();
        lastViewY = v.getY();
        
        if (abs(updateX) >= tileWidth){
            updateX -= tileWidth * (updateX / abs(updateX));
        }
        if (abs(updateY) >= tileHeight){
            updateY -= tileHeight * (updateY / abs(updateY));
        }
        
        background.draw(batch, (x) + updateX, (y) + updateY, v.getWidth() + (2 * tileWidth), v.getHeight() + (2 * tileHeight));
        
        
    }

    /**
     * @return the speedX
     */
    public float getSpeedX() {
        return speedX;
    }

    /**
     * @return the speedY
     */
    public float getSpeedY() {
        return speedY;
    }

    /**
     * @param speedX the speedX to set
     */
    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    /**
     * @param speedY the speedY to set
     */
    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }
    
}
