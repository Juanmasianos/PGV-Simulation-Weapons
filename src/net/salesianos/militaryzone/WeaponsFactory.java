package net.salesianos.militaryzone;

import java.util.Random;

public class WeaponsFactory extends Thread {

    private String id;
    private int maxWeapons;
    private String[] weapon = { "laser spartan", "artefacto futurista 009", "trumna prime", "chola de mamá",
            "gomu gomu no mi", "Terrablade", "Espada de netherita", "pistola nerf", "Excalibur", "Sekki" };
    private int maxFabricationTime;
    private ExperimentalShootingRange shootingRange;

    public WeaponsFactory(String id, int maxWeapons, int maxFabricationTime,
            ExperimentalShootingRange experimentalShootingRange) {

        this.id = id;
        this.maxWeapons = maxWeapons;
        this.maxFabricationTime = maxFabricationTime;
        this.shootingRange = experimentalShootingRange;

    }

    @Override
    public void run() {

        Random random = new Random();

        for (int i = 0; i < maxWeapons; i++) {
            try {
                synchronized (this.shootingRange) {
                    int fabricationTime = random.nextInt(maxFabricationTime);

                    String newWeapon = weapon[random.nextInt(10)];

                    System.out.println("La fabrica " + this.id + " esta fabricando el arma " + newWeapon);

                    Thread.sleep(fabricationTime * 1000);

                    shootingRange.addWeapon(newWeapon);

                    System.out.println("La fabrica " + this.id + " ha terminado de fabricar el arma " + newWeapon);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
