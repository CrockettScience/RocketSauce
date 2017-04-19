package com.base.assets.util.script;

public abstract class Script{
    
    protected String scriptLog;
    
    protected abstract void scriptMain();
    
    public final void execute(){
        try{
            scriptMain();
        }
        catch(Throwable e){
            System.out.println("Could not execute script '" + this + "'");
            e.printStackTrace();
        }
    }
    
    public abstract String toString();
    
}
