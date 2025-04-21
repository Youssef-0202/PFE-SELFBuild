package org.example.chu_back_v0.service.impl.patient;

import org.example.chu_back_v0.bean.patient.PatientContact;
import org.example.chu_back_v0.bean.patient.Relation;
import org.example.chu_back_v0.dao.patient.PationContactDao;
import org.example.chu_back_v0.service.facade.patient.PatientContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientContactServiceimpl implements PatientContactService {
    @Autowired
    private PationContactDao pationContactDao;
    @Autowired
    private RelationServiceimpl relationService;


    @Override
    public PatientContact findByCin(String cin) {
        return pationContactDao.findByCin(cin);
    }

    @Override
    @Transactional
    public int deleteByCin(String cin) {
        return pationContactDao.deleteByCin(cin);
    }

    @Override
    public List<PatientContact> findAll() {
        return pationContactDao.findAll();
    }

    @Override
    public int save(PatientContact patientContact) {
        if (patientContact.getRelation() != null && patientContact.getRelation().getRef() != null) {
            String code = patientContact.getRelation().getRef();
            Relation relation = relationService.findByRef(code);
            patientContact.setRelation(relation);
        } else {
            patientContact.setRelation(null);
        }
        pationContactDao.save(patientContact);
        return 1;
    }
}
