package com.util.input.core;

/**
 *
 * @author Jonathan Crockett
 */
public class InputEvent {
    String identifier;
    private int magnitude;
    private InputDevice sender;
    boolean aliased;
    private boolean aliasable;
    
    public InputEvent(String id, int mag, InputDevice source){
        identifier = id;
        magnitude  = mag;
        sender = source;
    }
    
    public String getIdentifier(){
        return identifier;
    }
    
    public int getMagnitude(){
        return magnitude;
    }
    
    public InputDevice getDeviceSender(){
        return sender;
    }
    
    public boolean isAlias(){
        return aliased;
    }
}
