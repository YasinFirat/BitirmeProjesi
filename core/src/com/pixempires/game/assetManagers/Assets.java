package com.pixempires.game.assetManagers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;

public class Assets {
    public final AssetManager manager=new AssetManager();

    public final String[] warrior_attack=new String[9];
    public final String[] warrior_die=new String[9];
    public final String[] warrior_idle=new String[9];

    public TextureRegion[] sprite_warrior_idle=new TextureRegion[9];

    public Assets(){
        for(int i=0; i<9; i++){
            warrior_attack[i]="Warrior/Warrior_02__ATTACK_00"+i+".png";
            warrior_die[i]="Warrior/Warrior_02__DIE_00"+i+".png";
            warrior_idle[i]="Warrior/Warrior_02__IDLE_00"+i+".png";
        }
    }
    public void load(){
        for(int i=0; i<9; i++){
            manager.load(warrior_attack[i], Texture.class);
            manager.load(warrior_die[i], Texture.class);
            manager.load(warrior_idle[i], Texture.class);
        }
        while (!manager.update()){

        }
        for (int i=0; i<9; i++){
            sprite_warrior_idle[i]=new TextureRegion(manager.get(warrior_idle[i],Texture.class));
        }
    }

    public void dispose(){
        manager.dispose();
    }
}
