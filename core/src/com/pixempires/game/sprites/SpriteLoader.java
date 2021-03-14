package com.pixempires.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Islevi daha sonra belirlenecek.
 */
public class SpriteLoader {
    private Texture texture_of_sprite;
    private TextureRegion[] sprite;
    private int frameCount;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frame;


    public SpriteLoader(Texture texture_of_sprit){
        this.texture_of_sprite=texture_of_sprit;
    }
    public void update(float delta){
        currentFrameTime+=delta;
        if(currentFrameTime > maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }
        if(frame >= frameCount)
            frame = 0;
    }

    public SpriteLoader Split1D(int begin_x,int begin_y,int width,int height,int frameCount,int space_x_frame){
        this.frameCount=frameCount;
        sprite=new TextureRegion[frameCount];
        maxFrameTime=.5f/frameCount;
        for (int i=0; i<frameCount;i++){
            sprite[i]=new TextureRegion(texture_of_sprite,begin_x,begin_y,width,height);
            if(space_x_frame==0){
                begin_x+=width;
            }else{
                begin_x=i*space_x_frame;
            }
        }
        return this;
    }
    public SpriteLoader circleTime(float circle_time){
        if (frameCount==0)
            return this;
        maxFrameTime=circle_time/frameCount;
        return this;
    }
    public TextureRegion getFrame(){
        return sprite[frame];
    }
}
