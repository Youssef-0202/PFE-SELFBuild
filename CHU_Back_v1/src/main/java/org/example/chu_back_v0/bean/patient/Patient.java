package org.example.chu_back_v0.bean.patient;

import org.example.chu_back_v0.bean.commun.Sexe;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numDossier;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String photoProfil;
    private String Ville;
    @ManyToOne
    private Sexe sexe;
    @ManyToOne
    private PatientContact passionContact;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumDossier() {
        return numDossier;
    }

    public void setNumDossier(String numDossier) {
        this.numDossier = numDossier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPhotoProfil() {
        return photoProfil;
    }

    public void setPhotoProfil(String photoProfil) {
        this.photoProfil = photoProfil;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public PatientContact getPassionContact() {
        return passionContact;
    }

    public void setPassionContact(PatientContact passionContact) {
        this.passionContact = passionContact;
    }
}
