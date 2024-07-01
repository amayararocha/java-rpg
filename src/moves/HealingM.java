package moves;

import entities.BattleEntity;

import java.util.ArrayList;

public class HealingM extends Move{
    protected int amount;
    protected ArrayList<Move> passiveMoves = new ArrayList<>();

    public HealingM(String name, int amount) {
        super(name);
        this.amount = amount;
        receiverDirected = false;
    }
    public HealingM(String name, int amount, boolean receiverDirected) {
        super(name);
        this.amount = amount;
        this.receiverDirected = receiverDirected;
    }
    public HealingM(int amount) {
        this.amount = amount;
    }
    public HealingM(int amount, ArrayList<Move> passiveMoves) {
        this.amount = amount;
        this.passiveMoves = passiveMoves;
    }

    @Override
    public int doMove(BattleEntity attacker, BattleEntity receiver) {
        if(!isPassive) System.out.println("<"+attacker.getName()+"> used <"+name+">!");
        BattleEntity toHeal;
        if(!receiverDirected) toHeal = attacker;
        else toHeal = receiver;
        int healedAmount = toHeal.getHealthPoints();
        toHeal.heal(amount);
        healedAmount = toHeal.getHealthPoints() - healedAmount;
        System.out.println(toHeal.getName()+" was healed by "+healedAmount+" points");

        for(Move move : passiveMoves){
            move.doMove(attacker, receiver);
        }
        if(attacker.isDead()) return -1;
        else if(receiver.isDead()) return 1;
        else return 0;
    }
}
