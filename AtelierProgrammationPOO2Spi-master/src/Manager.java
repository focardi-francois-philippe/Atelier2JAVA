import java.time.LocalDate;

public class Manager extends Employe {

    private Secretaire pSecretaire;

    public Manager(String leNom,String lePrenom, LocalDate laDate, Adresse lAdresse, float salaire, Secretaire pSecretaire) {
        super(leNom, lePrenom, laDate, lAdresse, salaire);
        if (pSecretaire != null) {
            this.setSecretaire(pSecretaire);
        }
    }

    public static Manager createManager(String leNom,String lePrenom, LocalDate laDate, Adresse lAdresse, float salaire, Secretaire pSecretaire) {
        Manager new_manager = null;
        if (Employe.verificationAgeEmploye(laDate)) {
            new_manager = new Manager(leNom, lePrenom, laDate, lAdresse, salaire, pSecretaire);
        }
        return new_manager;
    }

    public void setSecretaire(Secretaire pSecretaire) {
        if (this.pSecretaire != null) {
            this.pSecretaire.removeManager(this);
        }
        this.pSecretaire = pSecretaire;
        pSecretaire.addManager(this);
    }

    public void augmenterLeSalaire(float pourcentageAugmentation) {
        super.augmenterLeSalaire((float)(pourcentageAugmentation + (0.5*calculAnnuite())));
    }

    public String getSecretaireName() {
        String res;
        if (pSecretaire != null) {
            res = pSecretaire.getNom();
        } else {
            res = "Pas de secrétaire définie...";
        }
        return res;
    }

}
