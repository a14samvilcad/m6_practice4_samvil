/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica4samvil;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Programa {

/**
 * Programa principal
 */
    
public static void main(String args[]){

    // llistes per emmagatzemar els resultats de les consultes
    
    List<Article> resultatA;
    List<ArticleEnvasat> resultatAE;
    List<ArticleAGranel> resultatAAG;

    // Dades per gestionar la persistencia
    
    EntityManagerFactory emf;
    EntityManager em;

    GestorObjectDB gestor;
    
    
    // Objectes que s'afegiran a la base de dades
    UnitatDeMesura kg, gr, litre;
    Envas paquet500g, paquet250g, garrafa5l;
    Article cafeIntens, cafeSuau;
    Article fideusFins, fideusGruixuts, macarrons;
    Article aiguaMineral, iogurt;
    Article pera, poma, platan;



    kg= new UnitatDeMesura("kg", "quilogram");
    gr = new UnitatDeMesura("g", "gram");
    litre = new UnitatDeMesura("l", "litre");

    paquet500g = new Envas("paquet", 500, gr);
    paquet250g = new Envas("paquet", 250, gr);
    garrafa5l = new Envas("garrafa", 5, litre);

    cafeIntens = new ArticleAGranel("CAFE INT", "Cafe intens", 12, 100, 10, kg);
    cafeSuau = new ArticleAGranel("CAFE SUA", "Cafe suau", 10, 100, 20, kg);

    fideusFins = new ArticleEnvasat("FID FIN", "Fideus fins", "Tot Pastes",0.3, 500, 100, paquet250g);
    fideusGruixuts = new ArticleEnvasat("FID GRX", "Fideus gruixuts", "Tot Pastes",0.2, 250, 100, paquet250g);
    macarrons = new ArticleEnvasat("MACARR", "Macarrons", "Tot Pastes",0.7, 50, 10, paquet500g);

    aiguaMineral = new ArticleEnvasat("AIGUA MIN", "Aigua mineral", "Alimenta'm", 4, 100, 20, garrafa5l);

    iogurt = new ArticleEnvasat("IOGURT", "Iogurt", "Alimenta'm", 2, 100, 20, paquet250g);                

    pera = new ArticleAGranel("PERA", "Pera", 3, 100, 7, kg);
    poma = new ArticleAGranel("POMA", "Poma", 2.5, 100, 8, kg);
    platan = new ArticleAGranel("PLATAN", "Platan", 2.7, 100, 9, kg);

    
    // Inicialitzacio de l'EntityManager i del gestor de la persistencia
    emf = Persistence.createEntityManagerFactory("$objectdb/db/holaa.odb");
    em = emf.createEntityManager();

    gestor = new GestorObjectDB(em);

    
    //Altes
    /*
    gestor.inserir(kg);
    gestor.inserir(gr);
    gestor.inserir(litre);

    gestor.inserir(paquet500g);
    gestor.inserir(paquet250g);
    gestor.inserir(garrafa5l);

    gestor.inserir(cafeIntens);
    gestor.inserir(cafeSuau);
    gestor.inserir(fideusFins);
    gestor.inserir(fideusGruixuts);
    gestor.inserir(macarrons);
    gestor.inserir(aiguaMineral);
    gestor.inserir(iogurt);

    gestor.inserir(pera);
    gestor.inserir(poma);
    gestor.inserir(platan);*/
    
    
    // Consultes
    
    resultatA=gestor.totsArticles(); 


    //Consulta 1
    System.out.println("Tots els articles");
    System.out.println("=================");
    em.flush();
    for(Article a: resultatA){ 
        em.refresh(a); // cal refrescar si volem que s'actualitzin les variables de memoria amb el valor de la BD
        System.out.println(a.toString()); 
    }
    System.out.println("\n");

    
    //Consulta 2
    resultatAE=gestor.articlesEnvasatsAmb("AIGUA MIN");

    System.out.println("Articles envasats en paquets");
    System.out.println("============================");


    for(ArticleEnvasat a: resultatAE){
       System.out.println(a.toString()); 
    }
    System.out.println("\n");

    
    
    //Consulta 3
    resultatAAG = gestor.articlesMesuratsEn("kg");


    System.out.println("Articles mesurats en kg");
    System.out.println("=======================");


    for(ArticleAGranel a: resultatAAG){ 
        System.out.println(a.toString()); 
    }
    System.out.println("\n");

    em.close();
    emf.close();
}


}