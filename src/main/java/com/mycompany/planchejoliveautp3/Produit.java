/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.planchejoliveautp3;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Yann Jolivea Amélie Planche
 */
public abstract class Produit {

    protected String reference;
    private String designation;
    private double prixVente;
    private int stock;
    //Getters et Setters
    public String getDesignation(){
        return(this.designation);
    }
    public String getReference(){
        return(this.reference);
    }
    
    public int getStock(){
        return(this.stock);
    }
    
    public void setStock(int newStock){
        this.stock = newStock;
    } 
    
    public double getPrix(){
        return(this.prixVente);
    }
    
    public Produit(String designation, double prixVente, int stock) {
        this.designation = designation;
        this.prixVente = prixVente;
        this.stock = stock;
    }
    //Création méthode abstraite pour les calss fille de produit
    protected abstract void initReference();
    
    public boolean placerApres(Produit produit) {
        String myRef = this.reference;
        String refToCompare = produit.reference;//On récupère la ref du produit appelé
        int temp = myRef.compareTo(refToCompare); //On compare la ref avec laquel on appel et la ref en entrée de la méthode
        if (temp < 0) {//on teste pour voir si il est placer après
            return (false);
        } else {
            return (true);
        }

    }


    
    public double calculPrix() {
        LocalDate date1 = LocalDate.now();//On crée la date
        DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy mm dd");
        String date = date1.format(form);
        String moisStr = date.substring(5, 7);//On récupère le mois
        int mois = Integer.parseInt(moisStr);
        System.out.print(mois);

       
        boolean isBoisson = (this.getClass() == Boisson.class);//Bolleans qui permetent de tester la calss de l'objet appelant
        boolean isProduitDeriveTextile = (this.getClass() == ProduitDeriveTextile.class);
        boolean isProduitDerive = (this.getClass() == ProduitDerive.class);
        if (isBoisson) {
            Boisson b = (Boisson) this;// On teste si le boolean est vrai
            //Moins d' mois de la date de péremption
            if(b.getDateConso().plusMonths(1).isAfter(LocalDate.now())){
                return(b.getPrix() * 0.6);//On retourne le prix avec la reduction
            }
        } else if (isProduitDerive) {//meme schéma que plus haut
            if (mois == 12) {
                return(prixVente - (prixVente * 0.1));
            }
        } else if (isProduitDeriveTextile) {
            if (mois == 06) {
                return(prixVente - (prixVente * 0.2));
            }
        }
        return(prixVente);// si il n'y a acune rédution a ajouter on retourne le prix de base
        
    }

    public void ajouterStock() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Combien de produits voulez vous ajouter au stock");
        int produitsSuppl = clavier.nextInt();
        stock = stock + produitsSuppl;//On ajoute le stock suplémentaire au stock déjà existant
        System.out.println("Vous venez d'ajouter " + produitsSuppl + " produits au stock qui contient mainetenant" + stock + "produits");

    }

    public void retirerStock() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Combien de produits voulez vous retirer du stock");
        int produitsSuppl = clavier.nextInt();
        stock = stock - produitsSuppl;//on retire le stock a retirer
        System.out.println("Vous venez de retirer " + produitsSuppl + " produits du stock qui contient mainetenant" + stock + "produits");

    }
    public boolean estAretirer(){
        boolean isBoisson = (this.getClass() == Boisson.class);//meme principe que plus haut pour les booleans
        boolean isProduitDeriveTextile = (this.getClass() == ProduitDeriveTextile.class);
        boolean isProduitDerive = (this.getClass() == ProduitDerive.class);
        LocalDate dateNow = LocalDate.now();//On recupère la date
        
        if(isBoisson){//Si c'est une boission on regarde si la date de conso est après la date du jour si c'est le cas on la retire
            Boisson b = (Boisson) this;
            if(b.getDateConso().isAfter(dateNow)){
                return(true);
            }
        }
        
        else if (isProduitDeriveTextile){//Meme principe que pour une boission mais on regarde si l'année de mise en stock+4 est inférieure a l'année du jour
            ProduitDeriveTextile t = (ProduitDeriveTextile) this;
            int anneeNow = dateNow.getYear();
            if(t.getAnneeMiseStock()+4 < anneeNow){
                return(true);
            }}
        return(false);
        }
//On transforme les infos du produit en string
    public String versFichier(){
        return reference + System.lineSeparator() + designation + ":" + prixVente + ":" + stock;
    }

}

