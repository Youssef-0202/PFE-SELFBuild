package org.example.chu_back_v0.Ws.converter.consultation.gestion_medicale;

import org.example.chu_back_v0.Ws.converter.consultation.consultation_medicale.ConsultationConverter;
import org.example.chu_back_v0.Ws.dto.intervention.gestion_medicale.CertificatDto;
import org.example.chu_back_v0.bean.intervention.gestion_medicale.Certificat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CertificatConverter {
    @Autowired
    ConsultationConverter consultationConverter;

    public Certificat toBean(CertificatDto dto) {
        if(dto!=null){
            Certificat bean = new Certificat();
            bean.setId(dto.getId());
            bean.setRef(dto.getRef());
            bean.setDateDebut(dto.getDateDebut());
            bean.setDescription(dto.getDescription());
            bean.setNbrJour(dto.getNbrJour());
            bean.setDateFin(dto.getDateDebut());
            bean.setConsultation(consultationConverter.toBean(dto.getConsultationDto()));
            return bean;
        }else {
            return null;
        }
    }

    public CertificatDto toDto(Certificat bean) {
        CertificatDto dto = new CertificatDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setDateDebut(bean.getDateDebut());
        dto.setDescription(bean.getDescription());
        dto.setNbrJour(bean.getNbrJour());
        dto.setDateFin(bean.getDateFin());
        dto.setConsultationDto(consultationConverter.toDto(bean.getConsultation()));
        return dto;
    }

    public List<Certificat> toBean(List<CertificatDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());

    }

    public List<CertificatDto> toDto(List<Certificat> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

}
