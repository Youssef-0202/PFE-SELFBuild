package org.example.chu_back_v0.Ws.converter.consultation.dossier_medical;


import org.example.chu_back_v0.Ws.converter.consultation.consultation_medicale.ConsultationConverter;
import org.example.chu_back_v0.Ws.dto.intervention.dossier_medical.FichePatientDto;
import org.example.chu_back_v0.bean.intervention.dossier_medical.FichePatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FichePatientConverter {
    @Autowired
   AntecedentConverter AntecedentConverter;
    @Autowired
    ConsultationConverter consultationConverter;
    public FichePatient toBean(FichePatientDto dto) {
        FichePatient bean = new FichePatient();
        bean.setId(dto.getId());
        bean.setRef(dto.getRef());
        bean.setConclusionFichePatient(dto.getConclusionFichePatient());
        bean.setExamenFichePatient(dto.getExamenFichePatient());
        bean.setAntecedentFamilial(dto.getAntecedentFamilial());
        bean.setHistoireMaladie(dto.getHistoireMaladie());
        bean.setAntecedent(AntecedentConverter.toBean(dto.getAntecedentDto()));
        bean.setConsultation(consultationConverter.toBean(dto.getConsultationDto()));
        return bean;
    }

    public FichePatientDto toDto(FichePatient bean) {
        FichePatientDto dto = new FichePatientDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setAntecedentDto(AntecedentConverter.toDto(bean.getAntecedent()));
        dto.setDateFichePatient(bean.getDateFichePatient());
        dto.setExamenFichePatient(bean.getExamenFichePatient());
        dto.setConclusionFichePatient(bean.getConclusionFichePatient());
        dto.setAntecedentFamilial(bean.getAntecedentFamilial());
        dto.setHistoireMaladie(bean.getHistoireMaladie());
        dto.setConsultationDto(consultationConverter.toDto(bean.getConsultation()));
        dto.setAntecedentDto(AntecedentConverter.toDto(bean.getAntecedent()));
        return dto;
    }

    public List<FichePatient> toBean(List<FichePatientDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());

    }

    public List<FichePatientDto> toDto(List<FichePatient> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }


}
