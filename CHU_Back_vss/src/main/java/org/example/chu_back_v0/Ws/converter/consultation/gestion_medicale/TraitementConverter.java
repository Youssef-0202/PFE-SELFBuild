package org.example.chu_back_v0.Ws.converter.consultation.gestion_medicale;

import org.example.chu_back_v0.Ws.converter.consultation.consultation_medicale.ConsultationConverter;
import org.example.chu_back_v0.Ws.dto.intervention.gestion_medicale.TraitementDto;
import org.example.chu_back_v0.bean.intervention.gestion_medicale.Traitement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TraitementConverter {

    @Autowired
    ConsultationConverter consultationConverter;

    @Autowired
    MedicamentConverter medicamentConverter;

    public Traitement toBean(TraitementDto dto) {
        if(dto != null){
            Traitement bean = new Traitement();
            bean.setId(dto.getId());
            bean.setRef(dto.getRef());
            bean.setImageOrdonnance(dto.getImageOrdonnance());
            bean.setMedicaments(medicamentConverter.toBean(dto.getMedicamentDtos()));
            bean.setConsultation(consultationConverter.toBean(dto.getConsultationDto()));
            return bean;
        }else return null;
    }

    public TraitementDto toDto(Traitement bean) {
        TraitementDto dto = new TraitementDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setImageOrdonnance(bean.getImageOrdonnance());
        dto.setMedicamentDtos(medicamentConverter.toDto(bean.getMedicaments()));
        dto.setConsultationDto(consultationConverter.toDto(bean.getConsultation()));
        return dto;
    }

    public List<Traitement> toBean(List<TraitementDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());
    }

    public List<TraitementDto> toDto(List<Traitement> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

}
