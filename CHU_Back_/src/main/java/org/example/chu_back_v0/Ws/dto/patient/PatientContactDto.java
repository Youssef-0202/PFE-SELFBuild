package org.example.chu_back_v0.Ws.dto.patient;


import org.example.chu_back_v0.bean.patient.Relation;

import javax.persistence.ManyToOne;

public class PatientContactDto {
    private Long id;
    private String cin;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String adresse;

    private RelationDto relationDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public RelationDto getRelationDto() {
        return relationDto;
    }

    public void setRelationDto(RelationDto relationDto) {
        this.relationDto = relationDto;
    }
}
