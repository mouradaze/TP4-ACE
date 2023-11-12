/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ma.aouzen.tpbanqueaouzen.jsf;

import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;
import ma.aouzen.tpbanqueaouzen.entity.CompteBancaire;
import ma.aouzen.tpbanqueaouzen.service.GestionnaireCompte;

/**
 *
 * @author PC
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {
    @Inject
    private GestionnaireCompte gc;

    /**
     * Creates a new instance of ListeComptes
     */
    public ListeComptes() {
    }
    
    public List<CompteBancaire> getAllComptes(){
        
        return gc.getAllComptes();
    }
    public String supprimerCompte(CompteBancaire compte) {
    gc.supprimer(compte);
    return "listeComptes?faces-redirect=true";
  }
    
}
