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
public class BDE {
private String nom;

private Produit [] tabProduitBDE;
private Facture [] tabFactureBDE;

public Produits rechercher(){
    Scanner clavier= new Scanner (System.in);
    System.out.println("Quelle référence ?");
    String reference= clavier.nextLine();
            for (int i=0; i<tabProduitBDE.length-1;i++){
                if (tabProduitBDE[i].reference.equals(reference) ){
                return tabProduitBDE[i];

     }
           
} 
            return (null); 
}


public void ajouterStock(){
    Produits varProduit;
    varProduit=rechercher();
    Scanner clavier= new Scanner (System.in);
    System.out.println("Quel est le nombre de nombre d'exemplaires du produit ?");
    int stockEnPlus= clavier.nextInt();
    varProduit.stock=varProduit.stock+stockEnPlus;

    
}
ublic Produits ajouterproduitBoisson (){
    Scanner clavier= new Scanner(System.in);
    Boisson  boisson= new Boisson();
    System.out.println("Ajoutez la désignation du nouveau produit");
    int i = (tabProduitBDE.length)+1;
    String varDesignation =clavier.nextLine();
    tabProduitBDE[i]=varDesignation;
    System.out.println("Ajoutez le prix de vente du nouveau produit");
    tabProduitBDE[1]=prix;
    System.out.println("Ajoutez le stock du nouveau produit");
    tabProduitBDE[2]=stock;
    System.out.println("Ajoutez la date limite du nouveau produit");
    tabProduitBDE[3]= String date;
    System.out.println("Ajoutez la contenance du nouveau produit");
    int Boisson.contenance =clavier.nextInt;
    
    }

  public Produit ajouterproduitDérivé (){
        Scanner clavier= new Scanner(System.in);
        System.out.println("Ajoutez la désignation du nouveau produit");
        String designation =clavier.nextLine;
        System.out.println("Ajoutez le prix de vente du nouveau produit");
        float Produits.prix =clavier.nextFloat;
        System.out.println("Ajoutez le stock du nouveau produit");
        int Produits.stock =clavier.nextInt;
}
    }

