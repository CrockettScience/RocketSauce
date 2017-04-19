package com.base.assets.components.general;
import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class ComLabel implements Component {
    private String label = "";
    private BitmapFont font = new BitmapFont();
    private HAlignment hAlign = HAlignment.LEFT;
    private float x = 0;
    private float y = 0;
    private Color color = Color.WHITE;
    
    public static enum HAlignment{
        LEFT, RIGHT, CENTER
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the font
     */
    public BitmapFont getFont() {
        return font;
    }

    /**
     * @param font the font to set
     */
    public void setFont(BitmapFont font) {
        this.font = font;
    }

    /**
     * @return the hAlign
     */
    public HAlignment getHAlign() {
        return hAlign;
    }

    /**
     * @param hAlign the hAlign to set
     */
    public void setHAlign(HAlignment hAlign) {
        this.hAlign = hAlign;
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

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

}
