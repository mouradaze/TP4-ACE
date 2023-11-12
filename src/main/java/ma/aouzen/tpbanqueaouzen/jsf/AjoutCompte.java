/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ma.aouzen.tpbanqueaouzen.jsf;


import ma.aouzen.tpbanqueaouzen.service.GestionnaireCompte;
import ma.aouzen.tpbanqueaouzen.entity.CompteBancaire;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

/**
 * @author PC
 */
@Named(value = "ajout")
@RequestScoped
public class AjoutCompte {
    
  @Inject
  private GestionnaireCompte gestionnaireCompte;
  
  private String nom;
  private int solde;

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public int getSolde() {
    return solde;
  }

  public void setSolde(int solde) {
    this.solde = solde;
  }

  public String creer() {
    gestionnaireCompte.creerCompte(new CompteBancaire(nom, solde));
    return "listeComptes?faces-redirect=true";
  }
  
  
}