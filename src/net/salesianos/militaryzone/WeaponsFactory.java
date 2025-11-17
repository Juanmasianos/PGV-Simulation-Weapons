package net.salesianos.militaryzone;


public class WeaponsFactory extends Thread{
    
    private String id;
    private int maxWeapons;
    private String[] weapon = {"laser spartan", "artefacto futurista 009", "trumna prime", "chola de mamá", "gomu gomu no mi", "Terrablade", "Espada de netherita", "pistola nerf", "Excalibur", "Sekki"};
    private int maxFabricationTime;
    private ExperimentalShootingRange shootingRange;

    public WeaponsFactory (String id, int maxWeapons, int maxFabricationTime, ExperimentalShootingRange experimentalShootingRange) {

        this.id = id;
        this.maxWeapons = maxWeapons;
        this.maxFabricationTime = maxFabricationTime;
        this.shootingRange = experimentalShootingRange;

    }

    @Override
    public void run() {
        for (int i = 0; i < maxWeapons; i++) {
            
        }
    }

}
