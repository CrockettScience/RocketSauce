package com.util.structures.saveable;

import com.util.structures.saveable.util.*;
import com.util.structures.nonsaveable.Set;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan Crockett
 */
public class SaveableSet<T extends SaveableData> extends Set<T> implements SaveableStructure<T>{
    
    @Override
    public boolean save(File file) {
        try {
            FileOutputStream fOut = new FileOutputStream(file);
            for(SetEntry<T> x : mapTable){
                SetEntry<T> entry = x;
                while(entry != null){
                    fOut.write(entry.element.saveState());
                    entry = entry.next;
                }
            }
            
            fOut.close();
            return true;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveableMap.class.getName()).log(Level.WARNING, file.toString(), ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(SaveableMap.class.getName()).log(Level.WARNING, "Could not save: an unexpected error has occurred", ex);
            return false;
        }
    }

    @Override
    public boolean load(File file, CreateData<T> func) {
        try {
            FileInputStream fIn = new FileInputStream(file);
            byte[] buffer = new byte[func.createElement().byteSize()];
            
            while(fIn.available() > 0){
                fIn.read(buffer);
                T entry = func.createElement();
                entry.loadState(buffer);
                add(entry);
            }
            
            fIn.close();
            return true;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SaveableMap.class.getName()).log(Level.WARNING, file.toString(), ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(SaveableMap.class.getName()).log(Level.WARNING, "Could not load: an unexpected error has occurred", ex);
            return false;
        }
    }
}
