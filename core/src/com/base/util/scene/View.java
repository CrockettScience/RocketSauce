package com.base.util.scene;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.base.global.BaseComponentMap;
import com.base.assets.components.general.ComPosition;

public class View{

    private FitViewport viewport;
    private OrthographicCamera cam = new OrthographicCamera();
    private float x;
    private float y;
    private float width;
    private float height;

    private Entity entityFollowing;
    private float xBufferZone;
    private float yBufferZone;

    public View(float aX, float aY, float aWidth, float aHeight, float xBuff, float yBuff) {
        viewport = new FitViewport(aWidth, aHeight, cam);
        cam.position.set(aWidth/2, aHeight/2, 0);
        x = aX;
        y = aY;
        width = aWidth;
        height = aHeight;
        xBufferZone = xBuff;
        yBufferZone = yBuff;
        viewport.apply();
    }

    public void resize(float newWidth, float newHeight) {
        width = newWidth;
        height = newHeight;
        viewport.setWorldSize(newWidth, newHeight);
        cam.position.set(newWidth / 2, newHeight / 2, 0);
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @return the width
     */
    public float getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public float getHeight() {
        return height;
    }

    public FitViewport getViewport() {
        return viewport;
    }

    public void followEntity(Entity ent) {
        if (BaseComponentMap.POSITION.get(ent) == null) {
            System.out.println("WARNING: The view attempted to follow an entity that does not have a position");
        } else {
            entityFollowing = ent;
        }
    }

    public ComPosition getEntityFollowingPosition() {
        if (entityFollowing == null) {
            return null;
        } else {
            return BaseComponentMap.POSITION.get(entityFollowing);
        }
    }

    public Entity getEntityFollowing() {
        return entityFollowing;
    }

    /**
     *
     * @param xBuff
     * @param yBuff
     */
    public void setBufferZone(float xBuff, float yBuff) {
        xBufferZone = xBuff;
        yBufferZone = yBuff;
    }

    public float getXBufferZone() {
        return xBufferZone;
    }

    public float getYBufferZone() {
        return yBufferZone;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }
}
