/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.planchejoliveautp3;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter ;
import java.util.Scanner;
/**
 *
 * @author Yann Jolivea Amélie Planche
 */
public class Produit {
private String reference ;
private String designation;
private float prixVente;
private int stock;

public Produit (String designation,float prixVente, int stock ){
    this.designation = designation;
    this.prixVente = prixVente;
    this.stock = stock;
}

public boolean placerApres(String reference ){
float temp = 0;
    temp=reference.compareTo(this.reference); // a tester lequel est avant l'autre dans l'ordre alphabétique. 
    if (temp<0){
        return (true);
       
    }else if (temp>0){
        return (false);
    }else{
       return (false); 
    }

} 
LocalDate date1 = LocalDate.now();
DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy mm dd"); 
String text = date1.format(form);

//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//String dateStr = simpleDateFormat.format(new Date()); 
//System.out.println(dateStr);

public void calculPrix(){// pas de retour nécessaire il suffit de modifier le this.prix
     LocalDate date1 = LocalDate.now();
    DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyy mm dd"); 
    String date = date1.format(form);
    String moisStr = date.substring(5,7);
    int mois = Integer.parseInt(moisStr);
    System.out.print(mois);
    
    String PremLettre = reference.substring(0,1);
    if (PremLettre.equals("B")){
        
    }else if (PremLettre.equals("D")){
        if (mois == 11){
           float prix = (float) (prixVente - (prixVente*0.1)) ;
        this.prixVente=prix ;
        }
    }else if (PremLettre.equals("T")){
        if (mois == 06){
           float prix ;
            prix = (float) (prixVente - (prixVente*0.2));
            this.prixVente=prix;
        }
    }
}
   public void ajouterStock (){
    Scanner clavier=new Scanner(System.in);
    System.out.println("Combien de produits voulez vous ajouter au stock");
    int produitsSuppl= clavier.nextInt();
    stock=stock+produitsSuppl;
    System.out.println("Vous venez d'ajouter "+produitsSuppl+" produits au stock qui contient mainetenant"+stock+"produits");  
    
}



public void retirerStock(){
    Scanner clavier=new Scanner(System.in);
    System.out.println("Combien de produits voulez vous retirer du stock");
    int produitsSuppl= clavier.nextInt();
    stock=stock-produitsSuppl;
    System.out.println("Vous venez de retirer "+produitsSuppl+" produits du stock qui contient mainetenant"+stock+"produits");  
    
}


}

