package org.example.chu_back_v0.Ws.converter.commun;

import org.example.chu_back_v0.Ws.dto.commun.MedecinDto;
import org.example.chu_back_v0.bean.commun.Medecin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MedecinConverter {
    @Autowired
    SexeConverter sexeConverter;
    public Medecin toBean(MedecinDto dto) {
        if(dto != null){
            Medecin bean = new Medecin();
            bean.setId(dto.getId());
            bean.setRef(dto.getRef());
            bean.setNom(dto.getNom());
            bean.setPrenom(dto.getPrenom());
            bean.setTelephone(dto.getTelephone());
            bean.setSpecialite(dto.getSpecialite());
            bean.setPhotoProfil(dto.getPhotoProfil());
            bean.setUserName(dto.getUserName());
            bean.setDateNaissance(dto.getDateNaissance());
            bean.setEmail(dto.getEmail());
            bean.setSexe(sexeConverter.toBean(dto.getSexeDto()));
            return bean;
        }else {
            return null;
        }

    }

    public MedecinDto toDto(Medecin bean) {
        MedecinDto dto = new MedecinDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setNom(bean.getNom());
        dto.setPrenom(bean.getPrenom());
        dto.setTelephone(bean.getTelephone());
        dto.setSpecialite(bean.getSpecialite());
        dto.setUserName(bean.getUserName());
        dto.setDateNaissance(bean.getDateNaissance());
        dto.setPhotoProfil(bean.getPhotoProfil());
        dto.setEmail(bean.getEmail());
        dto.setSexeDto(sexeConverter.toDto(bean.getSexe()));
        return dto;
    }

    public List<Medecin> toBean(List<MedecinDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());

    }

    public List<MedecinDto> toDto(List<Medecin> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

}
