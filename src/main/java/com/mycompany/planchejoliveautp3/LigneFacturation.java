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
public class LigneFacturation extends Facture {
private String reference;
private int nombreExemplaireAcheté;
private float prixUnitaire;
private float prixTotal; 

LigneFacturation(String reference,int nombreExemplaireAcheté,float prixUnitaire,float prixTotal){
    this.reference=reference;
    this.nombreExemplaireAcheté=nombreExemplaireAcheté;
    this.prixUnitaire=prixUnitaire;
    this.prixTotal=prixTotal;
}



public  calculMontant(){
    float MontantLigneCalcul;
    MontantLigneCalcul=nombreExemplaireAcheté*prixUnitaire; 
    return MontantLigneCalcul;
}
    
}
