/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.planchejoliveautp3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Yann
 */
public class Facture {
    protected static int cptFactu = 0;
    private LocalDate dateDemission;
    private String mailClient;
    private double montantTotal;
    protected LigneFacturation[] tabLigneFacturation;

    
    public String emailToGet(){
        return(this.mailClient);
    }
    public Facture(String mailClient){
        this.tabLigneFacturation = new LigneFacturation [1000];
        this.mailClient = mailClient;
        this.dateDemission = LocalDate.now();
    }
    public Facture(String mailClient,LocalDate date){
        this.tabLigneFacturation = new LigneFacturation [1000];
        this.mailClient = mailClient;
        this.dateDemission = date;
    }
    
    public String toEmail(){
        return(this.mailClient);
    }
    
    public double toMontantTotal(){
        return(this.montantTotal);
    }
    
    public String toDate(){
        DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy mm dd");
        String date = this.dateDemission.format(form);
        return(date);
    }
    
    public void setTabLigneFactu(int i , LigneFacturation lf){
        this.tabLigneFacturation[i] = lf;
    }
    
    public void ajouterLigne() {
        Scanner clavier = new Scanner(System.in);
        System.out.println("Quelle est la référence du produit ?");
        String reference = clavier.nextLine();
        
        //Produit p = BDE.rechercher(); // appeler ajouter ligne dans bde pour pouvoir avoir un produit a partir de la ref 
        System.out.println("Quelle est la quantité du produit ?");
        int nombreExemplaireAcheté = clavier.nextInt();

        LigneFacturation NewLigneFacturation = new LigneFacturation(reference, nombreExemplaireAcheté);
    
        tabLigneFacturation[cptFactu] = NewLigneFacturation;
        cptFactu++;
    
    }
    public double caculMontant (){
        for(int i = 0 ; i<cptFactu;i++){
            montantTotal+=tabLigneFacturation[i].calculMontant();
        }
    return(montantTotal);
    }
    
    public String versFichier(){
        return mailClient+":"+dateDemission + System.lineSeparator()+ cptFactu ;
    }

        }        
