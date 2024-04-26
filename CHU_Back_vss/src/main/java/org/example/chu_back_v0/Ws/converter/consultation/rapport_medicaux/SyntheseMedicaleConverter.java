package org.example.chu_back_v0.Ws.converter.consultation.rapport_medicaux;


import org.example.chu_back_v0.Ws.converter.consultation.consultation_medicale.ConsultationConverter;
import org.example.chu_back_v0.Ws.dto.intervention.rapport_medicaux.syntheseMedicaleDto;
import org.example.chu_back_v0.bean.intervention.rapport_medicaux.SyntheseMedicale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class SyntheseMedicaleConverter {
    @Autowired
    ConsultationConverter consultationConverter;
    public SyntheseMedicale toBean(syntheseMedicaleDto dto) {
        if (dto!= null){
            SyntheseMedicale bean = new SyntheseMedicale();
            bean.setId(dto.getId());
            bean.setRef(dto.getRef());
            bean.setDateSyntheseMedicale(dto.getDateSyntheseMedicale());
            bean.setSyntheseMedicale(dto.getSyntheseMedicale());
            bean.setConsultation(consultationConverter.toBean(dto.getConsultationDto()));
            return bean;
        }
        return null;
    }

    public syntheseMedicaleDto toDto(SyntheseMedicale bean) {
        syntheseMedicaleDto dto = new syntheseMedicaleDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setSyntheseMedicale(bean.getSyntheseMedicale());
        dto.setDateSyntheseMedicale(bean.getDateSyntheseMedicale());
        dto.setConsultationDto(consultationConverter.toDto(bean.getConsultation()));


        return dto;
    }

    public List<SyntheseMedicale> toBean(List<syntheseMedicaleDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());

    }

    public List<syntheseMedicaleDto> toDto(List<SyntheseMedicale> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }
}
