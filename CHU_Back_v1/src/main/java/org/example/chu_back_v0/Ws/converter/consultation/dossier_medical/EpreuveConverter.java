package org.example.chu_back_v0.Ws.converter.consultation.dossier_medical;


import org.example.chu_back_v0.Ws.dto.intervention.dossier_medical.EpreuveDto;
import org.example.chu_back_v0.bean.intervention.dossier_medical.Epreuve;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EpreuveConverter {
    public Epreuve toBean(EpreuveDto dto) {
        Epreuve bean = new Epreuve();
        bean.setId(dto.getId());
        bean.setRef(dto.getRef());
        bean.setLibelle(dto.getLibelle());

        return bean;
    }

    public EpreuveDto toDto(Epreuve bean) {
        EpreuveDto dto = new EpreuveDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setLibelle(bean.getLibelle());


        return dto;
    }

    public List<Epreuve> toBean(List<EpreuveDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());

    }

    public List<EpreuveDto> toDto(List<Epreuve> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }
}
