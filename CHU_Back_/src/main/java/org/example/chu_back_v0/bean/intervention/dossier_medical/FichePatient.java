package org.example.chu_back_v0.bean.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class FichePatient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String ref;
    private LocalDateTime dateFichePatient;
    @ManyToOne
    private Antecedent antecedent;
    private String antecedentFamilial;
    private String histoireMaladie;
    private String examenFichePatient;
    private String conclusionFichePatient;
    @ManyToOne
    private Consultation consultation;

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Antecedent getAntecedent() {
        return antecedent;
    }

    public void setAntecedent(Antecedent antecedent) {
        this.antecedent = antecedent;
    }

    public Consultation getIntervention() {
        return consultation;
    }

    public void setIntervention(Consultation consultation) {
        this.consultation = consultation;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public LocalDateTime getdateFichePatient() {
        return dateFichePatient;
    }

    public void setdateFichePatient(LocalDateTime dateFichePatient) {
        this.dateFichePatient = dateFichePatient;
    }

    public String getAntecedentFamilial() {
        return antecedentFamilial;
    }

    public void setAntecedentFamilial(String antecedentFamilial) {
        this.antecedentFamilial = antecedentFamilial;
    }

    public String getHistoireMaladie() {
        return histoireMaladie;
    }

    public void setHistoireMaladie(String histoireMaladie) {
        this.histoireMaladie = histoireMaladie;
    }

    public LocalDateTime getDateFichePatient() {
        return dateFichePatient;
    }

    public void setDateFichePatient(LocalDateTime dateFichePatient) {
        this.dateFichePatient = dateFichePatient;
    }

    public String getExamenFichePatient() {
        return examenFichePatient;
    }

    public void setExamenFichePatient(String examenFichePatient) {
        this.examenFichePatient = examenFichePatient;
    }

    public String getConclusionFichePatient() {
        return conclusionFichePatient;
    }

    public void setConclusionFichePatient(String conclusionFichePatient) {
        this.conclusionFichePatient = conclusionFichePatient;
    }
}


