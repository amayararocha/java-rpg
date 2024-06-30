package game;

import entities.*;
import items.*;
import moves.*;
import statuses.*;
import weapons.*;

import java.util.Random;

public class Limited_Objs {
    public static Weapon[] createLimWeaps() {
        Weapon sword = new Sword();
        Weapon spear = new Spear();
        Weapon claymore = new Claymore();

        return new Weapon[]{sword, spear, claymore};
    }

    public static Enemy createLimEnemy() throws Exception {
        Random rand = new Random();
        String[] enemyNames = {"entities.Slime", "entities.Zombie", "entities.Skeleton"};
        Class<?> c = Class.forName(enemyNames[rand.nextInt(3)]);
        return (Enemy) c.getDeclaredConstructor().newInstance();
    }

    public static Item[] createLimItems() {
        Item potion = new HealingI("Potion", new HealingM("Heal", 40));
        Item vigor = new StatusI("Vigor", new StatusM(new Buff("Vigor", StatusType.HEALTH, .25f)));
        Item severity = new StatusI("Severity", new StatusM(new Buff("Severity", StatusType.ATTACK, .3f)));
        Item fortuity = new StatusI("Fortuity", new StatusM(new Buff("Fortune", StatusType.CRITCHANCE, .2f)));
        Item fatality = new StatusI("Fatality", new StatusM(new Buff("Fatality", StatusType.CRITDAMAGE, .5f)));
        Item singleBarrel = new DamagingI("Single Barrel Shotgun", 50);

        return new Item[]{potion, vigor, severity, fortuity, fatality, singleBarrel};
    }
}
