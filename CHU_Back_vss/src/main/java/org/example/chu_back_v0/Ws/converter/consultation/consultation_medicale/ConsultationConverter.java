package org.example.chu_back_v0.Ws.converter.consultation.consultation_medicale;

import org.example.chu_back_v0.Ws.converter.commun.InfermierConverter;
import org.example.chu_back_v0.Ws.converter.commun.MedecinConverter;
import org.example.chu_back_v0.Ws.converter.patient.PatientConverter;
import org.example.chu_back_v0.Ws.dto.intervention.consultation_medicale.ConsultationDto;
import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConsultationConverter {
    @Autowired
    MedecinConverter medecinConverter;
    @Autowired
    InfermierConverter infermierConverter;
    @Autowired
    PatientConverter patientConverter;



    public Consultation toBean(ConsultationDto dto) {
        if (dto!=null){
            Consultation bean = new Consultation();
            bean.setId(dto.getId());
            bean.setRef(dto.getRef());
            bean.setDateConsultation(dto.getDateConsultation());
            bean.setHeureConsultation(dto.getHeureConsultation());
            bean.setTypeConsultation(dto.getTypeConsultation());
            bean.setAvisMedicale(dto.getAvisMedicale());
            bean.setMedcin(medecinConverter.toBean(dto.getMedecinDto()));
            bean.setPatient(patientConverter.toBean(dto.getPatientDto()));
            bean.setInfermier(infermierConverter.toBean(dto.getInfermierDto()));
            return bean;
        }else {
            return null;
        }
    }

    public ConsultationDto toDto(Consultation bean) {
        ConsultationDto dto = new ConsultationDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setDateConsultation(bean.getDateConsultation());
        dto.setHeureConsultation(bean.getHeureConsultation());
        dto.setTypeConsultation(bean.getTypeConsultation());
        dto.setAvisMedicale(bean.getAvisMedicale());
        dto.setMedecinDto(medecinConverter.toDto(bean.getMedcin()));
        dto.setPatientDto(patientConverter.toDto(bean.getPatient()));
        dto.setInfermierDto(infermierConverter.toDto(bean.getInfermier()));


        return dto;
    }

    public List<Consultation> toBean(List<ConsultationDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());

    }

    public List<ConsultationDto> toDto(List<Consultation> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }
}
