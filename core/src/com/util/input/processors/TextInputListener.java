package com.util.input.processors;

import com.badlogic.gdx.Input;
import com.util.input.core.InputEvent;
import com.util.input.core.InputListener;
import com.util.input.devices.InputDeviceKeyboard;

/**
 *
 * @author Jonathan Crockett
 */
public class TextInputListener implements InputListener{
    
    private boolean shift = false;
    private String text = "";

    @Override
    public void inputReceived(InputEvent event) {
        if(event.getDeviceSender() instanceof InputDeviceKeyboard){
            if(event.getIdentifier().equals("key press")){
                if(event.getMagnitude() == Input.Keys.SHIFT_LEFT || event.getMagnitude() == Input.Keys.SHIFT_RIGHT)
                    shift = true;
            }
            else if(event.getIdentifier().equals("key release")){
                if(event.getMagnitude() == Input.Keys.SHIFT_LEFT || event.getMagnitude() == Input.Keys.SHIFT_RIGHT)
                    shift = false;
            }
            else{
                String letter = event.getIdentifier();
                if(!letter.equals("\n") && !letter.equals("\t")){
                    if(shift)
                        letter = letter.toUpperCase();
                    text += letter;
                }
            }
        }
        
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
