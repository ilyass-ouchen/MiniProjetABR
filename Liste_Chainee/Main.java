import java.util.Random;

public class Main {
    // on utilise la fonction pour le remplissage aleatoire du tableau d'élément
    public static Element[] remplirAleatoire(int tailleDuValeur, int tailleTab){

        Random aleatoire = new Random();
        Element[] tab = new Element[tailleTab];

        String lettres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder str = new StringBuilder(tailleDuValeur);

        for (int i = 0; i < tailleTab ; i++ ) {
            tab[i] = new Element();
            // on travaille dans notre exemple sur un intervalle de borne sup égale à 1000000
            tab[i].setCle(aleatoire.nextInt(1000000));

            str  = new StringBuilder("");

            for (int j = 0;j < tailleDuValeur ;j++ ) {
                int indice = (int)(lettres.length() * Math.random());
                str.append(lettres.charAt(indice));
                tab[i].setValeur(str.toString());

            }
        }
        return tab;

    }
    public static void main(String[] args) {


        Element[] tabElement = remplirAleatoire(3, 10000);
        Element[] tabElementARajouter = remplirAleatoire(3, 1000);
        Element[] aSupprimer = new Element[1000];
        Random randIndice = new Random();
        int iAleatoire;

        //création d'un nouveau liste vide
        ListeChainee a = new ListeChainee();

        /* Etape 1 :
            Insértion de 10000 éléments par la tête
            -> temps de départ
        */
        System.out.println("\n Etape 1 : Insertion 10000 elements ");
        long tempsDebut = System.currentTimeMillis();

        for (int i = 0; i < tabElement.length; i++) {
            a.ajouteTete(tabElement[i]);
        }
        long tempsFin = System.currentTimeMillis();
        float temps1 = (tempsFin - tempsDebut);
        float tempsMoyenInsertion1 = temps1 / 10000;


        //a.afficher();
        System.out.println(a);



         /* Etape 2 :
            Insértion de 1000 éléments
            -> temps de départ
        */
        tempsDebut = System.currentTimeMillis();

        System.out.println("\n Etape 2 : Insertion 1000 éléments supplémentaires : ");
        for (int i = 0; i < tabElementARajouter.length; i++) {
            a.ajouteTete(tabElementARajouter[i]);

        }
        tempsFin = System.currentTimeMillis();
        float temps2 = (tempsFin - tempsDebut);
        float tempsMoyenInsertion = temps2 / 1000;
        //  -> temps d'arrivée

        //Remplissage du tableau à supprimer

        for (int j = 0; j < aSupprimer.length; j++) {
            iAleatoire = randIndice.nextInt(10000);
            aSupprimer[j] = tabElement[iAleatoire];
        }

        /* Etape 4 :
             Suppression de 1000 éléments 
             -> temps de départ
         */

        System.out.println("\n  Etape 3 : Suppression de 1000 elements");

        tempsDebut = System.currentTimeMillis();
        for (int j = 0; j < aSupprimer.length; j++) {
            a.retireTete();

        }
        tempsFin = System.currentTimeMillis();
        float temps3 = (tempsFin - tempsDebut);
        float tempsMoyenSuppression = temps3 / 1000;

        //  -> temps d'arrivée


        // l'affichage des temps d'éxecution et du temps moyen pour chaque fonction

        System.out.println("Opération effectuée pour la fonction insérer() de 10000 en: " + temps1 + " millisecondes.");
        System.out.println("Opération effectuée pour la fonction insérer() de 1000 en: " + temps2 + " millisecondes.");
        System.out.println("Opération effectuée pour la fonction supprimer() de 1000 en: " + temps3 + " millisecondes.");

        System.out.println("--------------------------------------------------------------------------------------------");


        System.out.println("le temps moyen pour la fonction insérer()  en: " + tempsMoyenInsertion1 + " millisecondes");
        System.out.println("le temps moyen pour la fonction insérer()  en: " + tempsMoyenInsertion + " millisecondes.");
        System.out.println("le temps moyen pour la fonction supprimer()  en: " + tempsMoyenSuppression + " millisecondes.");

    }
}