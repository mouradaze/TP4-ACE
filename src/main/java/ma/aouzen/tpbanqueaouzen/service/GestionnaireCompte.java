/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.aouzen.tpbanqueaouzen.service;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import ma.aouzen.tpbanqueaouzen.entity.CompteBancaire;

/**
 *
 * @author PC
 */
@DataSourceDefinition (
    className="com.mysql.cj.jdbc.MysqlDataSource",
    name="java:app/jdbc/banque",
    serverName="localhost",
    portNumber=3306,
    user="root",              // nom et
    password="root", // mot de passe que vous avez donnés lors de la création de la base de données
    databaseName="banque",
    properties = {
      "useSSL=false",
      "allowPublicKeyRetrieval=true",
      "driverClass=com.mysql.cj.jdbc.Driver"
    }
)
@RequestScoped
public class GestionnaireCompte {
    @PersistenceContext(unitName = "banquePU")
    private EntityManager em;
    
    /**
     * Méthodes
     */
    public void creeCompte(CompteBancaire c){
        em.persist(c);
    }
    public List<CompteBancaire> getAllComptes(){
        Query query = em.createNamedQuery("Compte.findAll");
       return query.getResultList();
    }
}
