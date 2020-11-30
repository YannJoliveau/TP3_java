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
public class Facture {
private String mailClient;
private float montantTotal;

public Produit [] tabProduitAchete; 

public void ajouterLigne(){
    Scanner clavier = new Scanner(System.in);
    System.out.println("Quelle est la référence du produit ?");
    int reference=clavier.nextInt();
    Produit produit = BDE.rechercher();
        System.out.println("Quelle est la quantité du produit ?");
    int nombreExemplaireAcheté = clavier. nextInt();

    LigneFacturation NewLigneFacturation = new LigneFacturation (reference,nombreExemplaireAcheté,prixUnitaire,prixTotal);   
}
public void calculMontant(){
    
}
}
