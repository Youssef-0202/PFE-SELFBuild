package org.example.chu_back_v0.Ws.converter.consultation.dossier_medical;


import org.example.chu_back_v0.Ws.dto.intervention.dossier_medical.GroupeSanguinDto;
import org.example.chu_back_v0.bean.intervention.dossier_medical.GroupeSanguin;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupeSanguinConverter {
    public GroupeSanguin toBean(GroupeSanguinDto dto) {
      if(dto != null){
          GroupeSanguin bean = new GroupeSanguin();
          bean.setId(dto.getId());
          bean.setRef(dto.getRef());
          bean.setLibelle(dto.getLibelle());
          return bean;
      }else return null;
    }

    public GroupeSanguinDto toDto(GroupeSanguin bean) {
        GroupeSanguinDto dto = new GroupeSanguinDto();
        dto.setId(bean.getId());
        dto.setRef(bean.getRef());
        dto.setLibelle(bean.getLibelle());
        return dto;
    }

    public List<GroupeSanguin> toBean(List<GroupeSanguinDto> dtos) {
        return dtos.stream().map(e -> toBean(e)).collect(Collectors.toList());

    }

    public List<GroupeSanguinDto> toDto(List<GroupeSanguin> beans) {
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }
}
