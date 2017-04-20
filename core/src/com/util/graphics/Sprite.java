/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.ArrayList;

public class Sprite{
    private int frameCount;
    
    private final Animation[] animation;
    private int animIndex = 0;
    private Object[] frames;
    private boolean looping = true;
    
    
    private float stateTime;
    
    public Sprite(TextureRegion sheet, int rows, int columns, int numberOfFrames, int fps, boolean seperateImages,  boolean shouldLoop){
        frameCount = numberOfFrames;
        TextureRegion[][] tmpTex = sheet.split(sheet.getRegionWidth()/columns, sheet.getRegionHeight()/rows);
        frames = new TextureRegion[frameCount];
        int index = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(index < frameCount){
                    frames[index] = tmpTex[i][j];
                    index++;
                }else break;
            }
        }
        
        if(seperateImages){
            animation = new Animation[numberOfFrames];
            for(int i = 0; i < frameCount; i++){
                animation[i] = new Animation(1.0f / fps, frames[i]);
            }
        }
        else{
            animation = new Animation[1];
            animation[0] = new Animation(1.0f / fps, frames);
        }
        
        
        stateTime = 0f;
        looping = shouldLoop;
        
        
    }
    
    public Sprite(TextureRegion sheet, int rows, int columns, int numberOfFrames, int fps){
        frameCount = numberOfFrames;
        TextureRegion[][] tmpTex = sheet.split(sheet.getRegionWidth()/columns, sheet.getRegionHeight()/rows);
        frames = new TextureRegion[frameCount];
        int index = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(index < frameCount){
                    frames[index] = tmpTex[i][j];
                    index++;
                }else break;
            }
        }
        
        animation = new Animation[1];
        animation[0] = new Animation(1.0f / fps, frames);
        stateTime = 0f;
        
    }
    
    public Sprite(TextureRegion tex){
        frames = new TextureRegion[1];
        frames[0] = tex;
        looping = true;
        animation = new Animation[1];
        animation[0] = new Animation(1.0f, frames);
        stateTime = 0f;
        frameCount = 1;
    }
    
    /**
     *
     * @param sheet
     * @param rows
     * @param columns
     * @param numberOfFrames
     * @param fps
     * @param idMatrix
     */
    public Sprite(TextureRegion sheet, int rows, int columns, int numberOfFrames, int fps, int[][] idMatrix){
        frameCount = numberOfFrames;
        TextureRegion[][] tmpTex = sheet.split(sheet.getRegionWidth()/columns, sheet.getRegionHeight()/rows);
        frames = new TextureRegion[frameCount];
        int index = 0;
        int max = idMatrix[0][0];
        
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(index < frameCount){
                    frames[index] = tmpTex[i][j];
                    if(idMatrix[i][j] > max){
                        max = idMatrix[i][j];
                    }
                    index++;
                }else break;
            }
        }
        max += 1;
        
        ArrayList<TextureRegion>[] tmpList = new ArrayList[max];
        
        for(int i = 0; i < max; i++){
            tmpList[i] = new ArrayList();
        }
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                tmpList[idMatrix[i][j]].add(tmpTex[i][j]);
            }
        }
        
        for(int i = 0; i < max; i++){
            tmpList[i].trimToSize();
        }
        
        animation = new Animation[max];
        for(int i = 0; i < max; i++){
            animation[i] = new Animation(1.0f / fps, tmpList[i].toArray(new TextureRegion[1]));
        }
        
        stateTime = 0f;
        
    }
    
    public void updateAnimation(){
        stateTime += Gdx.graphics.getDeltaTime();
    }
    
    public int getAnimationIndex(){
        return animIndex;
    }
    
    public void setAnimationIndex(int index){
        animIndex = index;
    }
    
    public TextureRegion getframeNumber(int frame){
        return (TextureRegion) frames[frame];
    }
    
    public TextureRegion getCurrentFrame(){
        return (TextureRegion) animation[animIndex].getKeyFrame(stateTime, looping);
    }
    
    public int getWidth(){
        return ((TextureRegion)frames[0]).getRegionWidth();
    }
    
    public int getHeight(){
        return ((TextureRegion)frames[0]).getRegionHeight();
    }
}
