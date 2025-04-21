package org.example.chu_back_v0.service.impl.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.dossier_medical.FichePatient;
import org.example.chu_back_v0.bean.intervention.dossier_medical.Antecedent;
import org.example.chu_back_v0.dao.intervention.dossier_medical.FichePatientDao;
import org.example.chu_back_v0.service.facade.intervention.dossier_medical.FichePatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FichePatientServiceimpl implements FichePatientService {
    @Autowired
    FichePatientDao fichePatientDao;
    @Autowired
    AntecedentServiceimpl antecedentService;

    @Override
    public FichePatient findByRef(String ref) {
        return fichePatientDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return fichePatientDao.deleteByRef(ref);
    }

    @Override
    public List<FichePatient> findAll() {
        return fichePatientDao.findAll();
    }

    @Override
    public int save(FichePatient fichePatient) {
        if (fichePatient.getAntecedent().getRef() != null && fichePatient.getAntecedent() != null) {
            String ref = fichePatient.getAntecedent().getRef();
            Antecedent antecedent = antecedentService.findByRef(ref);
            fichePatient.setAntecedent(antecedent);
            fichePatientDao.save(fichePatient);
            return 1;
        } else {
            fichePatient.setAntecedent(null);
            fichePatientDao.save(fichePatient);
            return 2;
        }
    }
}
