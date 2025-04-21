package org.example.chu_back_v0.dao.patient;

import org.example.chu_back_v0.bean.patient.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface RelationDao extends JpaRepository<Relation, Long> {
    Relation findByRef(String ref);

    int deleteByRef(String ref);

    Relation findByLibelle(String libelle);
}
