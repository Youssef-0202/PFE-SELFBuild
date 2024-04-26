package org.example.chu_back_v0.service.impl.consultation.dossier_medical;

import org.example.chu_back_v0.bean.intervention.dossier_medical.Epreuve;
import org.example.chu_back_v0.dao.intervention.dossier_medical.EpreuveDao;
import org.example.chu_back_v0.service.facade.intervention.dossier_medical.EpreuveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EpreuveServiceimpl implements EpreuveService {
    @Autowired
    EpreuveDao epreuveDao;

    @Override
    public Epreuve findByRef(String ref) {
        return epreuveDao.findByRef(ref);
    }
    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return epreuveDao.deleteByRef(ref);
    }
    @Override
    public List<Epreuve> findAll() {
        return epreuveDao.findAll();
    }
    @Override
    public int save(Epreuve epreuve) {
        if(epreuve.getRef() == null || epreuve.getRef() ==""){
            return 0;
        }
        if(epreuveDao.findByRef(epreuve.getRef())==null){
            epreuveDao.save(epreuve);
            return 1;
        }
        else
            return -1;
    }

}
