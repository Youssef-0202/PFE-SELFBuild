package org.example.chu_back_v0.bean.intervention.gestion_medicale;


import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ordonnance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String hospitaleName;
    private String hospitalAdresse;
    private LocalDateTime dateOrdonnance;
    private String signature;
    @ManyToOne
    private Consultation consultation;

    public LocalDateTime getDateOrdonnance() {
        return dateOrdonnance;
    }

    public void setDateOrdonnance(LocalDateTime dateOrdonnance) {
        this.dateOrdonnance = dateOrdonnance;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
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

    public String getHospitaleName() {
        return hospitaleName;
    }

    public void setHospitaleName(String hospitaleName) {
        this.hospitaleName = hospitaleName;
    }

    public String getHospitalAdresse() {
        return hospitalAdresse;
    }

    public void setHospitalAdresse(String hospitalAdresse) {
        this.hospitalAdresse = hospitalAdresse;
    }


    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

}
