package com.pixempires.game.animations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

/**
 * Islevi daha sonra belirlenecek.
 */
public class Animation {
    private Texture texture_of_sprite;
    private TextureRegion[] sprite;
    private int frameCount;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frame;
    private Vector2 position=new Vector2().setZero();
    private Vector2 scale=new Vector2().setZero();

    private boolean isLastFrame;


    public Animation(Texture texture_of_sprit){
        this.texture_of_sprite=texture_of_sprit;
    }
    public void render(SpriteBatch sprite_batch){
        sprite_batch.begin();
        sprite_batch.draw(sprite[frame],getPosition().x,getPosition().y);
        sprite_batch.end();
    }
    public void update(float delta){
        currentFrameTime+=delta;
        if(currentFrameTime > maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }


        if(frame >= frameCount){
           //son sprite çalışır.
            System.out.println(frame);
            isLastFrame=true;
            frame = 0;
        }else{
            isLastFrame=false;
        }

    }

    /**
     * Texture'de bulunan gorselleri x eksenine göre parcalar.
     * @param begin_x Texture,baslangic x noktası
     * @param begin_y Texture, baslangıc y noktası
     * @param width  goruntunun genisligi
     * @param height goruntunun yuksekligi
     * @param frameCount goruntu icerisinde kaç adet resim varsa sayısı girilir.
     * @param space_x_frame bazı durumlarda her frame arasında fazladan bosluklar olusabilir.
     *                      Eger fazladan bosluk yoksa 0 degerini atayınız,fazladan bosluk varsa degerini giriniz.
     * @return
     */
    public Animation Split1D(int begin_x, int begin_y, int width, int height, int frameCount, int space_x_frame){
        this.frameCount=frameCount;
        sprite=new TextureRegion[frameCount];
        int keep_begin_x=begin_x;
        maxFrameTime=.5f/frameCount;
        for (int i=0; i<frameCount;i++){
            sprite[i]=new TextureRegion(texture_of_sprite,begin_x,begin_y,width,height);
            if(space_x_frame==0){
                begin_x+=width;
            }else{
                begin_x=i*space_x_frame+keep_begin_x;
            }
        }
        return this;
    }

    /**
     * Metod test edilmedi fakat dogru calistigindan eminim :)
     * @param begin_x Texture'de baslangic x
     * @param begin_y Texture'de baslangic y
     * @param width goruntunun genisligi
     * @param height goruntunun yuksekligi
     * @param frameCount_x x ekseninde goruntu sayısı
     * @param frameCount_y y ekseninde goruntusu sayısı
     * @return
     */
    public Animation Split2D(int begin_x, int begin_y, int width, int height, int frameCount_x, int frameCount_y){
        this.frameCount=frameCount_x+frameCount_y;
        sprite=new TextureRegion[frameCount];
        maxFrameTime=.5f/frameCount;
        int counter_frameCount_x=0;
        int counter_frameCount_y=0;
        for (int i=0; i<frameCount;i++){
            sprite[i]=new TextureRegion(texture_of_sprite,begin_x,begin_y,width,height);
            if(frameCount_x>counter_frameCount_x){
                begin_x+=width;
                counter_frameCount_x++;
            }else{
                if(frameCount_y>counter_frameCount_y){
                    counter_frameCount_y++;
                    begin_x-=width*counter_frameCount_x; //eski durumuna geri döner.
                    begin_y+=height;
                }

                counter_frameCount_x=0;
            }
        }
        return this;
    }

    /**
     * Frame dongusunun tamamlanacagı sureyi belirler
     * @param circle_time
     * @return
     */
    public Animation circleTime(float circle_time){
        if (frameCount==0)
            return this;
        maxFrameTime=circle_time/frameCount;
        return this;
    }
    public TextureRegion getFrame(){
        return sprite[frame];
    }
    public boolean GetIsLastFrame() {
        return isLastFrame;
    }
    public Vector2 getPosition(){
        return new Vector2(position.x-scale.x/2,position.y-scale.y/2);
    }
    public Animation setPosition(Vector2 position){
        this.position=position;
        return this;
    }
    public Animation setPosition(int x,int y){
        this.position.x=x;
        this.position.y=y;
        return this;
    }
    public Vector2 getScale(){
        return scale;
    }
    public Animation setScale(Vector2 position){
        this.scale=position;
        return this;
    }
    public Animation setScale(int x,int y){
        this.scale.x=x;
        this.scale.y=y;
        return this;
    }
}
