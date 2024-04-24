package org.example.chu_back_v0.Ws.dto.intervention.gestion_medicale;

import org.example.chu_back_v0.Ws.dto.commun.MedecinDto;
import org.example.chu_back_v0.Ws.dto.intervention.consultation_medicale.ConsultationDto;
import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class OrdonnanceDto {
    private Long id;
    private String ref;
    private String hospitaleName;
    private String hospitalAdresse;
    private LocalDateTime dateOrdonnance;
    private String signature;

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

    public LocalDateTime getDateOrdonnance() {
        return dateOrdonnance;
    }

    public void setDateOrdonnance(LocalDateTime dateOrdonnance) {
        this.dateOrdonnance = dateOrdonnance;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public ConsultationDto getConsultationDto() {
        return consultationDto;
    }

    public void setConsultationDto(ConsultationDto consultationDto) {
        this.consultationDto = consultationDto;
    }
}
