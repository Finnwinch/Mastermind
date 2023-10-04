/**
 * Classe Mastermind
 */
public class Mastermind implements Rules {
    private Serie solution ;
    private int nbEssaie = 1;
    private String History = "" ;

    /**
     * constructeur de la classe sans paramètre
     * deux constructeur est disponible.
     */
    public Mastermind(){
        this.solution = new Serie() ;
        for (int i = 0; i < SerieNumber; i++) {
            int color = (int)(Math.random() * RegistreCouleur.length) ;
            solution.ajouterCouleur(RegistreCouleur[color]);
        }
    }

    /**
     * constructeur de la classe avec un paramètre.
     * @param serie
     */
    public Mastermind(Serie serie){
        this.solution = serie ;
    }

    /**
     * Retorune la série solutionaire
     * @return Serie
     */
    public Serie getSolution() {return this.solution;}
    /**
     * retourne le nombre d'essaie effectuer
     * @return int
     */
    public int getNbEssaies() { return this.nbEssaie ;}
    /**
     * Retourne une serie d'incice
     * écriture de history l'essai suivi de l'indice
     * incrémentation de nbEssaie
     * @param essai
     * @return Serie
     * @throws Exception
     */
    public Serie essayer(Serie essai) throws Exception {
        History = History + essai + " : " + getSolution().comparer(essai) + "\n" ;
        nbEssaie++ ;
        if (nbEssaie > MaxEssaie) throw new Exception("Vous avez perdu") ;
        return this.solution.comparer(essai) ;
    }

    /**
     * permet l'affiche de l'historique via l'appélation de la classe
     * @return String
     */
    @Override
    public String toString(){
        return History ;
    }

    /**
     * Fonctionnalité ajouter, retorune si une serie est la solution
     * Utiliser pour boucler la partie juste qu'à la découverte de la solution oubien le nombre d'essaie épuiser
     * @param serie
     * @return boolean
     */
    public boolean isSolution(Serie serie){
        if (getSolution().getSize() != serie.getSize()) { return false ;}
        return getSolution().equals(serie);
    }
}
