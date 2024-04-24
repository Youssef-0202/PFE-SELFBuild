package org.example.chu_back_v0.Ws.dto.intervention.dossier_medical;

import org.example.chu_back_v0.Ws.dto.intervention.consultation_medicale.ConsultationDto;
import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;
import org.example.chu_back_v0.bean.intervention.dossier_medical.Antecedent;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

public class FichePatientDto {
    private Long id;
    private String ref;
    private LocalDateTime dateFichePatient;

    private AntecedentDto antecedentDto;
    private String antecedentFamilial;
    private String histoireMaladie;
    private String examenFichePatient;
    private String conclusionFichePatient;
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

    public LocalDateTime getDateFichePatient() {
        return dateFichePatient;
    }

    public void setDateFichePatient(LocalDateTime dateFichePatient) {
        this.dateFichePatient = dateFichePatient;
    }

    public AntecedentDto getAntecedentDto() {
        return antecedentDto;
    }

    public void setAntecedentDto(AntecedentDto antecedentDto) {
        this.antecedentDto = antecedentDto;
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

    public ConsultationDto getConsultationDto() {
        return consultationDto;
    }

    public void setConsultationDto(ConsultationDto consultationDto) {
        this.consultationDto = consultationDto;
    }
}
