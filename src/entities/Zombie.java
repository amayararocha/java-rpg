package entities;

import moves.*;
import statuses.DoT;
import statuses.StatusType;

public class Zombie extends Enemy{

    public Zombie(){
        super("Zombie", 60, 10, 0.5f);
        Move move;
        addMove(new DamagingM("Arm Swing", 0.8, "MELEE", "NONE"));
        move = new DamagingM("Bite", 0.4, "MELEE", "NONE");
        move.addPassiveMove(new StatusM(new DoT("Bitten", StatusType.BLEED)));
        addMove(move);
        move = new DamagingM("Infect", 0.4, "MELEE", "NONE");
        move.addPassiveMove(new StatusM(new DoT("Infected", StatusType.POISON)));
        addMove(move);
    }
    public Zombie(String name, int healthPoints, int attack, float trapRate) {
        super(name, healthPoints, attack, trapRate);
    }
}
