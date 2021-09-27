package tp1.personnel;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employe extends Personne {

    protected double salaire;
    protected GregorianCalendar dateEmbauche;
    protected int nombreAnneeEntreprise;
    protected float bonusEmploye;

    protected Employe(String leNom,String lePrenom,GregorianCalendar laDate,Adresse lAdresse,double salaireParam,int nombreAnneeEntrepriseParam){
        super(leNom, lePrenom, laDate, lAdresse);
        Date hDate = new Date();
        this.salaire = salaireParam;
        dateEmbauche = new GregorianCalendar();
        dateEmbauche.setTime(hDate);
        nombreAnneeEntreprise = nombreAnneeEntrepriseParam;
    }


    public static Employe createEmploye(Personne personneParam,double salaire)
    {
        GregorianCalendar hCalendar = new GregorianCalendar();
        hCalendar.setTime(new Date());
        int differenceAnnee = hCalendar.get(Calendar.YEAR) - personneParam.getDateNaissance().get(Calendar.YEAR) ;
        Employe hEmployes = null;
        if(differenceAnnee >=16 && differenceAnnee<=65)
        {
            hEmployes = new Employe(personneParam.getNom(),personneParam.getPrenom(),personneParam.getDateNaissance(),personneParam.getAdresse(),salaire,0);
        }
        return hEmployes;
    }
    public double getSalaire() {
        return salaire;
    }

    public void augmenterSalaire(float pourcentage)
    {
        if(pourcentage>0)
            salaire = salaire * (1+(pourcentage/100));
    
    }

    public int getNombreAnneeEntreprise() {
        return nombreAnneeEntreprise;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Le Nom : "+this.getNom() + " Le Prenom "+this.getPrenom()+ " Le salaire: "+this.getSalaire();
    }

}
