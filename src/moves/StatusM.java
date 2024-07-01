package moves;

import entities.BattleEntity;
import statuses.DoT;
import statuses.Status;

public class StatusM extends Move{
    private final Status status;
    public StatusM(String name, Status status){
        super(name);
        this.status = status;
    }
    public StatusM(String name, Status status, boolean receiverDirected){
        super(name);
        this.receiverDirected = receiverDirected;
        this.status = status;
    }
    public StatusM(Status status){
        super();
        this.status = status;
    }
    public StatusM(Status status, boolean receiverDirected){
        super();
        this.status = status;
        this.receiverDirected = receiverDirected;
    }

    //SETTER

    @Override
    public int doMove(BattleEntity attacker, BattleEntity receiver) {
        if(!isPassive) System.out.println("<"+attacker.getName()+"> used <"+name+">!");
        if(receiverDirected){
            if(status instanceof DoT) ((DoT) status).setDamage(attacker, receiver);
            if(attacker != receiver) System.out.println(attacker.getName()+ " inflicted "+receiver.getName()+ " with the " +status.getName());
            status.statusInflict(receiver);
        }
        else {
            if(status instanceof DoT) ((DoT) status).setDamage(receiver, receiver);
            System.out.println(attacker.getName()+ " got the " + status.getName());
            status.statusInflict(attacker);
        }
        if(attacker.isDead()) return -1;
        else if(receiver.isDead()) return 1;
        else return 0;
    }
}
