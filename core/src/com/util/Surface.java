package com.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.glutils.GLFrameBuffer;
import com.badlogic.gdx.graphics.glutils.GLOnlyTextureData;

/**
 *
 * @author Jonathan Crockett
 */
public class Surface extends GLFrameBuffer {
    private GLFrameBuffer surface;
    
    public Surface(int width, int height){
        super(Pixmap.Format.RGBA8888, width, height, false);
    }
    
    public void setTarget(){
        surface.bind();
    }
    
    public void returnTarget(){
        GLFrameBuffer.unbind();
    }
    
    public void dispose(){
        surface.dispose();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        dispose();
    }

    @Override
    protected GLTexture createColorTexture() {
        int glFormat = Pixmap.Format.toGlFormat(format);
        int glType = Pixmap.Format.toGlType(format);
	GLOnlyTextureData data = new GLOnlyTextureData(width, height, 0, glFormat, glFormat, glType);
	Texture result = new Texture(data);
	result.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	result.setWrap(TextureWrap.ClampToEdge, TextureWrap.ClampToEdge);
        return result;
    }

    @Override
    protected void disposeColorTexture(GLTexture t) {
        colorTexture.dispose();
    }

    @Override
    protected void attachFrameBufferColorTexture() {
        Gdx.gl20.glFramebufferTexture2D(GL20.GL_FRAMEBUFFER, GL20.GL_COLOR_ATTACHMENT0, GL20.GL_TEXTURE_2D, colorTexture.getTextureObjectHandle(), 0);
    }
}
