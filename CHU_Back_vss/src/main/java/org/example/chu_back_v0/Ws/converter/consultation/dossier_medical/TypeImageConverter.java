package org.example.chu_back_v0.Ws.converter.consultation.dossier_medical;


import org.example.chu_back_v0.Ws.dto.intervention.dossier_medical.TypeImageDto;
import org.example.chu_back_v0.bean.intervention.dossier_medical.TypeImage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TypeImageConverter {
    public TypeImage toBean(TypeImageDto dto) {
        if(dto != null){
            TypeImage bean = new TypeImage();
            bean.setId(dto.getId());
            bean.setRef(dto.getRef());
            bean.setLibelle(dto.getLibelle());
            return bean;
        }else return null;
    }

    public TypeImageDto toDto(TypeImage bean) {
        TypeImageDto dto = new TypeImageDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setLibelle(bean.getLibelle());
        return dto;
    }

    public List<TypeImage> toBean(List<TypeImageDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());

    }

    public List<TypeImageDto> toDto(List<TypeImage> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }
}
