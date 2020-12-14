/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.planchejoliveautp3;
import java.text.SimpleDateFormat;
/**
 *
 * @author Yann
 */
public class ProduitDerive extends Produit{
    
    private static int cptRef = 1;
    
    public ProduitDerive (String designation,double prixVente, int stock ){
        super(designation ,prixVente ,stock);
        initReference();
    }
    
    
    public void setReference(String ref){
        this.reference = ref;
    }
    protected void initReference(){
        this.reference = "D"+cptRef;
        cptRef++;
    }
    public String versFichier(){
        return super.versFichier();
    }

}
