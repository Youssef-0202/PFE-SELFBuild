package org.example.chu_back_v0.bean.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;

import javax.persistence.*;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class AnalyseMedicale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private LocalDateTime dateAnalyse;
    private float valeur;
    private String valeurRang;
    @ManyToOne
    private Consultation consultation;

    @ManyToOne
    private Epreuve epreuve;


    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }



    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }



    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }




    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public String getValeurRang() {
        return valeurRang;
    }

    public void setValeurRang(String valeurRang) {
        this.valeurRang = valeurRang;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateAnalyse() {
        return dateAnalyse;
    }

    public void setDateAnalyse(LocalDateTime dateAnalyse) {
        this.dateAnalyse = dateAnalyse;
    }
}
