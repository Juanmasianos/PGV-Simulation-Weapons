package net.salesianos.militaryzone;

import java.util.ArrayList;

public class ExperimentalShootingRange {
    
    private ArrayList<String> storedWeapons = new ArrayList<>(10);

    public ExperimentalShootingRange() {
    }

    public void addWeapon(String weapon) {

        this.storedWeapons.add(weapon);

    }

    public void consumeWeapon() {

        this.storedWeapons.remove(0);

    }

}
