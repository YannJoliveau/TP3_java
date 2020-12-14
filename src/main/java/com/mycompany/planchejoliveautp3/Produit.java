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
    
    protected abstract void initReference();

    public boolean placerApres(Produit produit) {
        String myRef = this.reference;
        String refToCompare = produit.reference;
        int temp = myRef.compareTo(refToCompare); // a tester lequel est avant l'autre dans l'ordre alphabétique. 
        if (temp < 0) {
            return (false);
        } else {
            return (true);
        }

    }


    
    public double calculPrix() {
        LocalDate date1 = LocalDate.now();
        DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy mm dd");
        String date = date1.format(form);
        String moisStr = date.substring(5, 7);
        int mois = Integer.parseInt(moisStr);
        System.out.print(mois);

       
        boolean isBoisson = (this.getClass() == Boisson.class);
        boolean isProduitDeriveTextile = (this.getClass() == ProduitDeriveTextile.class);
        boolean isProduitDerive = (this.getClass() == ProduitDerive.class);
        if (isBoisson) {
            Boisson b = (Boisson) this;
            //Moins d' mois de la date de péremption
            if(b.getDateConso().plusMonths(1).isAfter(LocalDate.now())){
                return(b.getPrix() * 0.6);
            }
        } else if (isProduitDerive) {
            if (mois == 12) {
                return(prixVente - (prixVente * 0.1));
            }
        } else if (isProduitDeriveTextile) {
            if (mois == 06) {
                return(prixVente - (prixVente * 0.2));
            }
        }
        return(prixVente);
        
    }

    public void ajouterStock() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Combien de produits voulez vous ajouter au stock");
        int produitsSuppl = clavier.nextInt();
        stock = stock + produitsSuppl;
        System.out.println("Vous venez d'ajouter " + produitsSuppl + " produits au stock qui contient mainetenant" + stock + "produits");

    }

    public void retirerStock() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Combien de produits voulez vous retirer du stock");
        int produitsSuppl = clavier.nextInt();
        stock = stock - produitsSuppl;
        System.out.println("Vous venez de retirer " + produitsSuppl + " produits du stock qui contient mainetenant" + stock + "produits");

    }
    public boolean estAretirer(){
        boolean isBoisson = (this.getClass() == Boisson.class);
        boolean isProduitDeriveTextile = (this.getClass() == ProduitDeriveTextile.class);
        boolean isProduitDerive = (this.getClass() == ProduitDerive.class);
        LocalDate dateNow = LocalDate.now();
        
        if(isBoisson){
            Boisson b = (Boisson) this;
            if(b.getDateConso().isAfter(dateNow)){
                return(true);
            }
        }
        
        else if (isProduitDeriveTextile){
            ProduitDeriveTextile t = (ProduitDeriveTextile) this;
            int anneeNow = dateNow.getYear();
            if(t.getAnneeMiseStock()+4 < anneeNow){
                return(true);
            }}
        return(false);
        }

    public String versFichier(){
        return reference + System.lineSeparator() + designation + ":" + prixVente + ":" + stock;
    }

}

