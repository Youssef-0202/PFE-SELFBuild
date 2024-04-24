package org.example.chu_back_v0.Ws.dto.intervention.dossier_medical;

import org.example.chu_back_v0.Ws.dto.intervention.consultation_medicale.ConsultationDto;
import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;
import org.example.chu_back_v0.bean.intervention.dossier_medical.TypeImage;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class RadiologieDto {
    private Long id;
    private String ref;
    private LocalDateTime dateRadiologie;
    private String commentaire;
    private String imageScann;
    private TypeImageDto typeImageDto;
    private ConsultationDto consultationDto;

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

    public LocalDateTime getDateRadiologie() {
        return dateRadiologie;
    }

    public void setDateRadiologie(LocalDateTime dateRadiologie) {
        this.dateRadiologie = dateRadiologie;
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

    public TypeImageDto getTypeImageDto() {
        return typeImageDto;
    }

    public void setTypeImageDto(TypeImageDto typeImageDto) {
        this.typeImageDto = typeImageDto;
    }

    public ConsultationDto getConsultationDto() {
        return consultationDto;
    }

    public void setConsultationDto(ConsultationDto consultationDto) {
        this.consultationDto = consultationDto;
    }
}
