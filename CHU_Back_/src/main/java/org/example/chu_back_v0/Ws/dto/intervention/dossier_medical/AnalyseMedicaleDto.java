package org.example.chu_back_v0.Ws.dto.intervention.dossier_medical;


import org.example.chu_back_v0.Ws.dto.intervention.consultation_medicale.ConsultationDto;

import java.time.LocalDateTime;

public class AnalyseMedicaleDto {
    private Long id;
    private String ref;
    private LocalDateTime dateAnalyse;
    private float valeur;
    private String valeurRang;
    private ConsultationDto consultationDto;
    private EpreuveDto epreuveDto;

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

    public LocalDateTime getDateAnalyse() {
        return dateAnalyse;
    }

    public void setDateAnalyse(LocalDateTime dateAnalyse) {
        this.dateAnalyse = dateAnalyse;
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }

    public String getValeurRang() {
        return valeurRang;
    }

    public void setValeurRang(String valeurRang) {
        this.valeurRang = valeurRang;
    }

    public ConsultationDto getConsultationDto() {
        return consultationDto;
    }

    public void setConsultationDto(ConsultationDto consultationDto) {
        this.consultationDto = consultationDto;
    }

    public EpreuveDto getEpreuveDto() {
        return epreuveDto;
    }

    public void setEpreuveDto(EpreuveDto epreuveDto) {
        this.epreuveDto = epreuveDto;
    }
}
