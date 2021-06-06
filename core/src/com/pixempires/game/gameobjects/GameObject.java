package com.pixempires.game.gameobjects;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.pixempires.game.GameWorld;
import com.pixempires.game.skills.Movement;

/**
 * Her bir nesne bir GameObject'tir.
 */
public abstract class GameObject extends Component{
    protected GameWorld game_world; //bulundukları sahne olarak düşünülebilir.
    protected Texture texture; //.jpg , .png uzantılı dosyaları tanımlar.
    protected TextureRegion sprite; //texture olarak çektiğimiz dosyaları ekranda gösterilmesinde rol oynar
    protected Vector2 position; //karakterin pozisyonu
    protected Vector2 scale; //karakterin boyutu
    protected float speed=1; //her karakterin otomatik speed'i 1 olarak tanımlanır. Hareket metodu kullanılırsa karakter o hızda hareket eder.
    public Movement movement=new Movement();

    /**
     * Default olarak position ve scale oluşturulur fakat bir değer atanmaz
     */
    public GameObject() {
        position=new Vector2();
        scale=new Vector2();

    }

    /**
     * sprite tanımlanır,default olarak position 100,100 ; scale ise texture'nin orjinal boyutunu alır
     * @param texture texture'yi import edin.
     */
    public GameObject(Texture texture){

        this.texture=texture;
        sprite=new TextureRegion(texture);
        position=new Vector2(100,100);
        scale=new Vector2(texture.getWidth(),texture.getHeight());

    }

    /**
     * sprite,position ve scale tanımladığınız değerlerle oluşturulur.
     * @param texture texture import edin.
     * @param begin_x karakter'in ekranda görüneceği x pozisyonu
     * @param begin_y karakter'in ekranda görüneceği y pozisyonu
     * @param width  karakterin genişliği (scale x tanımlanır)
     * @param heigth karakterin yüksekliği (scale y tanımlanır)
     */
    public GameObject(Texture texture,int begin_x,int begin_y,int width,int heigth){
        this(texture);
        position=new Vector2(begin_x,begin_y); //pozisyon tanımlanır
        scale=new Vector2(width,heigth); //scale tanımlanır.
        sprite=new TextureRegion(texture,position.x,position.y,scale.x,scale.y); //karakterin durumları tanımlanır.

    }

    /**
     * Scale döndürür.
     * @return Vector2
     */
    public Vector2 getScale() {
        return scale;
    }

    /**
     * Scane tanımlanır
     * @param scale Vector2 türünden
     * @return aynı sınıfı döndürür.
     */
    public GameObject setScale(Vector2 scale) {
        this.scale = scale;
        return this;
    }

    /**
     * Scale tanımlanır
     * @param x  x boyutu
     * @param y y boyutu
     * @return
     */
    public GameObject setScale(int x,int y) {
        this.scale.x = x;
        this.scale.y= y;
        return this;
    }

    /**
     * Position döndürür.
     * @return Vector2
     */
    public Vector2 getPosition() {
        return position;
    }

    /**
     * Pozisyon tanımlanır.
     * @param position Vector2 türünden veri alır
     * @return aynı sınıfı döndürür
     */
    public GameObject setPosition(Vector2 position) {
        this.position.x=position.x-scale.x/2;
        this.position.y=position.y-scale.y/2;
        return this;
    }

    /**
     * Pozisyon tanımlanır.
     * @param x x koordinatını alır
     * @param y y koordinatını alır
     * @return aynı sınıfı döndürür.
     */
    public GameObject setPosition(float x,float y) {

        this.position.x = x-scale.x/2;
        this.position.y = y-scale.y/2;
        return this;
    }

    /**
     * Karakter istenilen konuma hareket eder. Vardığında ise durur
     * @param position karakterin anlık pozisyonu
     * @param target hedef
     * @param speed speed
     * @param distance karakterin hedefe ulaştığında duracağı konum
     * @return
     */
    public GameObject move(Vector2 position,Vector2 target,float speed,float distance){

        this.position=movement.move(this.position,target,speed,distance);
        return this;
    }

    /**
     * Ekranda görüntülenme işlemini yapar
     * @param sprite_batch sprite görüntülenmesi için çağrılır
     */
    public abstract void render(SpriteBatch sprite_batch);
    /**
     * sonsuz bir döngü
     * @param delta kare hızı
     */
    public abstract void update(float delta);

    /**
     * Obje ile işimiz bittiğinde bellekte yer kaplamaması adına sildirme işlemi yapılır.
     */
    public abstract void dispose();
    public TextureRegion getSprite(){
        return sprite;
    } //
    protected GameObject setSprite(Texture texture){
        sprite=new TextureRegion(texture);
        return this;
    }

    public float getSpeed() {
        return speed;
    } //

    public GameObject setSpeed(float speed) {
        this.speed = speed;
        return this;
    }
}
