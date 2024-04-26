package org.example.chu_back_v0.Ws.converter.consultation.dossier_medical;


import org.example.chu_back_v0.Ws.dto.intervention.dossier_medical.AntecedentDto;
import org.example.chu_back_v0.bean.intervention.dossier_medical.Antecedent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AntecedentConverter {

    @Autowired
    GroupeSanguinConverter groupeSanguinConverter;
    public Antecedent toBean(AntecedentDto dto) {
      if(dto != null){
          Antecedent bean = new Antecedent();
          bean.setId(dto.getId());
          bean.setRef(dto.getRef());
          bean.setAlimentation(dto.getAlimentation());
          bean.setAllergie(dto.getAllergie());
          bean.setEtatPsy(dto.getEtatPsy());
          bean.setMouvement(dto.getMouvement());
          bean.setSommeil(dto.getSommeil());
          bean.setRespiration(dto.getRespiration());
          bean.setGroupeSanguin(groupeSanguinConverter.toBean(dto.getGroupeSanguinDto()));
          return bean;
      }else return null;
    }

    public AntecedentDto toDto(Antecedent bean) {
        AntecedentDto dto = new AntecedentDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setAlimentation(bean.getAlimentation());
        dto.setAllergie(bean.getAllergie());
        dto.setEtatPsy(bean.getEtatPsy());
        dto.setSommeil(bean.getSommeil());
        dto.setMouvement(bean.getMouvement());
        dto.setRespiration(bean.getRespiration());
        dto.setGroupeSanguinDto(groupeSanguinConverter.toDto(bean.getGroupeSanguin()));
        return dto;
    }

    public List<Antecedent> toBean(List<AntecedentDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());

    }

    public List<AntecedentDto> toDto(List<Antecedent> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }
}
