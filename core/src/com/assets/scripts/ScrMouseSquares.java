package com.assets.scripts;

import com.assets.scripts.arguments.ArgsDraw;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.util.GLPrimitives;
import com.util.Tools;
import com.util.script.Return;
import com.util.script.Script;

/**
 *
 * @author Jonathan Crockett
 */
public class ScrMouseSquares extends Script<ArgsDraw, Return> {
    private float x = 0;
    private float y = 0;
    
    
    @Override
    protected Return scriptMain(ArgsDraw args) {
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            if(x == 0){
                x = Tools.getMouseX();
                y = Tools.getMouseY();
            }
            GLPrimitives.drawRectangle(x, y, Tools.getMouseX() - x, Tools.getMouseY() - y);
        }
        else if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
            if(x == 0){
                x = Tools.getMouseX();
                y = Tools.getMouseY();
            }
            GLPrimitives.drawRectangleFilled(x, y, Tools.getMouseX() - x, Tools.getMouseY() - y);
        }
        else{
            x = 0;
            y = 0;
        }
        
        return null;
    }

    @Override
    public String toString() {
        return "ScrMouseSquare";
    }
    
}
