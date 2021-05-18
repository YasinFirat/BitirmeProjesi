package com.pixempires.game.skills;

public class Health {
    private int health=100;
    private int max_health =100;
    private final int minHealth=0;
    /**
     * Saglik dusurulme islemi yapilir.
     * @param damage dusurulecek saglik miktari
     * @return
     */
    public Health subtractHealth(int damage){
        health-=damage;
        System.out.println("Saglik azaldi");
        if (health<=minHealth){
            health=minHealth;
            System.out.println("Saglik bitti");
        }
        return this;
    }

    /**
     * Saglik ekleme islemi yapilir.
     * @param amount eklenecek saglik miktari
     * @return
     */
    public Health addHealth(int amount){
        health+=amount;
        System.out.println("Saglik arttırıldı.");
        if(health>getMaxHealth()){
            health=getMaxHealth();
            System.out.println("Maximum Saglik Seviyesine Ulasildi");
        }
        return this;
    }

    public Health setNewHealth(int health){
        this.health=health;
        return  this;
    }

    /**
     * Saglik miktari ogrenme islemi yapilir.
     * @return
     */
    public int getHealthValue(){
        return health;
    }

    /**
     * Maximum saglik miktari girilir
     * @return
     */
    public Health setMaxHealth(int maxHealth){
        this.max_health =maxHealth;
        return this;
    }

    /**
     * Maximum saglik miktarini dondurur.
     * @return
     */
    public int getMaxHealth(){
        return max_health;
    }

    /**
     * Saglik minumum seviyeye ulastiginda true dondurur.
     * @return
     */
    public boolean isHealthFinish(){
        return health==minHealth;
    }
}
