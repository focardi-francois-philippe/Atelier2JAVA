import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Employe extends Personne {

    private float salaire;
    private LocalDate dateEmbauche;

    protected Employe(String leNom,String lePrenom, LocalDate laDate, Adresse lAdresse, float salaire) {
        super(leNom, lePrenom, laDate, lAdresse);
        this.salaire = salaire;
        dateEmbauche = LocalDate.now();
    }

    protected static boolean verificationAgeEmploye(LocalDate laDate) {
        LocalDate currentDate = LocalDate.now();
        LocalDate dateNaissanceMinimale = currentDate.minus(16,ChronoUnit.YEARS);
        LocalDate dateNaissanceMaximale = currentDate.minus(65,ChronoUnit.YEARS);
        return laDate.isBefore(dateNaissanceMinimale) || laDate.isEqual(dateNaissanceMinimale) && laDate.isAfter(dateNaissanceMaximale) || laDate.isEqual(dateNaissanceMaximale);
    }

    public static Employe createEmploye(String leNom,String lePrenom, LocalDate laDate, Adresse lAdresse, float salaire) {
        // Verification age //
        Employe result;
        if (verificationAgeEmploye(laDate)) {
            result = new Employe(leNom, lePrenom, laDate, lAdresse, salaire);
        } else {
            result = null;
        }
        return result;
    }

    public float getSalaire() {
        return salaire;
    }

    public void augmenterLeSalaire(float pourcentageAugmentation) {
        if (pourcentageAugmentation > 0) {
            this.salaire *= ((pourcentageAugmentation / 100) + 1);
        }
    }

    public int calculAnnuite() {
        LocalDate currentDate = LocalDate.now();
        return (dateEmbauche.getYear() - currentDate.getYear()) + 1;
    }
}
