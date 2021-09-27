import java.time.LocalDate;


public class Personne {
    private static final Adresse ADRESSE_INCONNUE = null;
	private static final int AGE_MAJORITE = 18;
    private String nom;
    private String prenom;
    private final LocalDate dateNaissance;
    private Adresse adresse=ADRESSE_INCONNUE;
	private static int nbrPersonnes = 0;
	private static String nomDernierePersonneCree;
	private int ageObtentionDernierDiplome;
	/**
	 * Constructeur de Personne
	 * @param leNom le nom de la personne
	 * @param lePrenom le prénom de la personne
	 * @param laDate la date de naissance de la personne
	 * @param lAdresse l'adresse de la personne
	 */
	public Personne(String leNom,String lePrenom, LocalDate laDate, Adresse lAdresse){
		nom = leNom.toUpperCase();
		prenom=lePrenom;
		dateNaissance=laDate;
		adresse=lAdresse;
		nbrPersonnes++;
	}

	/**
	 * Constructeur de Personne
	 * @param leNom le nom de la personne
	 * @param lePrenom le prénom de la personne
	 * @param j le jour de naissance
	 * @param m le mois de naissance
	 * @param a l'année de naissance
	 * @param numero le né de la rue
	 * @param rue la rue
	 * @param code_postal le code postal de l'adresse
	 * @param ville la ville ou la personne habite
	 */
	public Personne(String leNom,String lePrenom, int j, int m, int a, int numero, String rue, String code_postal, String ville){
		this(leNom, lePrenom, LocalDate.of(a,m,j),new Adresse(numero,rue,code_postal,ville));
		nomDernierePersonneCree = leNom;
	}

	public static String getNomDernierePersonneCree() {
		return nomDernierePersonneCree;
	}

	public static int getAGE_MAJORITE() {
		return AGE_MAJORITE;
	}

	public int getAgeObtentionDernierDiplome() {
		return ageObtentionDernierDiplome;
	}

	public void setAgeObtentionDernierDiplome(int ageObtentionDernierDiplome) {
		this.ageObtentionDernierDiplome = ageObtentionDernierDiplome;
	}

	/**
	 * Accesseur
	 * @return retourne le nom
	 */
	public String getNom(){
		return nom;
	}
	/**
	 * Accesseur
	 * @return retourne le prénom
	 */
	public String getPrenom(){
		return prenom;
	}
	/**
	 * Accesseur
	 * @return retourne la date de naissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	/**
	 * Accesseur
	 * @return retourne l'adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}
	/**
	 * Modificateur
	 * @param retourne l'adresse
	 */
	public void setAdresse(Adresse a) {
		adresse=a;
	}

	public static int getNbrPersonnes() {
		return nbrPersonnes;
	}

	static public boolean plusAgee(Personne personne1, Personne personne2) {
		return ! personne1.getDateNaissance().isAfter(personne2.getDateNaissance());
	}

	public boolean plusAgeeQue(Personne personne) {
		return ! this.dateNaissance.isAfter(personne.dateNaissance);
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null &&
		obj instanceof Personne &&
		((Personne)obj).getNom().equals(this.nom) &&
		((Personne)obj).getPrenom().equals(this.prenom)  &&
		this.dateNaissance.equals(((Personne)obj).getDateNaissance());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String result="\nNom : "+nom+"\n"
		+"Prénom : "+prenom+"\n"+
		"Né(e) le : "+ dateNaissance.getDayOfMonth() +
		"-"+dateNaissance.getMonth() +
		"-"+dateNaissance.getYear() + "\n"+
		"Adresse : "+
		adresse.toString();
		return result;
	}
}
