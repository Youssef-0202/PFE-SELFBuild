package org.example.chu_back_v0.Ws.dto.intervention.rapport_medicaux;


import org.example.chu_back_v0.Ws.dto.intervention.consultation_medicale.ConsultationDto;
import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;

import javax.persistence.ManyToOne;

public class DiagnosticDto {
    private Long id;
    private String ref;
    private String dateDiagnostic;
    private String diagnostic;

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

    public String getDateDiagnostic() {
        return dateDiagnostic;
    }

    public void setDateDiagnostic(String dateDiagnostic) {
        this.dateDiagnostic = dateDiagnostic;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public ConsultationDto getConsultationDto() {
        return consultationDto;
    }

    public void setConsultationDto(ConsultationDto consultationDto) {
        this.consultationDto = consultationDto;
    }
}
