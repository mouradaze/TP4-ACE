/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ma.aouzen.tpbanqueaouzen.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletContext;
import ma.aouzen.tpbanqueaouzen.entitys.CompteBancaire;
import ma.aouzen.tpbanqueaouzen.service.GestionnaireCompte;

/**
 *
 * @author PC
 */
@Named(value = "init")
@ApplicationScoped
public class Init {
    @Inject
    private GestionnaireCompte gc;

    public void start(@Observes
            @Initialized(ApplicationScoped.class) ServletContext context) {
        gc.creeCompte(new CompteBancaire("John Lennon",150000 ));
        gc.creeCompte(new CompteBancaire("Paul McCartney",9500000 ));
        gc.creeCompte(new CompteBancaire("Ringo Starr",20000));
        gc.creeCompte(new CompteBancaire("Georges Harrisson",100000 ));
        
    }

    /**
     * Creates a new instance of Init
     */
    public Init() {
    }

}
