package org.example.chu_back_v0.Ws.dto.patient;

import org.example.chu_back_v0.Ws.dto.commun.SexeDto;
import org.example.chu_back_v0.bean.commun.Sexe;
import org.example.chu_back_v0.bean.patient.PatientContact;

import javax.persistence.ManyToOne;
import java.util.Date;

public class PatientDto {
    private Long id;
    private String numDossier;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String photoProfil;
    private String Ville;
    private SexeDto sexeDto;
    private PatientContactDto passionContactDto;

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

    public SexeDto getSexeDto() {
        return sexeDto;
    }

    public void setSexeDto(SexeDto sexeDto) {
        this.sexeDto = sexeDto;
    }

    public PatientContactDto getPassionContactDto() {
        return passionContactDto;
    }

    public void setPassionContactDto(PatientContactDto passionContactDto) {
        this.passionContactDto = passionContactDto;
    }
}
