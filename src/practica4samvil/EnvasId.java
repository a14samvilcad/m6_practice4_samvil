package practica4samvil;

import java.io.Serializable;

public class EnvasId implements Serializable{
	private String tipus;
	private double quantitat;
	/**
	  * Constructor per defecte
	 * @return 
	  */
	public void EnvasId() {
	}
	/**
	  * Constructor que assigna les propietats de l'objecte
	  * @param tipus tipus d'envas
	  * @param quantitat quantitat que conte l'envas
	 * @return 
	  */
	public void EnvasId(String tipus, double quantitat) {
		this.tipus = tipus;
		this.quantitat = quantitat;
	}
	/**
	  * Obtenir el tipus de l'envas
	  * @return tipus de l'envas
	  */
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
	public double getQuantitat() {
		return quantitat;
	}
	
	/**
	  * Modificar la quantitat que conte l'envas
	  * @param quantitat quantitat que conte l'envas
	  */
	public void setQuantitat(double quantitat) {
		this.quantitat = quantitat;
	}
	
	@Override
	public boolean equals(Object obj) {
		EnvasId e2=(EnvasId)obj;
		return tipus.equals(e2.tipus) && tipus.equals(e2.quantitat);
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}

}