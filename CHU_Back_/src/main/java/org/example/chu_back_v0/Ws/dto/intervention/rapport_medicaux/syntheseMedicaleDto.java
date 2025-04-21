package org.example.chu_back_v0.Ws.dto.intervention.rapport_medicaux;

import org.example.chu_back_v0.Ws.dto.intervention.consultation_medicale.ConsultationDto;
import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class syntheseMedicaleDto {
    private Long id;
    private String ref;
    private LocalDateTime dateSyntheseMedicale;
    private String syntheseMedicale;
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

    public ConsultationDto getConsultationDto() {
        return consultationDto;
    }

    public void setConsultationDto(ConsultationDto consultationDto) {
        this.consultationDto = consultationDto;
    }
}
