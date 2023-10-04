import java.util.Scanner;

/**
 * Main : MasterMind
 * @author Léo Cirpaci
 * @version 1.0-nogui
 */
public class main {
    public static void main(String[] args) throws Exception {
        /**
         * Initialisation
         * Mastermind : lancer le jeux
         * Scanner : permettre la saisie
         * Un première serie vide pour lancer la boucle de jeux
         * init type output
         */
        Mastermind m = new Mastermind() ;
        Scanner sc = new Scanner(System.in) ;
        Serie input = new Serie() ;
        Serie output ;
        /**
         * affichage de la configuration
         * voir l'interface Rules.java pour set le paramétrage
         */
        System.out.println("#################[[MasterMind]]#################");
        System.out.println("## longeur de la série : " + m.SerieNumber + "                    ##");
        System.out.println("## nombre d'essaie maximum : " + m.MaxEssaie + "               ##");
        System.out.println("## Réponse afficher : " + (m.AfficherReponse ? "Oui" : "Non") + "                     ##");
        System.out.println("## Historique afficher : " + (m.ShowPrecedentEssaie ? "Oui                  ##" : "Non                  ##\n## Afficher les indices de saisie : " + (m.ShowActifIndice? "Oui       ##\n## Afficher si aucun indice : " + (m.ShowIfNoCouleur ? "Oui" : "Non             ##")  : "Non")));
        System.out.print("## Couleur possible : ") ;
        for (Couleur c : m.RegistreCouleur) {
            System.out.print(c.getAbrevation() + " ");
        }
        System.out.print("        ##\n") ;
        System.out.println("#################[[MasterMind]]#################");
        while (!m.isSolution(input)) {
            /**
             * Réinitialisation de input avec une nouvelle série avant la saisie
             */
            input = new Serie() ;
            System.out.println("[" + m.getNbEssaies() + "/" + m.MaxEssaie + "] " + "Veuillez faire une saisie (" + m.SerieNumber + " couleurs) " + (m.AfficherReponse ? m.getSolution() : ""));
            /**
             * Mettre sous tableau de type char, la saisie de la ligne
             */
            char[] traitement = sc.nextLine().toCharArray() ;
            /**
             * mettre tous les caractère en majuscule, si possible
             */
            for (int i = 0; i < traitement.length; i++) {
                traitement[i] = Character.toUpperCase(traitement[i]);
            }
            /**
             * Trier tous les char et verifier par rapport au Registre des couleurs
             * Cela permet de la prise en charge des espaces et de saisir uniquement des coulers valide.
             * Cela construit le input qui est utiliser comme condition de terminaison de la boucle
             */
            for ( char Abrevation : traitement) {
                for (Couleur couleur : Mastermind.RegistreCouleur) {
                    if (Abrevation == couleur.getAbrevation()) {
                        input.ajouterCouleur(couleur);
                        continue;
                    }
                }
            }
            /**
             * Faire le traitement pour verifier, cela vas seulement permettre a ShowPrecedentEssaie de montrer les comparant avec les comparer, si activer
             * Car il fait l'écriture dans History
             * Sinon il control si on peux voir l'indice de la saisie, si oui, control si ShowIfNoCouleur qui permet de retourner X si il y a aucun indice
             */
            output = m.essayer(input) ;
            if (m.ShowPrecedentEssaie) {
                System.out.print(m) ;
            } else if (m.ShowActifIndice) {

                if (m.ShowIfNoCouleur) {
                    if(output.toString().isEmpty()) {
                        System.out.print("X ");
                    } else {
                        System.out.print(output);
                    }
                } else {
                    System.out.print(output);
                }
            }
        }
        /**
         * Si il sort de la boucle, ces qu'il a trouver la solution avant l'éxecution de l'erreur vous avez perdu qui est déclencer si il dépasse le nombre de tentative
         * Fermeture du scanner
         * Print vous avez gagnez
         */
        sc.close();
        System.out.println("Félicitation, vous avez gagnez !");
    }
}
