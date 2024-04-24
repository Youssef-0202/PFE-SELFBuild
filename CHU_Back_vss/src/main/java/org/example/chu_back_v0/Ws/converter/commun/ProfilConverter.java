package org.example.chu_back_v0.Ws.converter.commun;

import org.example.chu_back_v0.Ws.dto.commun.MedecinDto;
import org.example.chu_back_v0.Ws.dto.commun.ProfilDto;
import org.example.chu_back_v0.bean.commun.Profil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProfilConverter {
    public Profil toBean(ProfilDto dto) {
        Profil bean = new Profil();
        bean.setId(dto.getId());
        bean.setRef(dto.getRef());
        bean.setNom(dto.getNom());
        bean.setPrenom(dto.getPrenom());
        bean.setTelephone(dto.getTelephone());
        bean.setPhotoProfil(dto.getPhotoProfil());
        bean.setUserName(dto.getUserName());
        bean.setDateNaissance(dto.getDateNaissance());
        bean.setEmail(dto.getEmail());
        return bean;
    }

    public ProfilDto toDto(Profil bean) {
        MedecinDto dto = new MedecinDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setNom(bean.getNom());
        dto.setPrenom(bean.getPrenom());
        dto.setTelephone(bean.getTelephone());
        dto.setUserName(bean.getUserName());
        dto.setDateNaissance(bean.getDateNaissance());
        dto.setPhotoProfil(bean.getPhotoProfil());
        dto.setEmail(bean.getEmail());
        return dto;
    }

    public List<Profil> toBean(List<ProfilDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());

    }

    public List<ProfilDto> toDto(List<Profil> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

}
