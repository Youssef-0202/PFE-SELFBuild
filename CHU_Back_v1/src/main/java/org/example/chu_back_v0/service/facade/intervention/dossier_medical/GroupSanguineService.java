package org.example.chu_back_v0.service.facade.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.dossier_medical.GroupeSanguin;
import org.example.chu_back_v0.dao.intervention.dossier_medical.GroupeSanguinDao;

import java.util.List;

public interface GroupSanguineService {


    GroupeSanguin findByRef(String ref);

    int deleteByRef(String ref);

    List<GroupeSanguin> findAll();
    int save(GroupeSanguin groupeSanguin);
}
