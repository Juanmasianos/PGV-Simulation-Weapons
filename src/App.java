import net.salesianos.militaryzone.ExperimentalShootingRange;
import net.salesianos.militaryzone.Shooter;
import net.salesianos.militaryzone.WeaponsFactory;

public class App {
    public static void main(String[] args) throws Exception {
        
        ExperimentalShootingRange shootingRange  = new ExperimentalShootingRange(8);

        WeaponsFactory factoryOne = new WeaponsFactory("fabricaUno", 12, 20, shootingRange);
        WeaponsFactory factoryTwo = new WeaponsFactory("fabricaTwo", 5, 13, shootingRange);

        factoryOne.start();
        factoryTwo.start();

        Shooter firstShooter = new Shooter("Ramírez", 7, 15, shootingRange);
        Shooter secondShooter = new Shooter("Jhin", 10, 8, shootingRange);
        
        firstShooter.start();
        secondShooter.start();

        factoryOne.join();
        factoryTwo.join();
        firstShooter.join();
        secondShooter.join();

        System.out.println("Se han terminado las pruebas de armas experimentales");

        System.out.println("Armas en range: " + shootingRange.getStoredWeapons().size());

    }
}
