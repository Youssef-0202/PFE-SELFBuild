package org.example.chu_back_v0.service.facade.patient;

import org.example.chu_back_v0.bean.patient.Relation;

import java.util.List;

public abstract interface RelationService {


    public abstract List<Relation> findAll();

    Relation findByRef(String ref);

    int deleteByRef(String ref);

    Relation findByLibelle(String libelle);

    public abstract int save(Relation relation);

    void initRelation();
}
