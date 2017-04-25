package com.util.script;

/**
 *
 * @author Jonathan Crockett
 */
public abstract class Script<Return extends ScriptReturn>{
    
    
    protected String scriptLog = "";
    
    protected abstract Return scriptMain();
    
    public final Return execute(){
        try{
            return scriptMain();
        }
        catch(Throwable e){
            System.out.println("Could not execute script '" + this + "'");
        }
        
        return null;
    }
    
    public abstract String toString();
    
}
