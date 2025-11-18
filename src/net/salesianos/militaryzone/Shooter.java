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
                synchronized (this.shootingRange) {
                    int consumeTime = random.nextInt(maxConsumeTime);
                    
                    String weapon = shootingRange.consumeWeapon();

                    System.out.println(this.name + " esta probando el arma " + weapon);

                    Thread.sleep(consumeTime * 1000);

                    System.out.println(this.name + " ha terminado de probar el arma " + weapon);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
