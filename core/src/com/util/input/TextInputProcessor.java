package com.util.input;

import com.util.input.processors.AbstractInputProcessor;
import com.badlogic.gdx.Input;

/**
 *
 * @author Jonathan Crockett
 */
public class TextInputProcessor extends AbstractInputProcessor{
    private boolean shift = false;
    private String text = "";
    
    public boolean keyDown(int i){
        if(i == Input.Keys.SHIFT_LEFT || i == Input.Keys.SHIFT_RIGHT){
            shift = true;
            return true;
        }
        return false;
    }

    public boolean keyUp(int i) {
        if(i == Input.Keys.SHIFT_LEFT || i == Input.Keys.SHIFT_RIGHT){
            shift = false;
            return true;
        }
        return false;
    }

    public boolean keyTyped(char c){
        String letter = String.valueOf(c);
        if(!letter.equals("\n") && !letter.equals("\t")){
            if(shift)
                letter = letter.toUpperCase();
            text += letter;
        }
        return true;
    }
    
    public String returnText(){
        String returnText = text;
        text = "";
        return returnText;
    }
    
    public String peekText(){
        return text;
    }
}
