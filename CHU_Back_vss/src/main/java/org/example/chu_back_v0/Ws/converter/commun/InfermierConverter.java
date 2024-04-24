package org.example.chu_back_v0.Ws.converter.commun;

import org.example.chu_back_v0.Ws.dto.commun.InfermierDto;
import org.example.chu_back_v0.bean.commun.Infermier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InfermierConverter {
    @Autowired
    SexeConverter sexeConverter;
    public Infermier toBean(InfermierDto dto) {
        Infermier bean = new Infermier();
        bean.setId(dto.getId());
        bean.setRef(dto.getRef());
        bean.setNom(dto.getNom());
        bean.setPrenom(dto.getPrenom());
        bean.setEmail(dto.getEmail());
        bean.setTelephone(dto.getTelephone());
        bean.setPhotoProfil(dto.getPhotoProfil());
        bean.setDateNaissance(dto.getDateNaissance());
        bean.setUserName(dto.getUserName());
        bean.setSexe(sexeConverter.toBean(dto.getSexeDto()));
        return bean;
    }

    public InfermierDto toDto(Infermier bean) {
        InfermierDto dto = new InfermierDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setNom(bean.getNom());
        dto.setPrenom(bean.getPrenom());
        dto.setEmail(bean.getEmail());
        dto.setTelephone(bean.getTelephone());
        dto.setDateNaissance(bean.getDateNaissance());
        dto.setPhotoProfil(bean.getPhotoProfil());
        dto.setUserName(bean.getUserName());
        dto.setSexeDto(sexeConverter.toDto(bean.getSexe()));
        return dto;
    }

    public List<Infermier> toBean(List<InfermierDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());

    }

    public List<InfermierDto> toDto(List<Infermier> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

}
