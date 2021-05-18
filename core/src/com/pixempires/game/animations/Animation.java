package com.pixempires.game.animations;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;


/**
 * Sprite parcalama ve 2D Animasyon olusturma islemi yapar.
 */
public class Animation {
    /**
     * Animasyon frame'lerinin bulundugu texture dosyasını ekleyiniz.
     */
    private Texture texture_of_sprite;
    /**
     * Her frame bu diziye sırasıyla eklenir.
     */
    private TextureRegion[] sprite;
    /**
     * Toplam frame sayisi
     */
    private int frame_count;
    /**
     * frame bitim suresi
     */
    private float max_frame_time;
    /**
     * Aktif olarak frame suresini gosterir.
     */
    private float currentFrameTime;
    /**
     * Aktif olarak calisan frame gosterilir.
     */
    private int frame;
    /**
     * Pazisyon islemi yapilir.
     */
    private Vector2 position=new Vector2().setZero();
    /**
     * Boyut icin islem yapilir.
     */
    private Vector2 scale=new Vector2().setZero();
    /**
     * Son frame calistiginda true olur.
     */
    private boolean isLastFrame;


    public Animation(Texture texture_of_sprit){
        this.texture_of_sprite=texture_of_sprit;
    }
    public void render(SpriteBatch sprite_batch){
        sprite_batch.begin();
        sprite_batch.draw(sprite[frame],getPosition().x,getPosition().y,scale.x,scale.y);
        sprite_batch.end();
    }
    public void update(float delta){
        currentFrameTime+=delta;
        if(currentFrameTime > max_frame_time){
            frame++;
            currentFrameTime = 0;
        }


        if(frame >= frame_count){
           //son sprite çalışır.
            System.out.println(frame);
            isLastFrame=true;
            frame = 0;
        }else{
            isLastFrame=false;
        }

    }

    /**
     * Texture'de bulunan gorselleri x eksenine göre parcalama algoritması
     * @param begin_x Texture,baslangic x noktası
     * @param begin_y Texture, baslangıc y noktası
     * @param width  goruntunun genisligi
     * @param height goruntunun yuksekligi
     * @param frameCount goruntu icerisinde kaç adet resim varsa sayısı girilir.
     * @param space_x_frame bazı durumlarda her frame arasında fazladan bosluklar olusabilir.
     *                      Eger fazladan bosluk yoksa 0 degerini atayınız,fazladan bosluk varsa degerini giriniz.
     * @return
     */
    public Animation split1D(int begin_x, int begin_y, int width, int height, int frameCount, int space_x_frame){
        this.frame_count =frameCount;
        sprite=new TextureRegion[frameCount]; //sprite boyutu girilir.
        int keep_begin_x=begin_x; //baslangic noktasi tutulur.
        max_frame_time =.5f/frameCount;
        for (int i=0; i<frameCount;i++){
            sprite[i]=new TextureRegion(texture_of_sprite,begin_x,begin_y,width,height);
            if(space_x_frame==0){
                begin_x+=width; //eger arada bosluk yoksa yeni frame icin genislik baz alinir.
            }else{
                begin_x=i*space_x_frame+keep_begin_x; //arada bosluk varsa
            }
        }
        return this;
    }

    /**
     * Parcalama icin sadece bir TextureRegion dizisi eklemeniz yeterli olacaktir.
     * @param sprite
     * @return
     */
    public Animation split1DManual(TextureRegion[] sprite){
        this.sprite=sprite;
        frame_count =sprite.length;
        max_frame_time =.5f/ frame_count;
        return  this;
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
    public Animation split2D(int begin_x, int begin_y, int width, int height, int frameCount_x, int frameCount_y){
        this.frame_count =frameCount_x+frameCount_y;
        sprite=new TextureRegion[frame_count];
        scale.set(width,height);
        max_frame_time =.5f/ frame_count;
        int counter_frameCount_x=0;
        int counter_frameCount_y=0;
        for (int i = 0; i< frame_count; i++){
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
        if (frame_count ==0)
            return this;
        max_frame_time =circle_time/ frame_count;
        return this;
    }

    /**
     * Frame'e bagli olarak aktif olan goruntu dondurulur.
     * @return
     */
    public TextureRegion getFrame(){
        return sprite[frame];
    }
    public boolean getIsLastFrame() {
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
