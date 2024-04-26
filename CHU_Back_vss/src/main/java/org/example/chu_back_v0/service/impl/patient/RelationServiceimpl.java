package org.example.chu_back_v0.service.impl.patient;

import org.example.chu_back_v0.bean.patient.Relation;
import org.example.chu_back_v0.bean.security.Role;
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
        if(relation.getRef() == "" || relation.getRef()== null ){
        return 0 ;
    }
        relationDao.save(relation);
        return 1;
    }

    @Override
    public void initRelation() {
        Relation fatherRelation = new Relation();
        fatherRelation.setId(1L);
        fatherRelation.setRef("father");
        fatherRelation.setLibelle("Father relation");
        relationDao.save(fatherRelation);

        Relation motherRelation = new Relation();
        motherRelation.setId(2L);
        motherRelation.setRef("mother");
        motherRelation.setLibelle("Mother relation");
        relationDao.save(motherRelation);
    }

    @Autowired
    private RelationDao relationDao;

}
