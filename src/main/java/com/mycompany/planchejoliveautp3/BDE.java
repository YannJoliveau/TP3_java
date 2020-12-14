/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.planchejoliveautp3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Yann
 */
public class BDE {
    //Creation des attributs
    private String nom;
    private int nbFacture;
    private int cptRetireProduit;
    private Produit[] tabProduitBDE;
    private Produit[] tabProduitRetire;
    private Facture[] tabFactureBDE;
    private int cptProduit = 0;
    //COstructeur
    public BDE(String nom) {
        this.tabFactureBDE = new Facture[1000];
        this.tabProduitBDE = new Produit[1000];
        this.nom = nom;

    }

    //Methode rechercher
    public Produit rechercher() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Quelle référence voulez vous trouver ?");
        String reference = clavier.nextLine();
        for (int i = 0; i < tabProduitBDE.length; i++) {//on test pour tout les produits du tableau si la ref est égale
            if (tabProduitBDE[i].reference.equals(reference)) {
                return tabProduitBDE[i];// on retourne le talbeau
            }
        }
        return (null);
    }

    public Produit rechercher(String reference) {//méthode rechercher surcharger
        for (int i = 0; i < tabProduitBDE.length; i++) {
            if (tabProduitBDE[i].reference.equals(reference)) {
                return tabProduitBDE[i];
            }
        }
        return (null);
    }
    
    public void ajouterStock() {
        Produit varProduit;
        varProduit = rechercher();//on recherche le produit a augmenter le stock
        Scanner clavier = new Scanner(System.in);
        System.out.println("Quel est le nombre de nombre d'exemplaires du produit ?");
        int stockEnPlus = clavier.nextInt(); //on récupère le nombre d'exemplaire a ajouter
        varProduit.setStock(varProduit.getStock() + stockEnPlus);// on ajoute au stock au stock déjà existant

    }

    public void ajouterproduitBoisson() {
        Scanner clavier = new Scanner(System.in);

        System.out.println("Quel type (désignation) de produit est-ce ?");
        String designation = clavier.nextLine();

        System.out.println("Quel est le prix de vente du nouveau produit ?");
        double prixVente = clavier.nextFloat();

        System.out.println("Quel est le stock du nouveau produit ?");
        int stock = clavier.nextInt();

        System.out.println("Ajoutez la contenance du nouveau produit");
        double contenance = clavier.nextFloat();

        System.out.println("Ajoutez la date limite du nouveau produit au format dd-MM-yyyy");
        String dateTapee = clavier.nextLine();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateConso = LocalDate.parse(dateTapee, dateFormat);//On transforme le string récuperer en Objet LocalDate 

        Boisson nouvelleBoisson = new Boisson(designation, prixVente, stock, contenance, dateConso);//on crée la nouvelle boisson

    }

    public void ajouterproduitDérivé() {
        Scanner clavier = new Scanner(System.in);

        System.out.println("Quel type (désignation) de produit est-ce ?");
        String designation = clavier.nextLine();

        System.out.println("Quel est le prix de vente du nouveau produit ?");
        double prixVente = clavier.nextFloat();

        System.out.println("Quel est le stock du nouveau produit ?");
        int stock = clavier.nextInt();
        ProduitDerive nouveauProduitDerive = new ProduitDerive(designation, prixVente, stock);//On crée le nouveau Produit
    }

    public void ajouterproduitDérivéTextile() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Quel type (désignation) de produit est-ce ?");
        String designation = clavier.nextLine();

        System.out.println("Quel est le prix de vente du nouveau produit ?");
        double prixVente = clavier.nextFloat();

        System.out.println("Quel est le stock du nouveau produit ?");
        int stock = clavier.nextInt();

        System.out.println("Quelle est l'année de mise en stock du nouveau produit ? au foramt yyyy spv.");
        int anneeMiseStock = clavier.nextInt();

        System.out.println("Quel est la couleur du nouveau produit ?");
        String couleur = clavier.nextLine();

        System.out.println("Quel est la taille du nouveau produit ?");
        int taille = clavier.nextInt();

        ProduitDeriveTextile nouveauProduitDeriveTextile = new ProduitDeriveTextile(designation, prixVente, stock, anneeMiseStock, couleur, taille);
    }//On crée le nouveau produit dérivé

    public void listerRetraitProduits() {
        for (int i = 0; i < tabProduitBDE.length; i++) {
            if (tabProduitBDE[i].estAretirer()) {// on appel la méthode est a retirer qui vérifie si un produt est a retirer
                tabProduitBDE[i] = tabProduitRetire[cptRetireProduit];//on copie l'élement du tableau a retirer dans un tableau d'élement retirer
                tabProduitBDE[i] = null;//on remplace l'élement par une case vide
                cptRetireProduit++;// on indente le compteur du tableau d'élement retirer

            }
        }
        for (int j = 0; j < tabProduitRetire.length; j++) {
            System.out.print(tabProduitRetire[j].getDesignation());//On affiche les éléments retirer
        }

    }
//Méthode permetant d'ajouter une facture dans le tableau de facture
    public void ajouterFacture(Facture facture) {
        tabFactureBDE[nbFacture] = facture;
        nbFacture++;
    }
    //méthode permettant de recuperer les factures d'un client a partir de son email
    public void listerFacturesClient(String emailCompare) {
        for (int j = 0; j < nbFacture; j++) {
            int var = emailCompare.compareTo(tabFactureBDE[j].emailToGet());
            if (var == 0) {
                System.out.print(tabFactureBDE[j].toDate() + tabFactureBDE[j].toEmail() + tabFactureBDE[j].toMontantTotal());
            }
        }
    }
//Méthode d'engeristrement des produits dans un ficher
    public void versFichiersProduits() throws IOException {
        FileWriter fichier = new FileWriter("FichierProduits.txt");//On dit au code quel fichier utiliser
        for (int i = 0; i < cptProduit; i++) {
            Produit p = tabProduitBDE[i];
            String informations = p.versFichier();//on transforme le produit en string
            fichier.write(informations + System.lineSeparator()); //on écrit les infos dans le doc
        }
        fichier.flush();
        fichier.close();
    }
//meme chose que pour versFichierProduits
    public void versFichiersFactures() throws IOException {
        FileWriter sortie = new FileWriter("FicchierFactures.txt");
        int cpt = 1;
        for (int i = 0; i < nbFacture; i++) {
            Facture f = tabFactureBDE[i];
            sortie.write(cpt + System.lineSeparator());
            cpt++;
            String infos = f.versFichier();
            sortie.write(infos + System.lineSeparator());
            for (int j = 0; j < f.cptFactu; j++) {
                infos = f.tabLigneFacturation[j].versFichier();
                sortie.write(infos + System.lineSeparator());
            }

        }
    }
//méthode permettant de recuperer les infos dans le fichier
    public void depuisFichierProduits() throws IOException {
        
        FileReader entree = new FileReader("FichierProduits.txt");//on lui dit quel fichier utiliser
        BufferedReader br = new BufferedReader(entree);
        
        String ref = br.readLine();//on lui dit de recuperer la reference
        
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy mm dd");//On crée le format de date
        int cpt = 0;

        while (ref != null) {//tant que l'on a pas fait tout les produit dans notre fichier
            String ligne = br.readLine();//On récupère la ligne d'info
            String tabvar[] = ligne.split(":");// sépare la phrase du fichier dès qu'il y a : 

            switch (ref.charAt(0)) {//On teste les différentes types de produits
                
                case 'B':
                    
                    Boisson b = new Boisson(tabvar[0], Double.parseDouble(tabvar[1]), Integer.parseInt(tabvar[2]), Float.parseFloat(tabvar[3]) ,LocalDate.parse(tabvar[4], f));
                    b.setReference(ref);//Crée le produit Boisson avec infos récuprer dans le tableau tabvar.
                    tabProduitBDE[cpt] = b;//On met le produit dans le talbeau de produit
                    break;
                case 'D':
                    
                    ProduitDerive produitd = new ProduitDerive(tabvar[0], Double.parseDouble(tabvar[1]), Integer.parseInt(tabvar[2]));
                    produitd.setReference(ref);//meme explication que plus haut
                    tabProduitBDE[cpt] = produitd;
                    break;
                case 'T':
                    
                    ProduitDeriveTextile produitT = new ProduitDeriveTextile(tabvar[0], Double.parseDouble(tabvar[1]), Integer.parseInt(tabvar[2]), Integer.parseInt(tabvar[3]), tabvar[4], Integer.parseInt(tabvar[5]));
                    produitT.setReference(ref);//meme explication que plus haut
                    tabProduitBDE[cpt] = produitT;
                    break;
            }
            ref = br.readLine();
            
            cpt++;
        }
        cptProduit = cpt;
    }

    public void depuisFichierFacture() throws IOException {//meme principe que la méthode d'avant
        this.nbFacture = 0;
        FileReader entree = new FileReader("FicchierFactures.txt");
        BufferedReader br = new BufferedReader(entree);
        String ref = br.readLine();
        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("yyyy mm dd");
        while (ref != null){
            String ligne = br.readLine();
            String tabvar[] = ligne.split(":");// sépare la phrase du fichier dès qu'il y a :
            LocalDate dateF = LocalDate.parse(tabvar[1], f2);
            Facture f = new Facture(tabvar[0], dateF);
            int nbreprod = Integer.parseInt(br.readLine());
            for(int i = 0 ;i<nbreprod; i++){
                String ligneListeFactu = br.readLine();
                String tabvarLigneFactu[] = ligne.split(":");
                LigneFacturation LigneFacturation = new LigneFacturation(tabvarLigneFactu[1],Integer.parseInt(tabvarLigneFactu[0]));
                f.setTabLigneFactu(i,LigneFacturation);
               
            }
            this.tabFactureBDE[nbFacture]= f;
            nbFacture++;
        }
        
    }
}


