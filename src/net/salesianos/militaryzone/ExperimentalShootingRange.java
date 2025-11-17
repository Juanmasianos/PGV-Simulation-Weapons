package net.salesianos.militaryzone;

import java.util.ArrayList;

public class ExperimentalShootingRange {
    
    private ArrayList<String> storedWeapons = new ArrayList<>();
    private int maximumStorage; 

    public ExperimentalShootingRange(int maximumStorage) {
        this.maximumStorage = maximumStorage;
    }

    public synchronized void addWeapon(String weapon) {

        if (storedWeapons.size() < maximumStorage) {

            this.storedWeapons.add(weapon);

            this.notify();

        }

    }

    public synchronized void consumeWeapon() {

        if (storedWeapons.size() != 0) {

            this.storedWeapons.remove(0);
            
            this.notify();

        }
    }

    public ArrayList<String> getStoredWeapons() {
        return storedWeapons;
    }

}
