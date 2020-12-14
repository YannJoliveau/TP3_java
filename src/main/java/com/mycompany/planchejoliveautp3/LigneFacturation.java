/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.planchejoliveautp3;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 *
 * @author Yann
 */
public class LigneFacturation {

    private String reference;
    private int nombreExemplaireAcheté;
    private double prixUnitaire;
    private double prixTotal = this.nombreExemplaireAcheté * this.prixUnitaire;
    //Constructeur
    public LigneFacturation(String reference, int nombreExemplaireAcheté) {
        
        //this.prixUnitaire = produit.getPrix();
        this.prixTotal = this.prixUnitaire * this.nombreExemplaireAcheté;
        this.reference = reference;
        this.nombreExemplaireAcheté = nombreExemplaireAcheté;
        
        
    }
 
    public double calculMontant() {
        return (prixTotal);
    }
    //Methode vers fichier qui retourne un String des attribut le la Ligne facturation
    public String versFichier(){
        return nombreExemplaireAcheté+ ":" + reference + ":" + prixUnitaire + ":" + prixTotal;
    }
}
