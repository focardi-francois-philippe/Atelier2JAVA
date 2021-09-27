import java.util.ArrayList;
import java.time.LocalDate;

public class Secretaire extends Employe {

    ArrayList<Manager> pManagers = new ArrayList<Manager>();

    public Secretaire(String leNom,String lePrenom, LocalDate laDate, Adresse lAdresse, float salaire) {
        super(leNom, lePrenom, laDate, lAdresse, salaire);
    }

    public static Secretaire createSecretaire(String leNom,String lePrenom, LocalDate laDate, Adresse lAdresse, float salaire) {
        Secretaire new_secretaire = null;
        if (Employe.verificationAgeEmploye(laDate)) {
            new_secretaire = new Secretaire(leNom, lePrenom, laDate, lAdresse, salaire);
        }
        return new_secretaire;
    }

    public void addManager(Manager pManager) {
        if (pManagers.size() < 5) {
            pManagers.add(pManager);
        }
    }

    public void removeManager(Manager pManager) {
        pManagers.remove(pManager);
    }

    public void augmenterLeSalaire(float pourcentageAugmentation) {
        super.augmenterLeSalaire((float)(pourcentageAugmentation + (0.1*pManagers.size())));
    }


}
