package com.assets.scripts;

import com.util.script.Argument;
import com.util.script.Script;
import com.util.script.Return;

/**
 *
 * @author Jonathan Crockett
 */
public class ScrVoid extends Script{
    
    @Override
    public Return scriptMain(Argument args){
        return null;
    }

    @Override
    public String toString() {
        return "VOID";
    }
    
}
