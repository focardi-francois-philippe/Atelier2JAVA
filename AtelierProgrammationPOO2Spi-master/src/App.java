import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        // Personne personne1 = new Personne("Girard", "Malo", 29, 11, 2001, 204, "Lotissement Bevinco", "20620", "Biguglia");
        // Personne personne2 = new Personne("Jean-pierre", "Thomas", 21, 03, 2001, 221, "Lotissement Bevinco", "20620", "Biguglia");

        // System.out.println(Personne.getNbrPersonnes());
        // System.out.println(Personne.plusAgee(personne2,personne1));
        // System.out.println(personne2.plusAgeeQue(personne1));
        // System.out.println(personne1.equals(malo));

        Employe francois = Employe.createEmploye("Focardi", "Francois", LocalDate.of(2001, 05, 29), new Adresse(52, "rue Saint Bouazza", "20200", "Lieu dit la zone"), 18000);
        Secretaire justine = Secretaire.createSecretaire("Rocha", "Justine", LocalDate.of(2001, 01, 01),  new Adresse(12,"rue de la Marmotte", "31000", "Toulouse"), 18000);
        Manager malo = Manager.createManager("Girard", "Malo", LocalDate.of(2001,11,29), new Adresse(204, "Lotissement Bevinco", "20620", "Biguglia"), 18000, justine);
        Secretaire lola = Secretaire.createSecretaire("Blanchet", "Lola", LocalDate.of(2001, 01, 01),  new Adresse(12,"rue de la Marmotte", "31000", "Toulouse"), 18000);
        Manager malo2 = Manager.createManager("Girard", "Malo", LocalDate.of(2001,11,29), new Adresse(204, "Lotissement Bevinco", "20620","Biguglia"), 18000, null);

        System.out.println(malo2.getSecretaireName());
        malo2.setSecretaire(lola);
        System.out.println(malo2.getSecretaireName());
        malo2.setSecretaire(justine);
        System.out.println(malo2.getSecretaireName());


        System.out.println(francois.getSalaire());
        System.out.println(justine.getSalaire());
        System.out.println(malo.getSalaire());
        francois.augmenterLeSalaire(10);
        justine.augmenterLeSalaire(10);
        malo.augmenterLeSalaire(10);
        System.out.println(francois.getSalaire());
        System.out.println(justine.getSalaire());
        System.out.println(malo.getSalaire());
    }
}
