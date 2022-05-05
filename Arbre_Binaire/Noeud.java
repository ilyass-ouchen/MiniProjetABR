class Noeud {
    private Element donnee;
    private Noeud pere;
    private Noeud gauche;
    private Noeud droit;


    // Les constructeurs
    public Noeud(Element element) {
        donnee = element;
        gauche = null;
        droit = null;
        pere = null;
    }

    public Noeud(int cle, String valeur) {
        donnee = new Element(cle, valeur);
        gauche = null;
        droit = null;
        pere = null;
    }
    // Les accesseurs

    public Noeud getDroit() {
        return droit;
    }

    public Noeud getGauche() {
        return gauche;
    }

    public Noeud getPere() {
        return pere;
    }

    public Element getDonnee() {
        return donnee;
    }

    // Les modificateurs
    public void setDroit(Noeud n) {
        droit = n;
    }

    public void setGauche(Noeud n) {
        gauche = n;
    }

    public void setPere(Noeud n) {
        pere = n;
    }



    public void setDonnee(Element e) {
        donnee = e;
    }

    @Override
    public String toString() {
        return "Noeud--> " + getDonnee();

    }
}

