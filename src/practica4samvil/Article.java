/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4samvil;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Classe que representa un article
 * Cada objecte s'identifica per la propietat id
 * @author professor
 */

@Entity
public class Article implements Serializable {
    @Id
    private String id; //denominació de l'article
    private String descripcio;
    private String marca;
    private double preu;
    private double estoc=0.0;
    private double estocMinim=0.0;

    
    /**
     * Constructor per defecte.
     */
    public Article() {
    }


    
    @Override
    public String toString() {
        return "Article [id=" + id + ", descripció=" + descripcio+", marca=" + marca 
                                                    + ", preu=" + preu + "]";
    }

    
    /**
     * Constructor que inicialitza totes les propietats
     * @param id identificador de l'article
     * @param descripcio descripcio de l'article
     * @param marca marca de l'article; si no en te, val null
     * @param preu preu de l'article
     * @param estoc estoc actual de l'article
     * @param estocMinim estoc minim de l'article; si l'estoc n'esta per sota, caldria fer-ne una comanda
     */
    public Article(String id, String descripcio, String marca, double preu, double estoc, double estocMinim) {
        this.id = id;
        this.descripcio = descripcio;
        this.marca = marca;
        this.preu = preu;
        this.estoc = estoc;
        this.estocMinim=estocMinim;
    }
    /**
     * Obtenir l'identificador de l'article
     * @return identificador de l'article
     */
   
    public String getId() {
        return id;
    }

    
    /**
     * Modificar l'identificador de l'article
     * @param id valor a assignar a l'identificador de l'article
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtenir la descripcio de l'article
     * @return descricpicio de l'article
     */
    public String getDescripcio() {
        return descripcio;
    }

    /**
     * Modificar la descripcio de l'article
     * @param descripcio descripcio a assignar a l'article
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    /**
     * Obtenir el preu de l'article
     * @return preu de l'article
     */
    public double getPreu() {
        return preu;
    }

    /**
     * Modificar el preu de l'article
     * @param preu preu a assignar a l'article
     */
    public void setPreu(double preu) {
        this.preu = preu;
    }

    /**
     * Obtenir la marca de l'article
     * @return la marca de l'article
     */
    public String getMarca() {
        return marca;
    }

    /**Modificar la marca de l'article
     * @param marca marca a assignar a l'article
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtenir l'estoc de l'article
     * @return estoc de l'article
     */
    public double getEstoc() {
        return estoc;
    }

    /**
     * Modificar l'estoc de l'article
     * @param estoc estoc a assignar a l'article
     */
    public void setEstoc(double estoc) {
        this.estoc = estoc;
    }

    
    /**
     * Obtenir l'estoc mínim de l'article
     * @return estoc mínim de l'article
     */
    public double getEstocMinim() {
        return estocMinim;
    }
    
   /**
     * Modificar l'estoc mínim de l'article
     * @param estocMinim estoc minim a assignar a l'article
     */   

    public void setEstocMinim(double estocMinim) {
        this.estocMinim = estocMinim;
    }


}