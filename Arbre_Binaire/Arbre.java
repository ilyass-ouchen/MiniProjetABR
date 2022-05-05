import java.util.Random;

import static java.lang.Math.max;

public class Arbre {

    private Noeud racine;
    private int hauteur;

    //Les constructeurs

    public Arbre(Noeud racine) {
        this.racine = racine;
    }
    public Arbre() {
        racine = null;
    }

    // Les accesseurs

    public Noeud getRacine() {
        return racine;
    }

    public int getHauteur() {
        return hauteur;
    }

    // Les modificateurs

    public void setRacine(Noeud racine) {
        this.racine = racine;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    /**
     * la méthode permettant de rechercher le noeud qui contient la clé passant en paramètre
     * @param racine la racine de l'arbre binaire
     * @param cle la cle recherché
     * @return le noeud qui contient la clé
     */
    private Noeud rechercher(Noeud racine, int cle){
        if(racine!=null){
            //Si la clé est égale à la clé de la racine, on retourne la racine
            if(cle == racine.getDonnee().getCle())
                return racine;
            //Si la cle est inférieur à la clé de la racine et le fils gauche est non nul, on cherche sur le côté gauche de l'arbre
            else if(cle < racine.getDonnee().getCle() && racine.getGauche()!=null)
                return rechercher(racine.getGauche(),cle);
            //Si la cle est supérieur à la clé de la racine et le fils droit est non nul, on cherche sur le côté droite de l'arbre
            else if (cle > racine.getDonnee().getCle() && racine.getDroit()!=null)
                return rechercher(racine.getDroit(),cle);

            else
                return null;
        }
        //Si l'arbre est nul, on retourne null
        else{
            return null;
        }
    }
    public Noeud rechercher(int cle){
        return rechercher(racine,cle);
    }

    /**
     * la méthode afficher qui affiche l'arbre selon un affichage spécifique
     * @param racine la racine de l'arbre à afficher
     */
    private void afficher(Noeud racine){
        /* on affiche l'arbre, en commençant par la partie gauche de l'arbre,
           après on affiche la racine de l'arbre,
           et enfin on affiche la partie droite de l'arbre */
        if(racine!=null){
            //afficher la partie gauche de l'arbre
            afficher(racine.getGauche());
            //Si le père du noeud et non nul, on affiche la clè du père avec le noeud
            if(racine.getPere()!=null){
                System.out.println("noeud -->["+racine.getDonnee().getValeur()+"] ==> "+racine.getDonnee().getCle()+" père " +racine.getPere().getDonnee().getCle());
            }
            //Sinon on affiche le noeud seul
            else
                System.out.println("noeud -->["+racine.getDonnee().getValeur()+"] ==> "+racine.getDonnee().getCle());
            //afficher la partie droite de l'arbre
            afficher(racine.getDroit());
        }

    }
    public void afficher(){
        afficher(racine);
    }

    /**
     * la méthode permet de calculer la hauteur d'un arbre
     * @param racine la racine de l'arbre
     * @return l'entier qui représente la hauteur
     */
    public int hauteurArbre(Noeud racine) {
        //Si la racine est non nul,
        //on crée deux variable qui représentent la hauteur de la partie gauche et celle de la partie droite
        int hauteurDroite, hauteurGauche;
        if (racine != null) {
            hauteurDroite = hauteurArbre(racine.getDroit());
            hauteurGauche = hauteurArbre(racine.getGauche());
            //on retourne le max des deux hauteurs
            return 1 + max(hauteurDroite,hauteurGauche)  ;
        }
        //Sinon on retourne -1 ( on soustrait 1 à la fin )
        else
            return -1;
    }


    /**
     * la méthode inserer permettant d'insérer un noeud dans un arbre binaire
     * @param racine la racine de l'arbre binaire
     * @param cle la cle du noeud qu'on veut insérer
     * @param valeur la valeur du noeud qu'on veut insérer
     */
    private void inserer(Noeud racine, int cle, String valeur) {
        if (racine != null) {
            //Si la cle est inférieure de celle de la racine, on teste si le noeud racine à son fils gauche
            if (cle < racine.getDonnee().getCle())
                //Si le fils gauche est non nul,on avance vers ce dernier
                if (racine.getGauche() != null)
                    inserer(racine.getGauche(), cle, valeur);
                //Sinon, on crée un nouveau noeud qui sera le fils du racine
                else {
                    Noeud nouveauNoeud = new Noeud(cle, valeur);
                    nouveauNoeud.setPere(racine);
                    racine.setGauche(nouveauNoeud);
                    System.out.println(" Le noeud avec l'élément (["+valeur+"]==>"+cle+" est bien ajouté .");
                }
                //Sinon si la clé est supérieure de celle de la racine, on teste  cette fois-ci si le noeud racine à son fils droit
            else if (cle > racine.getDonnee().getCle()) {
                //Si le fils droit est non nul,on avance vers le ce dernier
                if (racine.getDroit() != null)
                    inserer(racine.getDroit(), cle, valeur);
                //Sinon, on crée un nouveau noeud qui sera le fils du racine
                else {
                    Noeud nouveauNoeud = new Noeud(cle, valeur);
                    nouveauNoeud.setPere(racine);
                    racine.setDroit(nouveauNoeud);
                    System.out.println(" Le noeud avec l'élément (["+valeur+"]==>"+cle+" est bien ajouté .");
                }
            }
            //si la clé égale à la clé du racine, on affiche le message disant que la clé existe déjà
            else if(cle==racine.getDonnee().getCle())
                System.out.println("la clé "+cle+" existe déjà");
        }
        //Si la racine est nul, on crée un nouveau noeud qui sera la racine
        else{
            Noeud nouveauNoeud = new Noeud(cle, valeur);
            this.setRacine(nouveauNoeud);
            System.out.println(" Le noeud avec l'élément (["+valeur+"]==>"+cle+" est bien ajouté .");

        }
    }
    public void inserer(int cle, String valeur){
        inserer(racine,cle,valeur);
    }

    /**
     * la méthode retourne le dernier fils gauche de l'arbre
     * @param courant le noeud courant sert pour parcourir l'arbre
     * @return le dernier fils gauche
     */
    public static Noeud getDernierFilsGauche(Noeud courant) {
        Noeud dernierFils = courant;
        while (dernierFils.getGauche() != null)
            dernierFils = dernierFils.getGauche();
        return dernierFils;
    }

    /**
     * la méthode permet de supprimer un noeud contenant une clé et une valeur dans un arbre de recherche
     * @param cle la clé du noeud à supprimer
     */
    private void supprimer(Noeud racine, int cle, String valeur){
        // Si l'arbre est vide, alors on retourne rien
        if (racine == null) {
            return ;
        } else {
            //Si la clé est supérieure de celle de la racine, on avance vers le fils droit
            if(cle > racine.getDonnee().getCle()) {
                supprimer(racine.getDroit(), cle, valeur);
            }
            //Si la clé est inférieure de celle de la racine, on avance vers le fils gauche
            else if(cle < racine.getDonnee().getCle()) {
                supprimer(racine.getGauche(), cle, valeur);
            }
            //Si la clé est égale la clé de la racine, alors, il faut prévoir les trois différents cas
            else if (cle == racine.getDonnee().getCle()) {
                //Le cas où le noeud à supprimer est une feuille
                if (racine.getGauche() == null && racine.getDroit() == null) {
                    // si son père est plus grand donc on supprime la clé gauche
                    if (racine.getPere().getDonnee().getCle() > cle) {
                        racine.getPere().setGauche(null);
                    }
                    // sinon on supprime la cle droite
                    else {
                        racine.getPere().setDroit(null);
                    }
                    //Le cas ou le noeud à supprimer a un seul fils

                    }
                // un noeud avec un seul fils droit
                else if (racine.getGauche() == null) {
                    if (racine.getPere().getDonnee().getCle() > cle) {
                        racine.getPere().setGauche(racine.getDroit());
                    }
                    else {
                            racine.getPere().setDroit(racine.getDroit());
                    }
                    racine.getDroit().setPere(racine.getPere());

                    }
                // un noeud avec un seul fils gauche .
                else if (racine.getDroit() == null) {
                    if (racine.getPere().getDonnee().getCle() > cle) {
                        racine.getPere().setGauche(racine.getGauche());
                    }
                    else {
                        racine.getPere().setDroit(racine.getGauche());
                    }
                    racine.getGauche().setPere(racine.getPere());
                    }
                //Le cas où le noeud à supprimer a deux fils
                else {
                    Noeud tmp = getDernierFilsGauche(racine.getDroit());
                    int clef = tmp.getDonnee().getCle();
                    Element element = tmp.getDonnee();
                    supprimer(racine, clef, valeur); // on elimine ce noeud
                    racine.setDonnee(element);
                    }
                }
            }
        }
        public void supprimer(int cle, String valeur){
        supprimer(racine, cle, valeur);
        }


    @Override
    public String toString() {
        return "Arbre{"+ racine + '}';
    }
}
