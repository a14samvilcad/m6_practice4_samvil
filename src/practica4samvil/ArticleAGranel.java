/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4samvil;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;


/**
 * Classe que representa un article que es ven a granel
 * @author professor
 */
@Entity
@NamedQuery(name="ArticleAGranel.perTipusMesura", query="SELECT a FROM ArticleAGranel a WHERE a.unitat.simbol = :unitat")

public class ArticleAGranel extends Article {
    private static final long serialVersionUID = 1L;
    private UnitatDeMesura unitat;

    /**
     *  Constructor per defecte
     */
    public ArticleAGranel() {
    }
    
    /**
     * Constructor que assigna les propietats
     * @param id identificador de l'article
     * @param descripcio descripcio de l'article
     * @param preu preu de l'article
     * @param estoc estoc actual de l'article
     * @param estocMinim estoc minim de l'article; si l'estoc n'esta per sota, caldria fer-ne una comanda
     * @param unitat unitat en que es mesura l'article
     */
    
    public ArticleAGranel(String id, String descripcio,  double preu, double estoc, double estocMinim, UnitatDeMesura unitat){
        super(id, descripcio, null, preu, estoc, estocMinim);
        this.unitat = unitat;
    }
    
    
    @Override
    public String toString() {
        return "ArticleAGranel [id=" + getId() + ", descripció=" + getDescripcio()+", marca=" + getMarca() 
                                                    + ", preu=" + getPreu() + ", unitat="+unitat.toString()+"]";    
    }

    /**
     * Obtenir la unitat de mesura de l'article
     * @return la unitat de mesura
     */
    @ManyToOne
    public UnitatDeMesura getUnitat() {
        return unitat;
    }

    /**
     * Modificar la unitat de mesura de l'article
     * @param unitat unitat de mesura a assignar a l'article
     */
    public void setUnitat(UnitatDeMesura unitat) {
        this.unitat = unitat;
    }
    
}
