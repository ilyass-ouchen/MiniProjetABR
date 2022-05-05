public class Element {
    private int cle;
    private String valeur;

    // Constructeurs
    public Element(){
        this.cle=0;
        this.valeur="";
    }
    public Element(Element c) {
        this.cle=c.getCle();
        this.valeur=c.getValeur();
    }
    public Element(int cle, String valeur){
        this.cle=cle;
        this.valeur=valeur;

    }

    // Accesseurs
    public int getCle(){
        return cle;
    }
    public String getValeur(){
        return valeur;
    }

    // Modificateurs
    public void setCle( int c){
        this.cle = c;

    }
    public void setValeur( String v){
        this.valeur = v;

    }
    public String toString(){
        String resu;
        resu = "["+getValeur()+"] ==>"+getCle();
        return resu;

    }
}