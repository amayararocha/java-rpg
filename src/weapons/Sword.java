package weapons;

import moves.*;
import statuses.Buff;
import statuses.Debuff;
import statuses.StatusType;

public class Sword extends Weapon{

    public Sword() {
        super("Sword", 15, 15, .20f, .50f);
        Move move;
        addMove(new DamagingM("Basic Swing", 0.8, "MELEE", "NONE"));
        move = new DamagingM("Duel Dance", 0.4, "MELEE", "NONE");
        move.addPassiveMove(new StatusM(new Buff("Duelist", StatusType.ATTACK, 0.3f), false));
        addMove(move);
        move = new DamagingM("Force Swing", 1.4, "MELEE", "NONE");
        move.addPassiveMove(new StatusM(new Debuff("Weakened",StatusType.CRITDAMAGE, 0.2f), false));
        addMove(move);
    }
}
