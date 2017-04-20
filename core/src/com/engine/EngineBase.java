package com.engine;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.SortedIteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.utils.Align;
import com.assets.attributes.AttBoundary;
import com.assets.attributes.AttParallax;
import com.assets.components.general.ComLabel;
import com.assets.components.general.ComPosition;
import com.assets.components.general.ComSprite;
import com.global.ComponentMap;
import com.util.scene.SceneManager;
import com.util.Tools;
import com.util.scene.View;
import java.util.Comparator;
import com.assets.util.EngineSystem;

public class EngineBase {
    private static final SpriteBatch BATCH = new SpriteBatch();
    private static final Engine ENGINE = new Engine();
    private static FrameBuffer fbo = new FrameBuffer(Pixmap.Format.RGBA8888, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);
    
    protected static void initialize(int engineCapacity) {
        
        EntitySystem sys;
        
        sys = new PreDraw(BATCH);
        sys.priority = engineCapacity;
        ENGINE.addSystem(sys);
        
        sys = new Draw(BATCH);
        sys.priority = ++engineCapacity;
        ENGINE.addSystem(sys);
        
        sys = new PostDraw(BATCH);
        sys.priority = ++engineCapacity;
        ENGINE.addSystem(sys);
    }
    
    public static void addEntity(Entity ent){
        ENGINE.addEntity(ent);
    }
    
    public static void addSystem(EngineSystem sys){
        ENGINE.addSystem(sys);
    }
    
    public static ImmutableArray<Entity> getEntities(){
        return ENGINE.getEntities();
    }
    
    public static ImmutableArray<Entity> getEntitiesFor(Family fam){
        return ENGINE.getEntitiesFor(fam);
    }
    
    public static <T extends EngineSystem> T getSystem(Class<T> sysType){
        return ENGINE.getSystem(sysType);
    }
    
    public static void removeAllEntities(){
        ENGINE.removeAllEntities();
    }
    
    public static void removeEntity(Entity ent){
        ENGINE.removeEntity(ent);
    }
    
    public static void removeSystem(EngineSystem sys){
        ENGINE.removeSystem(sys);
    }
    
    public static void update(float delta){
        ENGINE.update(delta);
    }
    
    public static void resizeFrameBuffer(int width, int height){
        fbo.dispose();
        fbo = new FrameBuffer(Pixmap.Format.RGBA8888, width, height, false);
    }

    public static FrameBuffer getFbo() {
        return fbo;
    }

    public static void setFbo(FrameBuffer aFbo) {
        fbo = aFbo;
    }
    

    public static class PreDraw extends EntitySystem {
        SpriteBatch batch;

        public PreDraw(SpriteBatch b){
            batch = b;
            
            //initialize our viewport
            SceneManager.setView(new View(0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), 0, 0));
            EntitySystem sys;
        }

        public void update(float deltaTime) {
            updateView();
            beginDraw();
            backgroundUpdate();
        }

        private void updateView() {
            View view = SceneManager.getView();
            ComPosition pos = view.getEntityFollowingPosition();

            if(pos != null){
                float entViewX = pos.getX() - view.getX();
                float entViewY = pos.getY() - view.getY();

                if(entViewX < view.getXBufferZone()){
                    view.setX(pos.getX() - view.getXBufferZone());
                }else if(entViewX > view.getWidth() - view.getXBufferZone()){
                    view.setX(pos.getX() - (view.getWidth() - view.getXBufferZone()));
                }

                if(entViewY < view.getYBufferZone()){
                    view.setY(pos.getY() - view.getYBufferZone());
                }else if(entViewY > view.getHeight() - view.getYBufferZone()){
                    view.setY(pos.getY() - (view.getHeight() - view.getYBufferZone()));
                }
            }
            if(SceneManager.getScene().containsAttribute(AttBoundary.class)){
                AttBoundary bound = SceneManager.getScene().getAttribute(AttBoundary.class);

                if(view.getX() < 0){
                    view.setX(0);
                }else if(view.getX() + view.getWidth() > bound.width){
                    view.setX(bound.width - view.getWidth());
                }

                if(view.getY() < 0){
                    view.setY(0);
                }else if(view.getY() + view.getHeight() > bound.height){
                    view.setY(bound.height - view.getHeight());
                }
            }
        }

        private void beginDraw() {
            View v = SceneManager.getView();

            batch.setProjectionMatrix(v.getViewport().getCamera().combined);

            //keep fbo in sync with the view
            if(fbo.getWidth() != (int) Gdx.graphics.getWidth() || fbo.getHeight() != (int) Gdx.graphics.getHeight()){
                EngineBase.resizeFrameBuffer((int) Gdx.graphics.getWidth(), (int) Gdx.graphics.getHeight());
            }
        }

        private void backgroundUpdate() {
            if(SceneManager.getScene().containsAttribute(AttParallax.class)){
                fbo.bind();
                batch.begin();

                if(SceneManager.getScene().getAttribute(AttParallax.class).background_0 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).background_0.updateTexture(batch);
                }
                if(SceneManager.getScene().getAttribute(AttParallax.class).background_1 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).background_1.updateTexture(batch);
                }
                if(SceneManager.getScene().getAttribute(AttParallax.class).background_2 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).background_2.updateTexture(batch);
                }
                if(SceneManager.getScene().getAttribute(AttParallax.class).background_3 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).background_3.updateTexture(batch);
                }
                if(SceneManager.getScene().getAttribute(AttParallax.class).background_4 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).background_4.updateTexture(batch);
                }
                if(SceneManager.getScene().getAttribute(AttParallax.class).background_5 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).background_5.updateTexture(batch);
                }
                if(SceneManager.getScene().getAttribute(AttParallax.class).background_6 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).background_6.updateTexture(batch);
                }
                if(SceneManager.getScene().getAttribute(AttParallax.class).background_7 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).background_7.updateTexture(batch);
                }
                if(SceneManager.getScene().getAttribute(AttParallax.class).background_8 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).background_8.updateTexture(batch);
                }
                if(SceneManager.getScene().getAttribute(AttParallax.class).background_9 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).background_9.updateTexture(batch);
                }

                batch.end();
                fbo.unbind();
            }
        }

    }
    
    public static class Draw extends SortedIteratingSystem {
        private SpriteBatch batch;

        public Draw(SpriteBatch b){
            super(Family.all(ComPosition.class, ComSprite.class).get(), new ZComparator());
            batch = b;
        }

        /**
         *
         * @param ent
         * @param deltaTime
         */
        public void processEntity(Entity ent, float deltaTime){
            View v = SceneManager.getView();

            ComSprite sprite = ComponentMap.SPRITE.get(ent);
            ComPosition pos = ComponentMap.POSITION.get(ent);

            sprite.getSprite().updateAnimation();

            fbo.bind();
            batch.begin();

            if(!Tools.outOfSight(pos, v)){
                batch.draw(sprite.getSprite().getCurrentFrame(),
                        (pos.getX() - v.getX()) - (sprite.getOffsetX() * sprite.getScaleX()),
                        (pos.getY() - v.getY()) - (sprite.getOffsetY() * sprite.getScaleY()),
                        (sprite.getSprite().getWidth() * sprite.getScaleX()),
                        (sprite.getSprite().getHeight() * sprite.getScaleY()));

            }
            ComLabel label = ComponentMap.LABEL.get(ent);
            if(label != null){
                GlyphLayout text = new GlyphLayout();
                String str = label.getLabel();

                int hor;

                switch(label.getHAlign()){
                    case LEFT:
                        hor = Align.left;
                        break;
                    case CENTER:
                        hor = Align.center;
                        break;
                    default:
                        hor = Align.right;
                }

                text.setText(label.getFont(), str, label.getColor(), sprite.getSprite().getWidth(), hor, true);

                label.getFont().draw(batch, text, (pos.getX() - sprite.getOffsetX()) + label.getX(), (pos.getY() - sprite.getOffsetY()) + label.getY());
            }

            batch.end();
            fbo.unbind();
        }

        private static class ZComparator implements Comparator<Entity> {
            @Override
            public int compare(Entity e1, Entity e2) {
                return ((Integer) ComponentMap.POSITION.get(e1).getZ()).compareTo((Integer) ComponentMap.POSITION.get(e2).getZ());
                
            }
        }
    }
    
    public static class PostDraw extends EntitySystem {
        SpriteBatch batch;
        
        /**
         *
         * @param b
         */
        public PostDraw(SpriteBatch b) {
            batch = b;
        }
        
        public void update(float deltaTime) {
            foregroundUpdate();
            swapBuffer();
            drawGUI();
        }
        
        private void foregroundUpdate() {
            if(SceneManager.getScene().containsAttribute(AttParallax.class)){
                fbo.bind();
                batch.begin();
                if(SceneManager.getScene().getAttribute(AttParallax.class).foreground_0 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).foreground_0.updateTexture(batch);
                }
                if(SceneManager.getScene().getAttribute(AttParallax.class).foreground_1 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).foreground_1.updateTexture(batch);
                }
                if(SceneManager.getScene().getAttribute(AttParallax.class).foreground_2 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).foreground_2.updateTexture(batch);
                }
                if(SceneManager.getScene().getAttribute(AttParallax.class).foreground_3 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).foreground_3.updateTexture(batch);
                }
                if(SceneManager.getScene().getAttribute(AttParallax.class).foreground_4 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).foreground_4.updateTexture(batch);
                }
                if(SceneManager.getScene().getAttribute(AttParallax.class).foreground_5 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).foreground_5.updateTexture(batch);
                }
                if(SceneManager.getScene().getAttribute(AttParallax.class).foreground_6 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).foreground_6.updateTexture(batch);
                }
                if(SceneManager.getScene().getAttribute(AttParallax.class).foreground_7 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).foreground_7.updateTexture(batch);
                }
                if(SceneManager.getScene().getAttribute(AttParallax.class).foreground_8 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).foreground_8.updateTexture(batch);
                }
                if(SceneManager.getScene().getAttribute(AttParallax.class).foreground_9 != null){
                    SceneManager.getScene().getAttribute(AttParallax.class).foreground_9.updateTexture(batch);
                }
                batch.end();
                fbo.unbind();
            }

        }
        
        private void swapBuffer() {
            TextureRegion fboRegion = new TextureRegion(fbo.getColorBufferTexture());
            fboRegion.flip(false, true);

            batch.begin();
            batch.draw(fboRegion, 0, 0, SceneManager.getView().getWidth(), SceneManager.getView().getHeight());
            batch.end();
        }
        
        private void drawGUI() {
            
        }
        
    }
}
