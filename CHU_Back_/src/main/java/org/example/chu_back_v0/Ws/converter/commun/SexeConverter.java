package org.example.chu_back_v0.Ws.converter.commun;

import org.example.chu_back_v0.Ws.dto.commun.SexeDto;
import org.example.chu_back_v0.bean.commun.Sexe;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SexeConverter {

    public Sexe toBean(SexeDto dto) {
        Sexe bean = new Sexe();
        bean.setId(dto.getId());
        bean.setRef(dto.getRef());
        bean.setLibelle(dto.getLibelle());
        return bean;
    }
    public SexeDto toDto(Sexe bean) {
        SexeDto dto = new SexeDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setLibelle(bean.getLibelle());

        return dto;
    }
    public List<Sexe> toBean(List<SexeDto> dtos) {
        return dtos.stream().map(e->toBean(e)).collect(Collectors.toList());

    }

    public List<SexeDto> toDto(List<Sexe> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

}
