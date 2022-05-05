import java.util.*;
public class test {
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


        Element[] tabElement = remplirAleatoire( 3, 10000);
        Element[] tabElementARajouter = remplirAleatoire( 3, 1000);
        Element[] aSupprimer = new Element[1000];
        Random  randIndice= new Random();
        int iAleatoire;

        //création d'un nouveau arbre vide
        Arbre a = new Arbre();

        /* Etape 1 :
            Insértion de 10000 éléments dans l'arbre a
            -> temps de départ
        */
        System.out.println("\n Etape 1 : Insertion 10000 elements ");
        long tempsDebut = System.currentTimeMillis();

        for (int i=0;i<tabElement.length;i++){
            a.inserer(tabElement[i].getCle(), tabElement[i].getValeur());
        }
        long tempsFin = System.currentTimeMillis();
        float temps1 = (tempsFin - tempsDebut) ;
        float tempsMoyenInsertion1 = temps1 / 10000;


        //a.afficher();



         /* Etape 2 :
            Insértion de 1000 éléments dans l'arbre a
            -> temps de départ
        */
        tempsDebut = System.currentTimeMillis();

        System.out.println("\n Etape 2 : Insertion 1000 éléments supplémentaires : ");
        for (int i=0;i<tabElementARajouter.length;i++){
            a.inserer(tabElementARajouter[i].getCle(), tabElementARajouter[i].getValeur());

        }
        tempsFin = System.currentTimeMillis();
        float temps2 = (tempsFin - tempsDebut) ;
        float tempsMoyenInsertion = temps2 / 1000;
        //  -> temps d'arrivée

        //Remplissage du tableau à supprimer

        for (int j=0; j< aSupprimer.length; j++){
            iAleatoire = randIndice.nextInt(10000);
            aSupprimer[j]= tabElement[iAleatoire];
        }

        /* Etape 4 :
             Suppression de 1000 éléments dans l'arbre a
             -> temps de départ
         */

        System.out.println("\n  Etape 3 : Suppression de 1000 elements");

        tempsDebut = System.currentTimeMillis();
        for (int j=0; j< aSupprimer.length; j++){
            a.supprimer(aSupprimer[j].getCle(), aSupprimer[j].getValeur());

        }
        tempsFin = System.currentTimeMillis();
        float temps3 = (tempsFin - tempsDebut) ;
        float tempsMoyenSuppression = temps3 / 1000;

        //  -> temps d'arrivée


        System.out.println("--------------------------------------------------------------------------------------------");



        // la hauteur de l'arbre obtenu

        System.out.println(" la hauteur de l'arbre a est : "+a.hauteurArbre(a.getRacine()));


        // l'affichage des temps d'éxecution et du temps moyen pour chaque fonction

        System.out.println("Opération effectuée pour la fonction insérer() de 10000 en: "+ temps1 + " millisecondes.");
        System.out.println("Opération effectuée pour la fonction insérer() de 1000 en: "+ temps2 + " millisecondes.");
        System.out.println("Opération effectuée pour la fonction supprimer() de 1000 en: "+ temps3 + " millisecondes.");

        System.out.println("--------------------------------------------------------------------------------------------");


        System.out.println("le temps moyen pour la fonction insérer()  en: "+ tempsMoyenInsertion1 + " millisecondes");
        System.out.println("le temps moyen pour la fonction insérer()  en: "+ tempsMoyenInsertion + " millisecondes.");
        System.out.println("le temps moyen pour la fonction supprimer()  en: "+ tempsMoyenSuppression + " millisecondes.");




















        //a.afficher();
        //System.out.println(a.getRacine());
        //System.out.println("la hauteur : "+a.hauteurArbre(a.getRacine()));

       /* a.inserer(12,"A");
        a.inserer(25,"B");
        a.inserer(7,"C");
        a.inserer(9,"D");
        a.inserer(11,"E");
        a.inserer(4,"F");
        a.inserer(1,"G");
        a.afficher();
        System.out.println("la hauteur : "+a.hauteurArbre(a.getRacine()));
        System.out.println("le résultat de la recherche "+a.rechercher(11));
        System.out.println("le résultat de la recherche "+a.rechercher(4));
        System.out.println(a.rechercher(13));
        a.supprimer(1,"G");
        a.inserer(5,"H");
        a.inserer(20,"I");
        a.inserer(22,"J");
        a.supprimer(12,"A");


        System.out.println("--------------------------------------------------------------------------------------------");
        a.afficher();
        System.out.println("la hauteur : "+a.hauteurArbre(a.getRacine()));*/

    }
}
