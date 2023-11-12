/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ma.aouzen.tpbanqueaouzen.jsf;

import ma.aouzen.tpbanqueaouzen.service.GestionnaireCompte;
import ma.aouzen.tpbanqueaouzen.entity.CompteBancaire;
import jakarta.ejb.EJBTransactionRolledbackException;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

/**
 * Backing bean pour la page transfert.xhtml.
 */
@Named(value = "transfert")
@RequestScoped
public class Transfert {

    @Inject
    private GestionnaireCompte gestionnaireCompte;

    private long idSource;
    private long idDestination;
    private int montant;

    public long getIdSource() {
        return idSource;
    }

    public void setIdSource(long id) {
        this.idSource = id;
    }

    public long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(long id) {
        this.idDestination = id;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String enregistrer() {
        boolean erreur = false;

        CompteBancaire source = gestionnaireCompte.findById(idSource);
        if (source == null) {
            erreur = true;
        } else {
        }

        CompteBancaire destination = gestionnaireCompte.findById(idDestination);
        if (destination == null) {
            erreur = true;
        }

        if (erreur) {
            return null;
        }
        try {
            gestionnaireCompte.transferer(source, destination, montant);

            return "listeComptes?faces-redirect=true";
        } catch (EJBTransactionRolledbackException ex) {
            return null;
        }
    }
}
