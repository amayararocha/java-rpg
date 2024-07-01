package statuses;

import entities.*;

public class Debuff extends Status{

    private final float multiplier;

    public Debuff(String name, StatusType type, float multiplier) {
        super(name, type);
        this.multiplier = multiplier;
    }
    public Debuff (String name, int duration, StatusType type, float multiplier){
        this(name, type, multiplier);
        this.duration = duration;
    }
    public float getMultiplier() {
        return multiplier;
    }

    @Override
    public String toString(){
        String statusDesc = super.toString() + " Debuff : " + (int)(multiplier *100)+"%\t";
        if(getStatusName().length() < 16) statusDesc += "\t";
        if(getStatusName().length() < 24) statusDesc += "\t";
        statusDesc += "Duration: "+duration+" turns";
        return statusDesc;
    }
    @Override
    public void statusInflict(BattleEntity bE) {
        super.statusInflict(bE);
        System.out.println(bE.getName() + " had gotten a " + getStatusName() + " Debuff!");
        switch (type) {
            case HEALTH:
                System.out.println(bE.getName() + "'s max health is decreased by " + (int) (bE.getBaseHealthPoints() * multiplier) + "!");
                System.out.println(bE.getName() + "'s current health is now " + bE.getHealthPoints() + " out of " + bE.getMaxHealthPointsBattle() + "!");
                break;
            case ATTACK:
                System.out.println(bE.getName() + "'s attack is decreased by " + (int) (bE.getBaseAttack() * multiplier) + "!");
                System.out.println(bE.getName() + "'s current attack is now " + bE.getAttackBattle() + "!");
                break;
            case CRITCHANCE:
                System.out.printf(bE.getName() + " critical chance is decreased by %.2f%%!\n", multiplier * 100);
                System.out.printf(bE.getName() + " current critical chance is now %.2f%%!\n", bE.getCritChanceBattle() * 100);
                break;
            case CRITDAMAGE:
                System.out.printf(bE.getName() + " critical damage is decreased by %.2f%%!\n", multiplier * 100);
                System.out.printf(bE.getName() + " current critical damage is now %.2f%%!\n", bE.getCritDamageBattle() * 100);
                break;
            default:
                System.out.println("STATUSTYPE BUFF ERROR");
                break;
        }
    }
    @Override
    public int statusDecrement(BattleEntity battleEntity){
        if(duration == INFINITE){
            return 0;
        }
        duration--;
        return 0;
    }

    @Override
    public Status cloneStatus() {
        return new Debuff(name, duration, type, multiplier);
    }


}
