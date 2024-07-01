package moves;

import entities.BattleEntity;

import java.util.ArrayList;

public class DamagingM extends Move{
    protected double damage;
    protected ArrayList<String> attributes = new ArrayList<>();

    public DamagingM(String name, double damage, String attribute1, String attribute2){
        super(name);
        this.damage = damage;
        this.attributes.add(attribute1);
        this.attributes.add(attribute2);
    }
    public DamagingM(String name, double damage, boolean receiverDirected){
        this(name, damage, "NONE", "NONE");
        this.receiverDirected = receiverDirected;
    }
    public DamagingM(double damage, String attribute1, String attribute2){
        this("Passive Damage <Not real name>", damage, attribute1, attribute2);
        isPassive = true;

    }
    public DamagingM(double damage, boolean receiverDirected){
        this(damage, "NONE", "NONE");
        this.receiverDirected = receiverDirected;
    }

    public double getDamage() {
        return damage;
    }

    public ArrayList<String> getAttributes() {
        return attributes;
    }

    @Override
    public int doMove(BattleEntity attacker, BattleEntity receiver) {
        if(!isPassive) System.out.println("<"+attacker.getName()+"> used <"+name+">!");
        int state;
        if(receiverDirected){
            if((state = attacker.doDamage(this, receiver)) != 0) return state;
        }
        else{
            if((state = attacker.doDamage(damage)) != 0) return state;
        }
        for(Move move : passiveMoves){
            move.doMove(attacker, receiver);
        }
        return 0;
    }
}
