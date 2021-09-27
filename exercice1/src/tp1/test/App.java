package tp1.test;
import tp1.personnel.*;
public class App {
    public static void main(String[] args) throws Exception {
        Personne p = new Personne("Focardi", "Francois", 28, 05, 2001, 5, "rue", "20600", "Bastia");
        Personne p2 = new Personne("Focardi", "Francois", 28, 05, 2001, 5, "rue", "20600", "Bastia");

         System.out.println(Personne.plusAgee(p, p2));
         System.out.println(p.plusAgeeQue(p2));
        if(p.equals(p2))
            System.out.println(p);
    }
}
