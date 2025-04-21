package org.example.chu_back_v0.Ws.converter.Consultation.dossier_medical;

;
import org.example.chu_back_v0.Ws.converter.consultation.dossier_medical.EpreuveConverter;
import org.example.chu_back_v0.Ws.converter.consultation.consultation_medicale.ConsultationConverter;
import org.example.chu_back_v0.Ws.dto.intervention.dossier_medical.AnalyseMedicaleDto;
import org.example.chu_back_v0.bean.intervention.dossier_medical.AnalyseMedicale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnalyseMedicaleConverter {

    @Autowired
    ConsultationConverter consultationConverter;
    @Autowired
    EpreuveConverter epreuveConverter;
    public AnalyseMedicale toBean(AnalyseMedicaleDto dto) {
        AnalyseMedicale bean = new AnalyseMedicale();
        bean.setId(dto.getId());
        bean.setRef(dto.getRef());
        bean.setDateAnalyse(dto.getDateAnalyse());
        bean.setValeur(dto.getValeur());
        bean.setValeurRang(dto.getValeurRang());
        bean.setConsultation(consultationConverter.toBean(dto.getConsultationDto()));
        bean.setEpreuve(epreuveConverter.toBean(dto.getEpreuveDto()));

        return bean;
    }

    public AnalyseMedicaleDto toDto(AnalyseMedicale bean) {
        AnalyseMedicaleDto dto = new AnalyseMedicaleDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setDateAnalyse(bean.getDateAnalyse());
        dto.setValeur(bean.getValeur());
        dto.setValeurRang(bean.getValeurRang());
        dto.setConsultationDto(consultationConverter.toDto(bean.getConsultation()));
        dto.setEpreuveDto(epreuveConverter.toDto(bean.getEpreuve()));

        return dto;
    }

    public List<AnalyseMedicale> toBean(List<AnalyseMedicaleDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());

    }

    public List<AnalyseMedicaleDto> toDto(List<AnalyseMedicale> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

}
