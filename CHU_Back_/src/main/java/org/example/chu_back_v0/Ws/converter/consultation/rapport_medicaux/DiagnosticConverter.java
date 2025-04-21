package org.example.chu_back_v0.Ws.converter.consultation.rapport_medicaux;


import org.example.chu_back_v0.Ws.converter.consultation.consultation_medicale.ConsultationConverter;
import org.example.chu_back_v0.Ws.dto.intervention.rapport_medicaux.DiagnosticDto;
import org.example.chu_back_v0.bean.intervention.rapport_medicaux.Diagnostic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DiagnosticConverter {
    @Autowired
    ConsultationConverter consultationConverter;
    public Diagnostic toBean(DiagnosticDto dto) {
        Diagnostic bean = new Diagnostic();
        bean.setId(dto.getId());
        bean.setRef(dto.getRef());
        bean.setDiagnostic(dto.getDiagnostic());
        bean.setDateDiagnostic(dto.getDateDiagnostic());
        bean.setConsultation(consultationConverter.toBean(dto.getConsultationDto()));


        return bean;
    }

    public DiagnosticDto toDto(Diagnostic bean) {
        DiagnosticDto dto = new DiagnosticDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setDiagnostic(bean.getDiagnostic());
        dto.setDateDiagnostic(bean.getDateDiagnostic());
        dto.setConsultationDto(consultationConverter.toDto(bean.getConsultation()));


        return dto;
    }

    public List<Diagnostic> toBean(List<DiagnosticDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());

    }

    public List<DiagnosticDto> toDto(List<Diagnostic> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }
}
