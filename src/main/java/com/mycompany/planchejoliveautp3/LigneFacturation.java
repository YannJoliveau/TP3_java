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
public class LigneFacturation {
private int reference;
private int nombreExemplaireAcheté;
private float prixUnitaire;
private float prixTotal; 

LigneFacturation(int reference,int nombreExemplaireAcheté,float prixUnitaire,float prixTotal){
    this.reference=reference;
    this.nombreExemplaireAcheté=nombreExemplaireAcheté;
    this.prixUnitaire=prixUnitaire;
    this.prixTotal=prixTotal;
}



public void calculMontant(){
    float MontantLigneCalcul;
    MontantLigneCalcul=nombreExemplaireAcheté*prixUnitaire;  
}
    
}
