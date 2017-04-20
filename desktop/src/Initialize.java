

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import java.nio.file.*;
import com.util.Ini;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Graphics;

public class Initialize{
    private static Path Gamepath;
    private static int wDisplayWidth;
    private static int wDisplayHeight;
    private static Lwjgl3Graphics.DisplayMode fDisplay;
    private static boolean fullscreen;
    private static boolean usesController;
    
    private static Ini iniFile;
    
    //finish after creating ini read/write class
    public static void setup(String gameTitle){
        //set up constants
        Gamepath = Paths.get(System.getProperty("user.home"), gameTitle);
        
        //initialize settings
        iniFile = new Ini(Gamepath, gameTitle);
        if(iniFile.isEmpty()){
            initializeSettings();
        }
        
        fullscreen = iniFile.readBool("DISPLAY", "Fullscreen", false);
        fDisplay = findCompatibleDisplayMode(iniFile.readInt("DISPLAY", "FullscreenWidth", 1024),iniFile.readInt("DISPLAY", "FullscreenHeight", 768));
        wDisplayWidth = iniFile.readInt("DISPLAY", "WindowedWidth", 1024);
        wDisplayHeight = iniFile.readInt("DISPLAY", "WindowedHeight", 768);
        setUsesController(!iniFile.read("CONTROLS", "ControllerID", "Mouse & Keyboard").equals("Mouse & Keyboard"));
        
    }
    
    private static void initializeSettings(){
        //default display is the display of the desktop
        Lwjgl3Graphics.DisplayMode defDisplay = Lwjgl3ApplicationConfiguration.getDisplayMode(Lwjgl3ApplicationConfiguration.getPrimaryMonitor());
        int wWidth  = defDisplay.width;
        int wHeight = defDisplay.height;
        
        Lwjgl3Graphics.DisplayMode fullDisplay = findCompatibleDisplayMode(wWidth, wHeight);
        int fWidth = fullDisplay.width;
        int fHeight = fullDisplay.height;
        
        //save settings to ini
        iniFile.write("CONTROLS", "ControllerID", "Mouse & Keyboard");
        
        iniFile.write("DISPLAY", "WindowedWidth", String.valueOf(wWidth));
        iniFile.write("DISPLAY", "WindowedHeight", String.valueOf(wHeight));
        iniFile.write("DISPLAY", "FullscreenWidth", String.valueOf(fWidth));
        iniFile.write("DISPLAY", "FullscreenHeight", String.valueOf(fHeight));
        iniFile.write("DISPLAY", "Fullscreen", "false");
        iniFile.save();
    }
    
    public static Ini getIni(){
        return iniFile;
    }
    
    public static int getWindowedWidth(){
        return wDisplayWidth;
    }
    
    public static int getWindowedHeight(){
        return wDisplayHeight;
    }
    
    public static Lwjgl3Graphics.DisplayMode getFullscreenDisplayMode(){
        return fDisplay;
    }
    
    public static boolean isFullscreen(){
        return fullscreen;
    }
    
    public static Path getGamePath(){
        return Gamepath;
    }
    
    public static void setWindowedDisplay(int width, int height){
        wDisplayWidth = width;
        wDisplayHeight = height;
    }
    
    public static void setFullscreenDisplayMode(int width, int height){
        fDisplay = findCompatibleDisplayMode(width, height);
    }
    
    public static void setFullscreen(boolean bool){
        fullscreen = bool;
    }
    
    private static Lwjgl3Graphics.DisplayMode findCompatibleDisplayMode(int width, int height){
        //Will return a compatible DisplayMode if it exists
        Lwjgl3Graphics.DisplayMode[] modes = Lwjgl3ApplicationConfiguration.getDisplayModes();
        Lwjgl3Graphics.DisplayMode displayMode = modes[0];
        
        for (Lwjgl3Graphics.DisplayMode mode : modes) {
            if (mode.width == width && mode.height == height) {
                return mode;
            }
        }
        
        return displayMode;
    }

    public static boolean isUsesController() {
        return usesController;
    }

    public static void setUsesController(boolean aUsesController) {
        usesController = aUsesController;
    }
    
}
