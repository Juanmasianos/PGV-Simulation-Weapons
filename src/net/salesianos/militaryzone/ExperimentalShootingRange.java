package net.salesianos.militaryzone;

import java.util.ArrayList;

public class ExperimentalShootingRange {

    private ArrayList<String> storedWeapons = new ArrayList<>();
    private int maximumStorage;

    public ExperimentalShootingRange(int maximumStorage) {
        this.maximumStorage = maximumStorage;
    }

    public synchronized void addWeapon(String weapon) {

        try {
            while (storedWeapons.size() >= maximumStorage) {

                this.wait();

            }
        

            this.storedWeapons.add(weapon);

            System.out.println(weapon + " recibido en el campo de tiro listo para usar.");

            this.notify();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized String consumeWeapon() {

        String weapon = "";

        try {
            while (storedWeapons.size() <= 0) {

                this.wait();

            }

            weapon = storedWeapons.get(0);

            this.storedWeapons.remove(0);

            this.notify();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        return weapon;
    }

    public synchronized ArrayList<String> getStoredWeapons() {
        return storedWeapons;
    }

    public synchronized int getMaximumStorage() {
        return maximumStorage;
    }

}
