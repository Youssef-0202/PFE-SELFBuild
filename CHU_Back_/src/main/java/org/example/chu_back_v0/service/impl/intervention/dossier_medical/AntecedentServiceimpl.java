package org.example.chu_back_v0.service.impl.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.dossier_medical.GroupeSanguin;
import org.example.chu_back_v0.bean.intervention.dossier_medical.Antecedent;
import org.example.chu_back_v0.dao.intervention.dossier_medical.AntecedentDao;
import org.example.chu_back_v0.service.facade.intervention.dossier_medical.AntecedentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AntecedentServiceimpl implements AntecedentService {
    @Autowired
    AntecedentDao antecedentDao;
    @Autowired
    GroupeSanguineServiceimpl groupeSanguineService;

    @Override
    public Antecedent findByRef(String ref) {
        return antecedentDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return antecedentDao.deleteByRef(ref);
    }

    @Override
    public List<Antecedent> findAll() {
        return antecedentDao.findAll();
    }

    @Override
    public int save(Antecedent antecedent) {
        if (antecedent.getGroupeSanguin() != null && antecedent.getGroupeSanguin().getRef() != null) {
            String code = antecedent.getGroupeSanguin().getRef();
            GroupeSanguin groupeSanguin = groupeSanguineService.findByRef(code);
            antecedent.setGroupeSanguin(groupeSanguin);
            antecedentDao.save(antecedent);
            return 1;
        } else {
            antecedent.setGroupeSanguin(null);
            antecedentDao.save(antecedent);
            return -2;
        }
    }
}
