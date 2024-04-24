package org.example.chu_back_v0.bean.intervention.rapport_medicaux;


import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SyntheseMedicale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private LocalDateTime dateSyntheseMedicale;
    private String syntheseMedicale;
    @ManyToOne
    private Consultation consultation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public LocalDateTime getDateSyntheseMedicale() {
        return dateSyntheseMedicale;
    }

    public void setDateSyntheseMedicale(LocalDateTime dateSyntheseMedicale) {
        this.dateSyntheseMedicale = dateSyntheseMedicale;
    }

    public String getSyntheseMedicale() {
        return syntheseMedicale;
    }

    public void setSyntheseMedicale(String syntheseMedicale) {
        this.syntheseMedicale = syntheseMedicale;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
}
