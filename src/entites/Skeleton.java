package entities;

import Moves.DamagingM;

public class Skeleton extends Enemy{

    public Skeleton(){
        super("Skeleton", 40, 30, 0.3f);
        addMove(new DamagingM("Arm Swing", 0.8, "MELEE", "NONE"));
        addMove(new DamagingM("Skull Bash", 1.2, "MELEE", "NONE"));
    }
    public Skeleton(String name, int healthPoints, int attack, float trapRate) {
        super(name, healthPoints, attack, trapRate);
    }
}
