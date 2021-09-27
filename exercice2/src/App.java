
import tp1.personnel.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Personne p1 = new Personne("Focardi", "Francois-philippe", 28, 05, 2001, 5, "rue", "20600", "Bastia");
        Personne p2 = new Personne("Focardi", "Francois", 28, 05, 1960, 5, "rue", "20600", "Bastia");
        Personne p3 = new Personne("Girard", "MALO", 10,11,1958, 6,"rue","20600","Furiani");
        Personne p4 = new Personne("LEBOEUF", "FRANCK", 28, 05, 2001, 5, "rue", "20600", "Bastia");
        Personne p5 = new Personne("Laurent", "Blanc", 28, 05, 1980, 5, "rue", "20600", "Bastia");
        Personne p6 = new Personne("CHABERT", "Mathieu", 10,11,1958, 6,"rue","20600","Furiani");
        Personne p7= new Personne("STEPHAN", "QUEMPER", 28, 05, 2001, 5, "rue", "20600", "Bastia");
        Personne p8 = new Personne("YOHAN", "BOCO", 28, 05, 1998, 5, "rue", "20600", "Bastia");
        Personne p9 = new Personne("CRV", "LOUIS", 10,11,1958, 6,"rue","20600","Furiani");
        Personne []p = new Personne[9];
        Employe []e = new Employe[9];
        p[0]= p1;
        p[1] = p2;
        p[2]= p3;
        p[3] = p4;
        p[4]= p5;
        p[5] = p6;
        p[6]= p7;
        p[7] = p8;
        p[8]= p9;
        int compteurPersonne = 0;
        Scanner myScanner = new Scanner(System.in);
        ArrayList<Manager> managersArrayList = new ArrayList<Manager>();
        ArrayList<Secretaire> secretaireArrayList = new ArrayList<Secretaire>();
        int retourUtilisateur = 0;
        final int POURCENTAGE = 10;
        for (int i =0;i<9;i++)
        {
            e[i]=Employe.createEmploye(p[i], 1200);
        }
        while (compteurPersonne<9)
        {
            System.out.println("-------MENU---------");
            System.out.println("Taper 1 pour cree un manager 2 pour crée une secretaire 3 pour ajouter a une secretaire un manager 4 pour supprimer un manager 5 AFFICHER TOUTES les informations");
            retourUtilisateur = myScanner.nextInt();
            if(retourUtilisateur == 1)
                managersArrayList.add(Manager.createManager(e[compteurPersonne], new Random().nextInt(15),POURCENTAGE));
            else if(retourUtilisateur == 2)
            {
                secretaireArrayList.add(Secretaire.createSecretaire(e[compteurPersonne], 0));
            }
            else if (retourUtilisateur == 3)
            {
                if(secretaireArrayList.size() >0 && managersArrayList.size()>0)
                    {
                        System.out.println("LISTE DES MANAGERS\n\n");
                        int tailleList = managersArrayList.size();
                        int tailleListSecretaire = secretaireArrayList.size();
                        int identifiantManager =tailleList;
                        int identifiantSecretaire = tailleListSecretaire;
                        Secretaire secretaireTemporaire = null;
                        for(int i = 0;i<tailleList;i++)
                            System.out.println("IDENTIFIANT :"+String.valueOf(i)+managersArrayList.get(i).toString()+"\n");
                        while(identifiantManager>=tailleList)
                        {
                            System.out.println("Entrez l'identifiant du manager a ajouter a la secretaire");
                            identifiantManager = myScanner.nextInt();
                        }
                        for(int i = 0;i<tailleList;i++)
                            System.out.println("IDENTIFIANT :"+String.valueOf(i)+secretaireArrayList.get(i).toString()+"\n");
                        while(identifiantSecretaire>=tailleList)
                        {
                            System.out.println("Entrez l'identifiant de la secretaire auquels vous voulez ajouter le manager");
                            identifiantSecretaire = myScanner.nextInt();
                        }
                        secretaireTemporaire = secretaireArrayList.get(identifiantSecretaire);
                        if(secretaireTemporaire.addManager(managersArrayList.get(identifiantManager)))
                        {
                            System.out.println("Manager Ajouter");
                            managersArrayList.get(identifiantManager).addSecretaire(secretaireTemporaire);
                            secretaireTemporaire.augmenterSalaire(POURCENTAGE);
                        }
                        else
                            System.out.println("Echec Manager dispose deja d'une secretaire");
                    }
                    else
                        System.out.println("Impossible sans crée de manager");
            }
            else if (retourUtilisateur == 4)
            {
                if(secretaireArrayList.size() >0 && managersArrayList.size()>0)
                    {
                        System.out.println("LISTE DES Secretaires\n\n");
                        int tailleList = managersArrayList.size();
                        int tailleListSecretaire = secretaireArrayList.size();
                        int identifiantManager =tailleList;
                        int identifiantSecretaire = tailleListSecretaire;
                        Secretaire secretaireTemporaire = null;
                        ArrayList<Manager> tamponLManagers = null;
                        for(int i = 0;i<tailleList;i++)
                            System.out.println("IDENTIFIANT :"+String.valueOf(i)+secretaireArrayList.get(i).toString()+"\n");
                        while(identifiantSecretaire>=tailleList)
                        {
                            System.out.println("Entrez l'identifiant de la secretaire auquels vous voulez supprimer un manager");
                            identifiantSecretaire = myScanner.nextInt();
                        }
                        secretaireTemporaire = secretaireArrayList.get(identifiantSecretaire);
                        tamponLManagers = secretaireTemporaire.getManagerGerer();
                        tailleList = tamponLManagers.size();
                        if(tailleList>0)
                        {
                            for(int i = 0;i<tailleList;i++)
                            System.out.println("IDENTIFIANT :"+String.valueOf(i)+tamponLManagers.get(i).toString()+"\n");
                        
                            while(identifiantManager>=tailleList)
                            {
                                System.out.println("Entrez l'identifiant du manager a supprimer a la secretaire");
                                identifiantManager = myScanner.nextInt();
                            }
                            secretaireTemporaire.deleteManager(tamponLManagers.get(identifiantManager));
                            secretaireTemporaire.diminuerSalaire(POURCENTAGE);
                        }
                        else
                            System.out.println("La secretaire ne dipose de aucun manager ");
                        
                    }
                    else
                        System.out.println("Impossible sans crée de manager");
            }
            else if (retourUtilisateur==5)
            {
                System.out.println("SECRETAIREEE");
                for (int i =0;i<secretaireArrayList.size();i++)
                {
                    System.out.println(secretaireArrayList.get(i));
                }
                System.out.println("MANAGER");
                for (int i =0;i<managersArrayList.size();i++)
                {
                    System.out.println(managersArrayList.get(i));
                }
            }
            compteurPersonne++;
        }
        myScanner.close();
    }
}

