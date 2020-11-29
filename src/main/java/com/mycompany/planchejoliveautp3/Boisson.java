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
public class Boisson extends Produit{
    private float contenance;
    private String date; 
public Boisson (String designation,float prixVente, int stock ,float contenance,String date) {
    super(designation ,prixVente ,stock );
    this.contenance = contenance;
    this.date = date;
    
    
}




}
