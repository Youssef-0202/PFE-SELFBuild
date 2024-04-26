package org.example.chu_back_v0.Ws.converter.consultation.dossier_medical;

import org.example.chu_back_v0.Ws.converter.consultation.consultation_medicale.ConsultationConverter;
import org.example.chu_back_v0.Ws.dto.intervention.dossier_medical.RadiologieDto;
import org.example.chu_back_v0.bean.intervention.dossier_medical.Radiologie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RadiologieConverter {
    @Autowired
    ConsultationConverter consultationConverter;
    @Autowired
    TypeImageConverter typeImageConverter;
    public Radiologie toBean(RadiologieDto dto) {
       if (dto != null){
           Radiologie bean = new Radiologie();
           bean.setId(dto.getId());
           bean.setRef(dto.getRef());
           bean.setDateRadiologie(dto.getDateRadiologie());
           bean.setCommentaire(dto.getCommentaire());
           bean.setImageScann(dto.getImageScann());
           bean.setConsultation(consultationConverter.toBean(dto.getConsultationDto()));
           bean.setTypeImage(typeImageConverter.toBean(dto.getTypeImageDto()));
           return bean;
       }else return null;
    }

    public RadiologieDto toDto(Radiologie bean) {
        RadiologieDto dto = new RadiologieDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setDateRadiologie(bean.getDateRadiologie());
        dto.setImageScann(bean.getImageScann());
        dto.setCommentaire(bean.getCommentaire());
        dto.setConsultationDto(consultationConverter.toDto(bean.getConsultation()));
        dto.setTypeImageDto(typeImageConverter.toDto(bean.getTypeImage()));

        return dto;
    }

    public List<Radiologie> toBean(List<RadiologieDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());

    }

    public List<RadiologieDto> toDto(List<Radiologie> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

}
