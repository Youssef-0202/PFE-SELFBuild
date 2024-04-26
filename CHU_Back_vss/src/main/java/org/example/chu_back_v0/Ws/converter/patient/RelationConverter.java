package org.example.chu_back_v0.Ws.converter.patient;


import org.example.chu_back_v0.Ws.dto.patient.RelationDto;
import org.example.chu_back_v0.bean.patient.Relation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RelationConverter
{
    public Relation toBean(RelationDto dto) {
        if (dto!=null){
            Relation bean = new Relation();
            bean.setId(dto.getId());
            bean.setRef(dto.getRef());
            bean.setLibelle(dto.getLibelle());
            return bean;
        }else
            return null;
    }
    public RelationDto toDto(Relation bean) {
        RelationDto dto = new RelationDto();
        dto.setRef(bean.getRef());
        dto.setLibelle(bean.getLibelle());

        return dto;
    }
    public List<Relation> toBean(List<RelationDto> dtos) {
        return dtos.stream().map(e->toBean(e)).collect(Collectors.toList());

    }

    public List<RelationDto> toDto(List<Relation> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }
}
