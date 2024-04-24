package org.example.chu_back_v0.service.impl.patient;

import org.example.chu_back_v0.bean.patient.Relation;
import org.example.chu_back_v0.dao.patient.RelationDao;
import org.example.chu_back_v0.service.facade.patient.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RelationServiceimpl implements RelationService {


    @Override
    public List<Relation> findAll() {
        return relationDao.findAll();
    }

    @Override
    public Relation findByRef(String ref) {
        return relationDao.findByRef(ref);
    }
    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return relationDao.deleteByRef(ref);
    }
    @Override
    public Relation findByLibelle(String libelle) {
        return relationDao.findByLibelle(libelle);
    }

    @Override
    public int save(Relation relation) {
        relationDao.save(relation);
        return 1;
    }

    @Autowired
    private RelationDao relationDao;

}
