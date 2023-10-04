/**
 * Classe Couleur
 */
public class Couleur {
    private String nom ;
    private char abrevation ;
    /**
     * constructeur de la classe avec deux paramètres.
     * un seul constructeur est disponible.
     * @param nom
     * @param abrevation
     */
    public Couleur(String nom, char abrevation){
        this.nom = nom ;
        this.abrevation = abrevation ;
    }
    /**
     * retourne le nom de la couleur
     * @return String
     */
    public String getNom() { return this.nom;} ;
    /**
     * retourne l'abrevation de la couleur
     * @return char
     */
    public char getAbrevation() { return this.abrevation;} ;
    /**
     * retorune si la couleur est égal à une autre couleur
     * @param uneCouleur
     * @return boolean
     */
    public boolean equals(Couleur uneCouleur){
        return getNom().equals(uneCouleur.getNom()) ;
    }
    /**
     * permet l'affiche de l'abrévation via l'appélation de la classe
     * @return String
     */
    @Override
    public String toString(){
        return String.valueOf(this.abrevation);
    }
}
