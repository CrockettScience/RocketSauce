package com.assets.components.general;
import com.badlogic.ashley.core.Component;

public class ComVelocity implements Component {
    private float x = 0.0f;
    private float y = 0.0f;

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
