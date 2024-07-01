package statuses;

import entities.*;

public class DoT extends Status{

    private int damage;

    public DoT(String name, StatusType type) {
        super(name, type);
        if(type != StatusType.BLEED && type != StatusType.POISON){
            System.out.println("STATUS DOT "+name+" HAS TYPE NOT BLEED OR POISON");
        }
    }
    public DoT (String name, int duration, StatusType type){
        this(name, type);
        this.duration = duration;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }
    public void setDamage(BattleEntity attacker, BattleEntity receiver) {
        switch(type){
            case POISON:
                damage = (int)(attacker.getAttackBattle() * .25);
                break;
            case BLEED:
                damage = (int)(receiver.getMaxHealthPointsBattle() * .10);
                break;
            default:
                System.out.println("DOT SET DAMAGE ERROR");
                break;
        }
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString(){
        String statusDesc = super.toString() + " : " + damage + " damage per turn\t";
        if(getStatusName().length() < 16) statusDesc += "\t";
        statusDesc += "Duration: "+duration+" turns";
        return statusDesc;
    }

    @Override
    public void statusInflict(BattleEntity battleEntity) {
        super.statusInflict(battleEntity);
    }

    @Override
    public int statusDecrement(BattleEntity battleEntity){
        if(duration == INFINITE){
            return 0;
        }
        duration--;
        return battleEntity.takeDoT(this);
    }

    @Override
    public Status cloneStatus() {
        DoT s = new DoT(name, duration, type);
        s.setDamage(damage);
        return s;
    }
}
