package items;

import entities.*;

public abstract class Item {
    protected String name;

    public Item(){

    }
    public Item(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void useItem(BattleEntity battleEntity) {
        System.out.println(battleEntity.getName() + " used " + name);

    }
}
