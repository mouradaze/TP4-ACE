/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ma.aouzen.tpbanqueaouzen.jsf;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import ma.aouzen.tpbanqueaouzen.entity.CompteBancaire;
import ma.aouzen.tpbanqueaouzen.entity.OperationBancaire;
import ma.aouzen.tpbanqueaouzen.service.GestionnaireCompte;

/**
 *
 * @author PC
 */
@Named(value = "listOperations")
@RequestScoped
public class ListeOperations {

    @Inject
  private GestionnaireCompte gestionnaireCompte;

  private Long idCompteBancaire;
  private CompteBancaire compte;

  public ListeOperations() {
  }

  public Long getIdCompteBancaire() {
    return idCompteBancaire;
  }

  public void setIdCompteBancaire(Long idCompteBancaire) {
    this.idCompteBancaire = idCompteBancaire;
  }

  public List<OperationBancaire> getOperations() {
    return compte.getOperations();
  }

  public void setCompte() {
    compte = gestionnaireCompte.findById(idCompteBancaire);
  }

  public CompteBancaire getCompte() {
    return compte;
  }
    
}
