package tp1.personnel;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Secretaire extends Employe{
    
    private ArrayList<Manager> managerGerer;
    private int nombreDeManagerGerer;
    private Secretaire(String leNom,String lePrenom,GregorianCalendar laDate,Adresse lAdresse,double salaireParam,int nombreAnneeEntrepriseParam)
    {
        super(leNom, lePrenom, laDate, lAdresse, salaireParam, nombreAnneeEntrepriseParam);
        nombreDeManagerGerer = 0;
        managerGerer = new ArrayList<Manager>();
        bonusEmploye = 0.10f;
    }
    public static Secretaire createSecretaire(Employe employe,int nombreAnneeEntrepriseParam)
    {
        GregorianCalendar hCalendar = new GregorianCalendar();
        hCalendar.setTime(new Date());
        int differenceAnnee = hCalendar.get(Calendar.YEAR) - employe.getDateNaissance().get(Calendar.YEAR) ;
        Secretaire hSecretaire = null;
        if(differenceAnnee >=16 && differenceAnnee<=65)
            hSecretaire = new Secretaire(employe.getNom(),employe.getPrenom(),employe.getDateNaissance(),employe.getAdresse(),employe.getSalaire(),nombreAnneeEntrepriseParam);
        return hSecretaire;
    }
    public boolean addManager(Manager managerParam)
    {
        boolean estCree = false;
        if(nombreDeManagerGerer<=4)
        {
            if(managerParam.estDisponible())
            {
                managerGerer.add(managerParam);
                nombreDeManagerGerer++;
                estCree= true;
            }
        }
        return estCree;
    }
    public void diminuerSalaire(float pourcentage)
    {
        salaire = salaire * (1+(pourcentage/100)/bonusEmploye);
    }
    public void deleteManager(Manager manager)
    {
        managerGerer.remove(manager);
        manager.removeSecretaire();
        nombreDeManagerGerer--;
    }
    public void augmenterSalaire(float pourcentage)
    {
        if(pourcentage>0)
        {
            pourcentage += nombreDeManagerGerer *bonusEmploye;
            salaire = salaire * (1+(pourcentage/100));
        }
    }
    public int getTailleListeManager()
    {
        return managerGerer.size();
    }
    public ArrayList<Manager> getManagerGerer() {
        return managerGerer;
    }
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

}
