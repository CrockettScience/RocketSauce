package com.base.assets.components.general;
import com.badlogic.ashley.core.Component;
import com.base.assets.util.script.Script;

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