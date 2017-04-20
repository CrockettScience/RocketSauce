package com.util.input.processors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 *
 * @author Jonathan Crockett
 */
public abstract class AbstractMouseInputProcessor {
    
    private boolean leftPressed = false;
    private boolean rightPressed = false;
    
    void update(int i, boolean currentlyPressed){
        if(i == Input.Buttons.LEFT){
            if(currentlyPressed){
                if(!leftPressed){
                    buttonDown(i);
                }
                buttonPressed(i);
            }
            
            else if(leftPressed){
                buttonUp(i);
            }
            
            leftPressed = currentlyPressed;
        }
        
        else if(i == Input.Buttons.RIGHT){
            if(currentlyPressed){
                if(!rightPressed){
                    buttonDown(i);
                }
                buttonPressed(i);
            }
            
            else if(rightPressed){
                buttonUp(i);
            }
            
            rightPressed = currentlyPressed;
        }
    }
    
    public AbstractMouseInputProcessor(){
        if(SysMouseProcessor.activeProcessor == null)
            SysMouseProcessor.activeProcessor.add(this);
        else
            System.err.println("That's strange, a MouseProcessor was just created, but there is no engine system to process it. Did you make sure you added a SysMouseProcessor to the engine?");
    }
    
    public boolean buttonDown(int i){
        return false;
    }
    
    public boolean buttonPressed(int i){
        return Gdx.input.isButtonPressed(i);
    }
    
    public boolean buttonUp(int i){
        return false;
    }
    
}
