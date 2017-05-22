package com.util.input.core;

import com.util.structures.nonsaveable.Map;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Jonathan Crockett
 */
public class InputDispatcher {
    
    private static LinkedList<InputListener> listeners = new LinkedList<InputListener>();
    private static InputAlias aliases;
    
    protected static void dispatchEvent(InputEvent event){
        Iterator<InputListener> i = listeners.iterator();
        
        if(!event.aliased)
            alias(event);

        while(i.hasNext()){
            i.next().inputReceived(event);
        }
    }
    
    public static void setDevice(InputDevice dev){
        dev.activateDevice();
    }
    
    private static void alias(InputEvent event){
        String alias = aliases == null ? null : aliases.aliases.get(event.getIdentifier());
        
        if(alias != null && !alias.equals(event.getIdentifier())){
            
            event.aliased = true;
            dispatchEvent(event);
            event.identifier = alias;
        }
    }
    
    public static void bind(InputListener listener){
        listeners.add(listener);
    }
    
    public static void unbind(InputListener listener){
        listeners.remove(listener);
    }
    
    public static void setAliases(InputAlias a){
        aliases = a;
    }
    
    public static abstract class InputAlias{
        protected Map<String, String> aliases = new Map<String, String>();
    }
    
}
