package org.example.chu_back_v0.Ws.converter.consultation.gestion_medicale;


import org.example.chu_back_v0.Ws.converter.commun.InfermierConverter;
import org.example.chu_back_v0.Ws.dto.intervention.gestion_medicale.MedicamentDto;
import org.example.chu_back_v0.bean.intervention.gestion_medicale.Medicament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MedicamentConverter {
    @Autowired
    InfermierConverter infermierConverter;
    public Medicament toBean(MedicamentDto dto) {
        if (dto!=null){
            Medicament bean = new Medicament();
            bean.setId(dto.getId());
            bean.setRef(dto.getRef());
            bean.setConsigne(dto.getConsigne());
            bean.setDure(dto.getDure());
            bean.setSoinProduit(dto.getSoinProduit());
            return bean;
        }else {
            return null;
        }
    }

    public MedicamentDto toDto(Medicament bean) {
        MedicamentDto dto = new MedicamentDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setConsigne(bean.getConsigne());
        dto.setDure(bean.getDure());
        dto.setSoinProduit(bean.getSoinProduit());
        return dto;
    }

    public List<Medicament> toBean(List<MedicamentDto> dtos) {
       if(dtos != null){
           return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());
       }else {
           return null;
       }

    }

    public List<MedicamentDto> toDto(List<Medicament> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

}
