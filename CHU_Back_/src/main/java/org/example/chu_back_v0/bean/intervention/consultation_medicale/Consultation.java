package org.example.chu_back_v0.bean.intervention.consultation_medicale;

import org.example.chu_back_v0.bean.commun.Infermier;
import org.example.chu_back_v0.bean.commun.Medecin;
import org.example.chu_back_v0.bean.patient.Patient;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String avisMedicale;
    private Date dateConsultation;
    private Date heureConsultation;
    private String typeConsultation;
    @ManyToOne
    private Medecin medecin;
    @ManyToOne
    private Infermier infermier;
    @ManyToOne
    private Patient patient;

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public Date getHeureConsultation() {
        return heureConsultation;
    }

    public void setHeureConsultation(Date heureConsultation) {
        this.heureConsultation = heureConsultation;
    }

    public String getTypeConsultation() {
        return typeConsultation;
    }

    public void setTypeConsultation(String typeConsultation) {
        this.typeConsultation = typeConsultation;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Infermier getInfermier() {
        return infermier;
    }

    public void setInfermier(Infermier infermier) {
        this.infermier = infermier;
    }



    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getAvisMedicale() {
        return avisMedicale;
    }

    public void setAvisMedicale(String avisMedicale) {
        this.avisMedicale = avisMedicale;
    }


    public Medecin getMedcin() {
        return medecin;
    }

    public void setMedcin(Medecin medecin) {
        this.medecin = medecin;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

 /* @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_trait_id")
    private Traitement traitement;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_ord_id")
    private Ordonnance ordonnance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_cert_id")
    private Certificat certificat;*/
