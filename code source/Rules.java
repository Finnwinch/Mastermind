/**
 * Interface Rules : configuration part
 */
public interface Rules {
    /**
     * Le nombre de couleur dans la saisie
     */
    int SerieNumber = 5 ;
    /**
     * Le nombre maximum d'essaie
     */
    int MaxEssaie = 12 ;
    /**
     * Afficher lA réponse à coter de la question
     */
    boolean AfficherReponse = true ;
    /**
     * Afficher l'historique des saisies avec leur comparant
     * Cela affiche également l'essaie fait avec son indice
     */
    boolean ShowPrecedentEssaie = false ;
    /**
     * Afficher l'indice de la saisie. Faut que ShowPrecedentEssaie sois faux
     */
    boolean ShowActifIndice = true ;
    /**
     * Affiche s'il y a aucun indice.  Faut que ShowActifIndice est vrai et que AfficherReponse sois faux
     */
    boolean ShowIfNoCouleur = false ;
    /**
     * Tableau des couleurs disponible
     */
    Couleur[] RegistreCouleur = {
            new Couleur("Rouge",'R'),
            new Couleur("Jaune",'J'),
            new Couleur("Bleu",'B'),
            new Couleur("Orange",'O'),
            new Couleur("Vert",'V'),
            new Couleur("Gris",'G'),
            new Couleur("Noir",'N'),
            new Couleur("Turquoise",'T')
    } ;
}