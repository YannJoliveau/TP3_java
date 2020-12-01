/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.planchejoliveautp3;

import java.util.Scanner;

/**
 *
 * @author Yann
 */
public class Facture extends BDE{
private String mailClient;
private float montantTotal;
public LigneFacturation tabLigneFacturation[]  ; 

public int ajouterLigne(){
    float prixUnitaire;
    Scanner clavier = new Scanner(System.in);
    System.out.println("Quelle est la référence du produit ?");
    String reference=clavier.nextLine();
    Produit varProduit=BDE.rechercher(reference);
    prixUnitaire= varProduit.prixVente;
        if (varProduit==null){
        System.out.println("La référence n'existe pas.");
        return (0);
    }
        System.out.println("Quelle est la quantité du produit ?");
    int nombreExemplaireAcheté = clavier. nextInt();
    float prixTotal;
    prixTotal=LigneFacturation.MontantTotal();
    int i =(tabLigneFacturation.length) +1;
    tabLigneFacturation[i]=new LigneFacturation(reference,nombreExemplaireAcheté,prixUnitaire,prixTotal);   
}
public void calculMontant(){
    
}
}
