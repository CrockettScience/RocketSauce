package com.assets.components.general;
import com.badlogic.ashley.core.Component;
import com.util.input.Script;

/**
 *
 * @author Jonathan Crockett
 */
public class ComFunction implements Component{
    private Script function;

    /**
     * @param function the function to set
     */
    public void setFunction(Script function) {
        this.function = function;
    }
    
    public void executeFunction(){
        if(function != null){
           function.execute();
        }
    }

}
