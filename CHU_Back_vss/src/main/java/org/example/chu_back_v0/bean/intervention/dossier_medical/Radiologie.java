package org.example.chu_back_v0.bean.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Radiologie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private LocalDateTime dateRadiologie;
    private String commentaire;
    private String imageScann;
    @ManyToOne
    private TypeImage typeImage;
    @ManyToOne
    private Consultation consultation;

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }

    public LocalDateTime getDateRadiologie() {
        return dateRadiologie;
    }

    public void setDateRadiologie(LocalDateTime dateRadiologie) {
        this.dateRadiologie = dateRadiologie;
    }



    public Consultation getIntervention() {
        return consultation;
    }

    public void setIntervention(Consultation consultation) {
        this.consultation = consultation;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }


    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getImageScann() {
        return imageScann;
    }

    public void setImageScann(String imageScann) {
        this.imageScann = imageScann;
    }

    public TypeImage getTypeImage() {
        return typeImage;
    }

    public void setTypeImage(TypeImage typeImage) {
        this.typeImage = typeImage;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
