
public class Cellule {

        /**
         * objet encapsulé dans la cellule
         */
        protected Element contenu;
        /**
         * pointeur sur la cellule suivante
         */
        protected Cellule suivant;

        /**
         * constructeur créant une cellule sans contenu ni suivant
         */
        public Cellule() {
            contenu = null;
            suivant = null;
        }

        /**
         * constructeur créant une cellule encapsulant l'objet _contenu
         * @param _contenu l'objet à encapsuler
         */
        public Cellule(Element _contenu) {
            contenu = _contenu;
            suivant = null;
        }

        /**
         * acceseur de la cellule suivante
         * @return suivant
         */
        public Cellule getSuivant() {
            return suivant;
        }

        /**
         * modificateur du suivant
         * @param _c la nouvelle cellule suivante
         */
        public void setSuivant(Cellule _c) {
            suivant = _c;
        }

        /**
         * modificateur du suivant
         * @param _o un objet à encapsuler dans la future nouvelle cellule suivante
         */
        public void setSuivant(Element _o) {
            suivant = new Cellule(_o);
        }

        /**
         * accesseur du contenu
         * @return contenu
         */
        public Object getContenu() {
            return contenu;
        }

        /**
         * modificateur du contenu
         * @param _c le nouveau contenu
         */
        public void setContenu(Element _c) {
            contenu = _c;
        }

        /**
         * repésentation de la cellule en chaîne de caractères
         */
        public String toString() {
            if (contenu == null) {
                return "nil";
            }
            else {
                return contenu.toString();
            }
        }




}
