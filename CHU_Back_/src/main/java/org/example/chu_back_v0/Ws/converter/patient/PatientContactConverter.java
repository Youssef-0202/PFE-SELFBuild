package org.example.chu_back_v0.Ws.converter.patient;

import org.example.chu_back_v0.Ws.dto.patient.PatientContactDto;
import org.example.chu_back_v0.bean.patient.PatientContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientContactConverter {
    @Autowired
   RelationConverter relationConverter;
    public PatientContact toBean(PatientContactDto dto) {
        PatientContact bean = new PatientContact();
        bean.setId(dto.getId());
        bean.setAdresse(dto.getAdresse());
        bean.setCin(dto.getCin());
        bean.setEmail(dto.getEmail());
        bean.setNom(dto.getNom());
        bean.setPrenom(dto.getPrenom());
        bean.setTelephone(dto.getTelephone());
        bean.setRelation(relationConverter.toBean(dto.getRelationDto()));


        return bean;
    }

    public PatientContactDto toDto(PatientContact bean) {
        PatientContactDto dto = new PatientContactDto();
        dto.setId(bean.getId());
        dto.setAdresse(bean.getAdresse());
        dto.setCin(bean.getCin());
        dto.setEmail(bean.getEmail());
        dto.setNom(bean.getNom());
        dto.setPrenom(bean.getPrenom());
        dto.setTelephone(bean.getTelephone());
        dto.setRelationDto(relationConverter.toDto(bean.getRelation()));


        return dto;
    }

    public List<PatientContact> toBean(List<PatientContactDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());

    }

    public List<PatientContactDto> toDto(List<PatientContact> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }
}
