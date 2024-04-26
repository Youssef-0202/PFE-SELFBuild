package org.example.chu_back_v0.Ws.converter.consultation.gestion_medicale;


import org.example.chu_back_v0.Ws.converter.commun.MedecinConverter;
import org.example.chu_back_v0.Ws.converter.consultation.consultation_medicale.ConsultationConverter;
import org.example.chu_back_v0.Ws.dto.intervention.gestion_medicale.OrdonnanceDto;
import org.example.chu_back_v0.bean.intervention.gestion_medicale.Ordonnance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrdonnanceConverter {
    @Autowired
    ConsultationConverter consultationConverter;
    public Ordonnance toBean(OrdonnanceDto dto) {
        if(dto!=null){
            Ordonnance bean = new Ordonnance();
            bean.setId(dto.getId());
            bean.setRef(dto.getRef());
            bean.setHospitaleName(dto.getHospitaleName());
            bean.setHospitalAdresse(dto.getHospitalAdresse());
            bean.setDateOrdonnance(dto.getDateOrdonnance());
            bean.setSignature(dto.getSignature());
            bean.setConsultation(consultationConverter.toBean(dto.getConsultationDto()));
            return bean;
        }else return null;
    }

    public OrdonnanceDto toDto(Ordonnance bean) {
        OrdonnanceDto dto = new OrdonnanceDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setHospitalAdresse(bean.getHospitalAdresse());
        dto.setHospitaleName(bean.getHospitaleName());
        dto.setDateOrdonnance(bean.getDateOrdonnance());
        dto.setSignature(bean.getSignature());
        dto.setConsultationDto(consultationConverter.toDto(bean.getConsultation()));
        return dto;
    }

    public List<Ordonnance> toBean(List<OrdonnanceDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());

    }

    public List<OrdonnanceDto> toDto(List<Ordonnance> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

}
