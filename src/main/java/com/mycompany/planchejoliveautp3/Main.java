/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.planchejoliveautp3;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/**
 *
 * @author Yann
 */
public class Main {
    
    public static void main(String args[]) throws IOException {
        BDE BDE = new BDE("BDE");//Creation du BDE
        
        
        //On appel la focntion por récuperer les infos des produits de la base de donnée
            BDE.depuisFichierProduits();
            BDE.depuisFichierFacture();
            //tentative de faire une interface mais manque de temps a cause de la semaine controle
        boolean var = true;
        while(var){
            Scanner sc = new Scanner(System.in);
            System.out.println("Voulez vous crée un Produit ? O/N");
            String Rep = sc.nextLine();
            
            
        }
        
        //enregistrement des infos de produtis et des factures
        BDE.versFichiersProduits();
        BDE.versFichiersFactures();
        
    }
    
}
