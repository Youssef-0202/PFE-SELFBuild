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
        if(patientContact.getCin() == "" || patientContact.getCin() == null ){
            return 0 ;
        }
        PatientContact pat_con = pationContactDao.findByCin(patientContact.getCin());
        if (pat_con == null) {
            if (patientContact.getRelation() != null && patientContact.getRelation().getRef() != null) {
                if (patientContact.getRelation().getRef().equals("father") || patientContact.getRelation().getRef().equals("mother")) {
                    String code = patientContact.getRelation().getRef();
                    Relation relation = relationService.findByRef(code);
                    patientContact.setRelation(relation);
                    pationContactDao.save(patientContact);
                    return 1;
                }else {
                    System.out.println(" father ou mother !! ");
                    return -2;
                }
            }else {
                patientContact.setRelation(null);
                pationContactDao.save(patientContact);
                return -3;
            }
            }
        else
            return -1;
    }


}

/*
@Override
    public int save(PatientContact patientContact) {
        PatientContact pat_con = pationContactDao.findByCin(patientContact.getCin());
        if (pat_con == null) {
            if (patientContact.getRelation() != null && patientContact.getRelation().getRef() != null) {
                if (patientContact.getRelation().getRef().equals("father") || patientContact.getRelation().getRef().equals("mother")) {
                    String code = patientContact.getRelation().getRef();
                    Relation relation = relationService.findByRef(code);
                    patientContact.setRelation(relation);
                    pationContactDao.save(patientContact);
                    return 1;
                } else {
                    patientContact.setRelation(null);
                    pationContactDao.save(patientContact);
                    return -2;
                }
            }
        }else {

        }
    }*/