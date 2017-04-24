package com.util.scene;
import com.badlogic.ashley.core.Entity;
import com.engine.EngineBase;
import java.util.HashMap;

/**
 *
 * @author Jonathan Crockett
 */
public abstract class Scene{
    private final HashMap<Class<? extends Attribute>, Attribute> attributes = new HashMap<Class<? extends Attribute>, Attribute>();
    private HashMap<String, Entity> entities = new HashMap<String, Entity>();
    private HashMap<String, Boolean> isInEngine = new HashMap<String, Boolean>();

    protected abstract void loadResources();
    protected abstract void destroyResources();
    protected abstract void sceneMain();
    
    public void addAttribute(Attribute attr){
        attributes.put(attr.getClass(), attr);
    }
    
    public <AnyType extends Attribute> AnyType getAttribute(Class<AnyType> attr){
        return (AnyType) attributes.get(attr);
    }
    
    public boolean containsAttribute (Class<? extends Attribute> attr){
        return attributes.containsKey(attr);
    }
    
    public void removeAttribute(Class<? extends Attribute> attr){
        attributes.remove(attr);
    }
    
    public void putEntity(String key, Entity ent){
        entities.put(key, ent);
        isInEngine.put(key, false);
    }
    
    public boolean activateEntity(String key){
        if(entities.containsKey(key)){
            if(!isInEngine.get(key)){
                EngineBase.addEntity(entities.get(key));
                isInEngine.replace(key, true);
            }
            return true;
        }
        System.out.println("Scene: Cannot activate entity; entity '" + key + "' could not be found");
        return false;
    }
    
    public boolean disableEntity(String key){
        if(entities.containsKey(key)){
            if(isInEngine.get(key)){
                EngineBase.removeEntity(entities.get(key));
                isInEngine.replace(key, false);
            }
            return true;
        }
        System.out.println("Scene: Cannot disable entity; entity '" + key + "' could not be found");
        return false;
    }

    public boolean removeEntity(String key){
        if(entities.containsKey(key)){
            entities.remove(key);
            isInEngine.remove(key);
            return true;
        }
        System.out.println("Scene: Cannot remove entity; entity '" + key + "' could not be found");
        return false;
    }
    
    public Entity getEntity(String key){
        Entity ent = entities.get(key);
        
        if(ent == null) {
            System.out.println("Scene: Cannot get entity; entity '" + key + "' could not be found");
            ent = new Entity();
        }
        
        return ent;
    }
    
    public void disableEntities(){
        for(String key: entities.keySet()){
            if(isInEngine.get(key)){
                EngineBase.removeEntity(entities.get(key));
                isInEngine.replace(key, false);
            }
        }
    }
    
    public void removeEntities(){
        entities.clear();
        isInEngine.clear();
    }
}
