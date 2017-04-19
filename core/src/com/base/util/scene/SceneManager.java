package com.base.util.scene;

import com.base.util.scene.View;
import com.base.util.scene.Scene;

public class SceneManager{
        
    private static Scene scene;
    private static View view;

    public static Scene getScene() {
        return scene;
    }
    
    public static View getView() {
        return view;
    }
    public static void setScene(Scene aScene) {
        if(scene != null){
            scene.destroyResources();
        }
        
        scene = aScene;
        scene.loadResources();
    }
    
    public static void setView(View aView) {
        view = aView;
    }
}
