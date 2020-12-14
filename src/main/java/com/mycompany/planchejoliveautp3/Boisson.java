/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.planchejoliveautp3;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;
/**
 *
 * @author Yann
 */
public class Boisson extends Produit {

    private static int cptRef = 1;
    
    private double contenance;
    private LocalDate dateConso; //date limite de consomation au format "mm yyyy"

    public Boisson(String designation, double prixVente, int stock, double contenance, LocalDate dateConso) {
        super(designation, prixVente, stock);
        this.contenance = contenance;
        this.dateConso = dateConso;
        this.initReference();
    }
    
    public void setReference(String ref){
        this.reference = ref;
    }
    
    protected void initReference() {
        this.reference = "B" + cptRef;
        cptRef++;
    }
    
    public LocalDate getDateConso(){
        return(this.dateConso);
    }

    public String versFichier(){
        return super.versFichier() + ":" + dateConso + ":" + contenance;
    }

}
