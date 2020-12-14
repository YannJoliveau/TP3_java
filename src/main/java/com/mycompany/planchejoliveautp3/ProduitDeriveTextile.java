/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.planchejoliveautp3;

/**
 *
 * @author Yann
 */
public class ProduitDeriveTextile extends Produit {
    private static int cptRef = 1;
    private int taille ;
    private String couleur;
    private int anneeMiseStock;

    public int getAnneeMiseStock(){
        return(this.anneeMiseStock);
    }
public ProduitDeriveTextile (String designation,double prixVente, int stock ,int anneeMiseStock, String couleur,int taille ){
    super( designation ,prixVente ,stock );
this.taille = taille;
        this.couleur = couleur;
        this.anneeMiseStock = anneeMiseStock;
        this.cptRef = 0;
}//Méthode permettant de crée la reference
    protected void initReference(){
        this.reference = "D"+cptRef;
        cptRef++;
    }
//methode envoyant les info du produit vers un string
    public String versFichier(){
        return super.versFichier()+ ":" + taille + ":" + couleur + ":" + anneeMiseStock;
    }
    //setter de reference 
    public void setReference(String ref){
        this.reference = ref;
    }


}
