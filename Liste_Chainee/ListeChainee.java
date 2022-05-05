public class ListeChainee {
    /**
     * pointeur sur l'élément tete de la liste
     */
    protected Cellule tete;
    /**
     * pointeur sur l'élément courant vu comme une tête de lecture de la liste
     */
    protected Cellule courant;
    /**
     * pointeur sur l'élément queue de la liste
     */
    protected Cellule queue;

    /**
     * Constructeur par défaut donnant une liste vide
     */
    public ListeChainee() {
        tete = null;
        courant = null;
        queue = null;
    }

    /**
     * Constructeur par recopie
     */
    public ListeChainee(ListeChainee l) {
        this();	// pour le cas où l est vide
        Cellule courantL = l.getTete();
        while (courantL != null) {
            this.ajouteQueue((Element) courantL.getContenu());
            courantL = courantL.getSuivant();
        }
    }

    /**
     * Prédicat vérifiant si la liste est vide
     * @return true si la liste ne contient aucune cellule
     */
    public boolean estVide() {
        return (tete == null);
    }

    /**
     * Prédicat vérifiant si la cellule courante possède un suivant
     * @return true si courant est différent de queue
     */
    public boolean possedeSuivant() {
        return (courant != queue);
    }

    /**
     * Accesseur pour le contenu de la cellule tete
     * @return tete.getContenu()
     */
    public Object entete() {
        if (tete == null) {
            return null;
        }
        return tete.getContenu();
    }

    /**
     * Accesseur pour le contenu de la cellule queue
     * @return queue.getContenu()
     */
    public Object queue() {
        if (queue == null) {
            return null;
        }
        return queue.getContenu();
    }

    /**
     * Accesseur pour la cellule tete
     * @return tete
     */
    public Cellule getTete() {
        return tete;
    }

    /**
     * Accesseur pour la cellule queue
     * @return queue
     */
    public Cellule getQueue() {
        return queue;
    }

    /**
     * Accesseur pour la cellule courante
     * @return courant
     */
    public Cellule getCourant() {
        return courant;
    }

    /**
     * Accesseur pour le contenu de la cellule courante
     * @return courant.getContenu()
     */
    public Object getContenuCourant() {
        if (courant == null) {
            return null;
        }
        return courant.getContenu();
    }

    /**
     * Construit une cellule contenant l'Object passé en paramètre et le
     * place en tete de la liste
     * @param _o l'objet à encapsuler
     */
    public void ajouteTete(Element _o) {
        Cellule c = new Cellule(_o);
        if (estVide()) {
            tete = queue = courant = c;
        }
        else {
            c.setSuivant(tete);
            tete = c;
        }
    }

    /**
     * Construit une cellule contenant l'Object passé en paramètre et le
     * place en queue de la liste
     * @param _o l'objet à encapsuler
     */
    public void ajouteQueue(Element _o) {
        Cellule c = new Cellule(_o);
        if (estVide()) {
            tete = queue = courant = c;
        }
        else {
            queue.setSuivant(c);
            queue = c;
        }
    }

    /**
     * Construit une cellule contenant l'Object passé en paramètre et
     * le place devant l'élément courant, la nouvelle cellule devient
     * l'objet courant
     * @param _o l'objet à encapsuler */
    public void insereCourant(Element _o) {
        if (estVide() || tete == courant) {
            ajouteTete(_o);
            courant = tete;
        }
        else {
            if (courant == null) {
                ajouteQueue(_o);
                courant = queue;
            }
            else {
                Cellule c = new Cellule(_o);
                Cellule avantCourant = tete;
                while (avantCourant.getSuivant() != courant) {
                    avantCourant = avantCourant.getSuivant();
                }
                avantCourant.setSuivant(c);
                c.setSuivant(courant);
                courant = c;
            }
        }
    }


    /**
     * retire l'élément tete de la liste
     */
    public void retireTete() {
        if (tete == queue) {
            // ici on gere le cas liste vide et liste avec un seul élément
            tete = null;
            queue = null;
            courant = null;
        }
        else {
            if (tete == courant) {	// si courant était sur la tête,
                courant = tete.getSuivant(); // courant doit avancer
            }
            tete = tete.getSuivant();
        }
    }

    /**
     * retire l'élément queue de la liste
     */
    public void retireQueue() {
        if (tete == queue) {
            // ici on gere le cas liste vide et liste avec un seul élément
            tete = null;
            queue = null;
            courant = null;
        }
        else {
            Cellule avantQueue = (courant != queue) ? courant : tete;
            while (avantQueue.getSuivant() != queue) {
                avantQueue = avantQueue.getSuivant();
            }
            if (courant == queue) { // si courant était sur la queue
                courant = null; // courant avance et devient null
            }
            avantQueue.setSuivant((Element) null);
            queue = avantQueue;
        }
    }

    /**
     * retire l'élément courant de la liste
     * courant est placé après la cellule retirée
     */
    public void retireCourant() {
        if (courant == tete) {
            retireTete();
        }
        else {
            if (courant == queue) {
                retireQueue();
            }
            else {
                Cellule avantCourant = tete;
                while (avantCourant.getSuivant() != courant) {
                    avantCourant = avantCourant.getSuivant();
                }
                avantCourant.setSuivant(courant.getSuivant());
                courant = courant.getSuivant(); // courant avance après la cellule retirée
            }
        }

    }


    /**
     * permet d'avancer courant à son suivant
     * Attention courant peut devenir null
     */
    public void suivant() {
        if (courant != null)
            courant = courant.getSuivant();
    }

    /**
     * remet courant à la tete de la liste
     */
    public void razCourant() {
        courant = tete;
    }

    /**
     * Construit une chaîne de caractères représentant la liste
     */
    public String toString() {
        // System.out.println("t "+tete+" q "+queue+" c "+courant);
        if (estVide()) {
            return "nil";
        }
        Cellule c_courant = courant;
        razCourant();
        String resu = courant.toString();
        while (courant.getSuivant() != null) {
            suivant();
            resu = resu + " -> "+courant.toString();
        }
        courant = c_courant;
        return resu+" -> nil";
    }
}
