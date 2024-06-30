package weapons;

import moves.*;
import statuses.Buff;
import statuses.StatusType;

public class Claymore extends Weapon{

    public Claymore() {
        super("Claymore", 20, 30, .05f, .80f);
        Move move;
        addMove(new DamagingM("Swaying Slash", 1, "MELEE", "NONE"));
        move = new DamagingM("Guarding Push", 0.5, "MELEE", "NONE");
        move.addPassiveMove(new StatusM(new Buff("Guarded", StatusType.HEALTH, 0.25f), false));
        addMove(move);
        move = new DamagingM("Reckless Crash", 1.5, "MELEE", "NONE");
        move.addPassiveMove(new DamagingM(0.3, false));
        addMove(move);
    }
}
