package org.example.chu_back_v0.bean.intervention.gestion_medicale;



import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;

import javax.persistence.*;
import java.util.List;

@Entity
public class Traitement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String imageOrdonnance;
    @OneToMany
    private List<Medicament> Medicaments;
    @ManyToOne
    private Consultation consultation;

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public String getImageOrdonnance() {
        return imageOrdonnance;
    }

    public void setImageOrdonnance(String imageOrdonnance) {
        this.imageOrdonnance = imageOrdonnance;
    }

    public List<Medicament> getMedicaments() {
        return Medicaments;
    }

    public void setMedicaments(List<Medicament> medicaments) {
        Medicaments = medicaments;
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
