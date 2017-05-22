package com.util.structures.saveable;

import com.util.structures.*;
import com.util.structures.nonsaveable.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan Crockett
 */
public class SaveableGrid<T extends SaveableData> extends Grid<T> implements SaveableStructure<T>{

    public SaveableGrid(int w, int h) {
        super(w, h);
    }

    @Override
    public boolean save(File file) {
        try {
            FileOutputStream fOut = new FileOutputStream(file);
            for(T[] x : grid){
                for(T data : x){
                    fOut.write(data.saveState());
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
            
            for(int x = 0; x < grid.length; x++){
                for(int y = 0; y < grid[x].length; y++){
                    if(fIn.available() > 0){
                        fIn.read(buffer);
                        T entry = func.createElement();
                        entry.loadState(buffer);
                        grid[x][y] = entry;
                    }
                }
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
