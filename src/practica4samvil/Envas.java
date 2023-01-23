/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4samvil;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

/**
 * Classe que representa un envas en que es serveix algun dels productes envasats
 * Cada objecte s'identifica pel tipus i la quantitat 
 * Per exemple: ampolla d'1.5 litres o paquet de 100 gr.
 * @author professor
 */
@Entity
@IdClass(EnvasId.class)
public class Envas implements Serializable {
    private String tipus;
    private double quantitat;
    private UnitatDeMesura unitat;

    /**
     *  Constructor per defecte
     */    
    
    public Envas() {
    }
    
    /**
     * Constructor que assigna les propietats a l'objecte
     * @param tipus tipus d'envas (per exemple, paquet, ampolla...)
     * @param quantitat quantitat que conte l'envas
     * @param unitat unitats en que es mesura el contingut de l'envas
     */

    public Envas(String tipus, double quantitat, UnitatDeMesura unitat) {
        this.tipus = tipus;
        this.quantitat = quantitat;
        this.unitat = unitat;
    }
    
    /**
     * Obtenir el tipus d'envas
     * @return el tipus de l'envas
     */
    @Id
    public String getTipus() {
        return tipus;
    }

    /**
     * Modificar el tipus de l'envas
     * @param tipus el tipus a assignar a l'envas
     */
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    /**
     * Obtenir la quantitat que conte l'envas
     * @return la quantitat que conte l'envas
     */
    @Id
    public double getQuantitat() {
        return quantitat;
    }

    /**
     * Modificar la quantitat que conte l'envas
     * @param quantitat la quantitat a assignar a l'envas
     */
    public void setQuantitat(double quantitat) {
        this.quantitat = quantitat;
    }

    /**
     * Obtenir la unitat en que es mesura el contingut de l'envas
     * @return unitat en que es mesura el contingut de l'envas
     */
    @ManyToOne
    public UnitatDeMesura getUnitat() {
        return unitat;
    }

    /**
     * Modificar la unitat en que es mesura el contingut de l'envas
     * @param unitat unitat a assignar al'envas
     */
    public void setUnitat(UnitatDeMesura unitat) {
        this.unitat = unitat;
    }

    @Override
    public String toString() {
        return tipus + " de " + quantitat + " " + unitat.getSimbol();
    }

    @Override
    public boolean equals(Object obj) {
        Envas e2=(Envas)obj;
        return tipus.equals(e2.tipus) && tipus.equals(e2.quantitat);
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
