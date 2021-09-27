package tp1.personnel;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Date;
/**
 * Manager
 */
public class Manager extends Employe{

    private Secretaire maSecretaire;
    private Manager(String leNom,String lePrenom,GregorianCalendar laDate,Adresse lAdresse,double salaireParam,int nombreAnneeEntrepriseParam,float pourcentage)
    {
        super(leNom, lePrenom, laDate, lAdresse, salaireParam, nombreAnneeEntrepriseParam);
        this.bonusEmploye = 0.5f;
        maSecretaire = null;
        augmenterSalaire(pourcentage);
    }
    public static Manager createManager(Employe employe,int nombreAnneeEntrepriseParam,float pourcentage)
    {
        GregorianCalendar hCalendar = new GregorianCalendar();
        hCalendar.setTime(new Date());
        int differenceAnnee = hCalendar.get(Calendar.YEAR) - employe.getDateNaissance().get(Calendar.YEAR) ;
        Manager hManager = null;
        if(differenceAnnee >=16 && differenceAnnee<=65)
        {
            hManager = new Manager(employe.getNom(),employe.getPrenom(),employe.getDateNaissance(),employe.getAdresse(),employe.getSalaire(),nombreAnneeEntrepriseParam,pourcentage);
        }
        return hManager;
    }
    public void augmenterSalaire(float pourcentage)
    {
        if(pourcentage>0)
        {
            pourcentage += nombreAnneeEntreprise * bonusEmploye;
            salaire = salaire * (1+(pourcentage/100));
            int a = 2;
        }
    }
    public void addSecretaire(Secretaire mSecretaireParam)
    {
        if(mSecretaireParam.getTailleListeManager() < 5)
            this.maSecretaire = mSecretaireParam;
    }
    public void removeSecretaire(){
        maSecretaire = null;
    }
    public boolean estDisponible()
    {
        boolean resultat = false;
        if (maSecretaire == null)
            resultat = true;
        return resultat;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}