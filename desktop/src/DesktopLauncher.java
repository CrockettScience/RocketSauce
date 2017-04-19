

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.base.engine.EngineApplication;

public class DesktopLauncher {
    
    public static final String GAME_TITLE = "RocketSauce";
    
    public static void main (String[] arg){
            Initialize.setup(GAME_TITLE);
            Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

            if(Initialize.isFullscreen()){
                config.setFullscreenMode(Initialize.getFullscreenDisplayMode());
                config.useVsync(true);
            }else{
                config.setWindowedMode(Initialize.getWindowedWidth(), Initialize.getWindowedHeight());

            }
            config.setResizable(false);
            config.setTitle(GAME_TITLE);

            new Lwjgl3Application(new EngineApplication(Initialize.getIni()), config);
    }
}
