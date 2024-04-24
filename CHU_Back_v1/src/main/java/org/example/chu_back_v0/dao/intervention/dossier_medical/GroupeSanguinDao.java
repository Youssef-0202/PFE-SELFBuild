package org.example.chu_back_v0.dao.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.dossier_medical.GroupeSanguin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeSanguinDao extends JpaRepository<GroupeSanguin, Long> {
    GroupeSanguin findByRef(String ref);
    int deleteByRef(String ref);
}
