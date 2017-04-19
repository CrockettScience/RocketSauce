package com.base.util.scene;
import com.badlogic.ashley.core.Entity;
import com.base.engine.EngineBase;
import java.util.HashMap;

public abstract class Scene{
    private final HashMap<Class<? extends Attribute>, Attribute> attributes = new HashMap<Class<? extends Attribute>, Attribute>();
    private HashMap<String, Entity> entities = new HashMap<String, Entity>();
    private HashMap<String, Boolean> isInEngine = new HashMap<String, Boolean>();

    protected abstract void loadResources();
    protected abstract void destroyResources();
    
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
    
    public void activateEntity(String key){
        if(entities.containsKey(key)){
            if(!isInEngine.get(key)){
                EngineBase.addEntity(entities.get(key));
                isInEngine.replace(key, true);
            }
        }
    }
    
    /**
     *
     * @param key
     */
    public void disableEntity(String key){
        if(entities.containsKey(key)){
            if(isInEngine.get(key)){
                EngineBase.removeEntity(entities.get(key));
                isInEngine.replace(key, false);
            }
        }
    }

    public void removeEntity(String key){
        if(entities.containsKey(key)){
            entities.remove(key);
            isInEngine.remove(key);
        }
    }
    
    public Entity getEntity(String key){
        return entities.get(key);
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
