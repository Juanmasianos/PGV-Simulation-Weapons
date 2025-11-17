package net.salesianos.militaryzone;

import java.util.Random;

public class Shooter extends Thread {

    private String name;
    private int numberOfTests;
    private int maxConsumeTime;
    private ExperimentalShootingRange shootingRange;

    public Shooter(String name, int numberOfTests, int maxConsumeTime, ExperimentalShootingRange shootingRange) {

        this.name = name;
        this.numberOfTests = numberOfTests;
        this.maxConsumeTime = maxConsumeTime;
        this.shootingRange = shootingRange;
    }

    @Override
    public void run() {
        
        Random random = new Random();

        for (int i = 0; i < numberOfTests; i++) {

            try {
                if (this.shootingRange.getStoredWeapons().size() > 0) {

                    int consumeTime = random.nextInt(maxConsumeTime);

                    System.out.println(name + " esta probando el arma " + shootingRange.getStoredWeapons().get(0));

                    shootingRange.consumeWeapon();

                    Thread.sleep(consumeTime * 1000);
                    
                    System.out.println(name + " ha terminado de probar el arma " + shootingRange.getStoredWeapons().get(0));

                } else {
                    
                    this.wait();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
