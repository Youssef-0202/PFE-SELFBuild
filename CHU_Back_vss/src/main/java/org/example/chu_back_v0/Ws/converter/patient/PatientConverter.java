package org.example.chu_back_v0.Ws.converter.patient;


import org.example.chu_back_v0.Ws.converter.commun.SexeConverter;
import org.example.chu_back_v0.Ws.dto.patient.PatientDto;
import org.example.chu_back_v0.bean.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientConverter {

    @Autowired
    SexeConverter sexeConverter;
    @Autowired
   PatientContactConverter patientContactConverter;
    public Patient toBean(PatientDto dto) {
       if(dto != null){
           Patient bean = new Patient();
           bean.setId(dto.getId());
           bean.setNom(dto.getNom());
           bean.setNumDossier(dto.getNumDossier());
           bean.setPrenom(dto.getPrenom());
           bean.setPhotoProfil(dto.getPhotoProfil());
           bean.setVille(dto.getVille());
           bean.setDateNaissance(dto.getDateNaissance());
           bean.setSexe(sexeConverter.toBean(dto.getSexeDto()));
           bean.setPassionContact(patientContactConverter.toBean(dto.getPassionContactDto()));
           return bean;
       } else {
           return null;
       }
    }

    public PatientDto toDto(Patient bean) {
        PatientDto dto = new PatientDto();
        dto.setId(bean.getId());
        dto.setNom(bean.getNom());
        dto.setPrenom(bean.getPrenom());
        dto.setNumDossier(bean.getNumDossier());
        dto.setVille(bean.getVille());
        dto.setPhotoProfil(bean.getPhotoProfil());
        dto.setDateNaissance(bean.getDateNaissance());
        dto.setSexeDto(sexeConverter.toDto(bean.getSexe()));
        dto.setPassionContactDto(patientContactConverter.toDto(bean.getPassionContact()));
        return dto;
    }

    public List<Patient> toBean(List<PatientDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());

    }

    public List<PatientDto> toDto(List<Patient> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }
}
