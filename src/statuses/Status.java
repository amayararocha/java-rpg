package statuses;

import entities.*;

import java.util.HashMap;
public abstract class Status {
    public final static int INFINITE = Integer.MAX_VALUE;

    static HashMap<StatusType, String> statusNames = new HashMap<>(){{put(StatusType.HEALTH, "Health");
        put(StatusType.ATTACK, "Attack");put(StatusType.CRITCHANCE, "Crit Chance");put(StatusType.CRITDAMAGE, "Crit Damage");
        put(StatusType.POISON, "Poison"); put(StatusType.BLEED, "Bleed");}};

    String name;
    int duration;
    StatusType type;

    public Status(String name, StatusType type){
        this.name = name;
        this.type = type;
        this.duration = 5;
    }

    public String toString(){
        String statusDesc = "Name: " + name + "\t\t";
        if(name.length() < 16) statusDesc += "\t";
        statusDesc += "Type: " + getStatusName();
        return statusDesc;
    }

    public String getName() {
        return name;
    }

    public StatusType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void statusInflict(BattleEntity battleEntity){
        battleEntity.addStatus(cloneStatus());
    }
    public abstract int statusDecrement(BattleEntity battleEntity);
    public String getStatusName(){
        return statusNames.get(type);
    }

    public int getDuration() {
        return duration;
    }

    public abstract Status cloneStatus();
}
