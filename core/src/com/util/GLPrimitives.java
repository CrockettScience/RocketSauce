package com.util;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.util.scene.SceneManager;

/**
 *
 * @author Jonathan Crockett
 */
public class GLPrimitives {
    private static final ShapeRenderer render = new ShapeRenderer();
    
    public static void setColor(float red, float green, float blue, float alpha){
        render.setColor(red, green, blue, alpha);
    }
    
    public static void setColor(Color c, float alpha){
        float r;
        float g;
        float b;
        
        switch(c){
            case BLACK:
                r = 0;
                g = 0;
                b = 0;
                break;
            case WHITE:
                r = 1;
                g = 1;
                b = 1;
                break;
            case RED:
                r = 1;
                g = 0;
                b = 0;
                break;
            case LIME:
                r = 0;
                g = 1;
                b = 0;
                break;
            case BLUE:
                r = 0;
                g = 0;
                b = 1;
                break;
            case YELLOW:
                r = 1;
                g = 1;
                b = 0;
                break;
            case CYAN:
                r = 0;
                g = 1;
                b = 1;
                break;
            case MAGENTA:
                r = 1;
                g = 0;
                b = 1;
                break;
            case SILVER:
                r = 0.75f;
                g = 0.75f;
                b = 0.75f;
                break;
            case GRAY:
                r = 0.5f;
                g = 0.5f;
                b = 0.5f;
                break;
            case MAROON:
                r = 0.5f;
                g = 0;
                b = 0;
                break;
            case OLIVE:
                r = 0.5f;
                g = 0.5f;
                b = 0;
                break;
            case GREEN:
                r = 0;
                g = 0.5f;
                b = 0;
                break;
            case PURPLE:
                r = 0.5f;
                g = 0;
                b = 0.5f;
                break;
            case TEAL:
                r = 0;
                g = 0.5f;
                b = 0.5f;
                break;
            case NAVY:
                r = 0;
                g = 0;
                b = 0.5f;
                break;
            
            default:
                r = 0;
                g = 0;
                b = 0;
        }
        render.setColor(r, g, b, alpha);
    }
    
    public static void drawLine(float x1, float y1, float x2, float y2){
        render.setProjectionMatrix(SceneManager.getView().getViewport().getCamera().combined);
        render.begin(ShapeRenderer.ShapeType.Line);
            
            render.line(x1, y1, x2, y2);
            
        render.end();
    }
    
    public static void drawRectangleFilled(float x, float y, float width, float height){
        render.setProjectionMatrix(SceneManager.getView().getViewport().getCamera().combined);
        render.begin(ShapeRenderer.ShapeType.Filled);
        
            render.rect(x, y, width, height);
            
        render.end();
    }
    
    public static void drawRectangle(float x, float y, float width, float height){
        render.setProjectionMatrix(SceneManager.getView().getViewport().getCamera().combined);
        render.begin(ShapeRenderer.ShapeType.Line);
        
            render.rect(x, y, width, height);
            
        render.end();
    }
    
    public static enum Color {
        BLACK, WHITE, RED, LIME, BLUE, YELLOW, CYAN, MAGENTA, SILVER, GRAY, MAROON, OLIVE, GREEN, PURPLE, TEAL, NAVY
    }
        
}
    
    
