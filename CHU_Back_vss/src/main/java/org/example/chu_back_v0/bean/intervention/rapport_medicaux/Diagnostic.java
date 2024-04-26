package org.example.chu_back_v0.bean.intervention.rapport_medicaux;


import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Diagnostic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private Date dateDiagnostic;
    private String diagnostic;

    @ManyToOne
    private Consultation consultation;

    public Date getDateDiagnostic() {
        return dateDiagnostic;
    }

    public void setDateDiagnostic(Date dateDiagnostic) {
        this.dateDiagnostic = dateDiagnostic;
    }



    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public Consultation getIntervention() {
        return consultation;
    }

    public void setIntervention(Consultation consultation) {
        this.consultation = consultation;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
