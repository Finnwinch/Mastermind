import java.util.ArrayList;

/**
 * Classe Serie
 */
public class Serie {
    private ArrayList<Couleur> couleurs;

    /**
     * constructeur de la classe avec aucun paramètre.
     * un seul constructeur est disponible.
     */
    public Serie(){this.couleurs = new ArrayList<Couleur>();}

    /**
     * Retourne une couleur selon la position dans la série
     * @param position
     * @return Couleur
     */
    public Couleur getCouleur(int position){
        if (couleurs.size()<position-1) {
            throw new IllegalArgumentException("Position Invalide") ;
        }
        return couleurs.get(position) ;
    }

    /**
     * Ajouter une couleur dans la série
     * @param couleur
     */
    public void ajouterCouleur(Couleur couleur){ couleurs.add(couleur) ;}

    /**
     * Retourne si la série est égal à une autre série
     * @param serie
     * @return boolean
     */
    public boolean equals(Serie serie){
        for (int i = 0;i<couleurs.size();i++){
            if (!getCouleur(i).equals(serie.getCouleur(i))) {
               return false ;
            }
        }
        return true ;
    }

    /**
     * Retourne une série contenant des indices si la série est égal à une autre série.
     * N = Bonne position et bonne couleur.
     * B = Bonne couleur, mais mauvaise position.
     * Suite de N avec le nombre de la serie = même serie.
     * note : precache des couleurs Noir et Blanc comme indice (B/N)
     * @param serie
     * @return Serie
     */
    public Serie comparer(Serie serie){
        if (this.couleurs.size() != serie.couleurs.size()) {
            throw new IllegalArgumentException("Mauvaise saisie de couleur, il doit y a voir " + Rules.SerieNumber + " couleurs") ;
        }
        Serie result = new Serie() ;
        int size = couleurs.size() ;
        Couleur Noir = new Couleur("Noir",'N') ;
        Couleur Blanc = new Couleur("Blanc",'B') ;
        int CountN = 0 ;
        int CountB = 0 ;

        for (int i = 0; i < size; i++) {
            if (getCouleur(i) == serie.getCouleur(i)) {
                CountN++ ;
            } else {
                for (int j = 0; j < size; j++) {
                    if (i != j && getCouleur(i) == serie.getCouleur(j) ) {
                        CountB++ ;
                        break ;
                    }
                }
            }
        }
        for (int i = 0 ; i <CountN; i++){ result.ajouterCouleur(Noir); }
        for (int i = 0 ; i <CountB; i++){ result.ajouterCouleur(Blanc); }
        return result ;
    }
    /**
     * permet l'affiche des couleurs de la série directemetn via l'appélation de la classe
     * @return String
     */
    @Override
    public String toString(){
        String result = "" ;
        for (Couleur c : couleurs) {
            result = result + c + " " ;
        }
        return result ;
    }

    /**
     * Fonctionnalité ajouter, permet de retourner la taille de la serie
     * utiliser dans la fonctionnalité utiliser dans Mastermind.isSolution
     * @return int
     */
    public int getSize() {return this.couleurs.size();}
}