package com.pixempires.game.assetManagers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Oyun yükleneceği zaman gerekli asset'ler için işlem yapılır.(Loading bar için buraya uğra)
 */
public class Assets {
    /**
     * Assets kontrolü için static olarak tanımlanmistir.
     */
    public static final AssetManager manager=new AssetManager();
//region String arrays
    public final String[] warrior_attack=new String[9];
    public final String[] warrior_die=new String[9];
    public final String[] warrior_idle=new String[9];
    public final String[] warrior_run=new String[9];
//endregion

//region static TextureRegion arrays
    public static TextureRegion[] sprite_warrior_idle_right =new TextureRegion[9];
    public static TextureRegion[] sprite_warrior_die_right =new TextureRegion[9];
    public static TextureRegion[] sprite_warrior_attack_right=new TextureRegion[9];
    public static TextureRegion[] sprite_warrior_run_right=new TextureRegion[9];
    public static TextureRegion[] sprite_warrior_idle_left =new TextureRegion[9];
    public static TextureRegion[] sprite_warrior_die_left =new TextureRegion[9];
    public static TextureRegion[] sprite_warrior_attack_left=new TextureRegion[9];
    public static TextureRegion[] sprite_warrior_run_left=new TextureRegion[9];

//endregion7

    /**
     * Gerekli assets string olarak çağrılır.
     */
    public Assets (){
        for(int i=0; i<9; i++){
            warrior_attack[i]="Warrior/Warrior_02__ATTACK_00"+i+".png";
            warrior_die[i]="Warrior/Warrior_02__DIE_00"+i+".png";
            warrior_idle[i]="Warrior/Warrior_02__IDLE_00"+i+".png";
            warrior_run[i]="Warrior/Warrior_02__RUN_00"+i+".png";
        }

    }
    public void load(){
        for(int i=0; i<9; i++){
            manager.load(warrior_attack[i], Texture.class);
            manager.load(warrior_die[i], Texture.class);
            manager.load(warrior_idle[i], Texture.class);
            manager.load(warrior_run[i], Texture.class);
        }
        while (!manager.update()){

        }
        for (int i=0; i<9; i++){
            sprite_warrior_idle_right[i]=new TextureRegion(manager.get(warrior_idle[i],Texture.class));
            sprite_warrior_die_right[i]=new TextureRegion(manager.get(warrior_die[i],Texture.class));
            sprite_warrior_attack_right[i]=new TextureRegion(manager.get(warrior_attack[i],Texture.class));
            sprite_warrior_run_right[i]=new TextureRegion(manager.get(warrior_run[i],Texture.class));
            sprite_warrior_idle_left[i]=new TextureRegion(manager.get(warrior_idle[i],Texture.class));
            sprite_warrior_idle_left[i].flip(true,false);
            sprite_warrior_die_left[i]=new TextureRegion(manager.get(warrior_die[i],Texture.class));
            sprite_warrior_die_left[i].flip(true,false);
            sprite_warrior_attack_left[i]=new TextureRegion(manager.get(warrior_attack[i],Texture.class));
            sprite_warrior_attack_left[i].flip(true,false);
            sprite_warrior_run_left[i]=new TextureRegion(manager.get(warrior_run[i],Texture.class));
            sprite_warrior_run_left[i].flip(true,false);
        }
    }

    public void dispose(){
        manager.dispose();
    }
}
