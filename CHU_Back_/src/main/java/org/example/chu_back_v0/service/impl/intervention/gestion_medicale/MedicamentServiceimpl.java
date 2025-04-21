package org.example.chu_back_v0.service.impl.intervention.gestion_medicale;

import org.example.chu_back_v0.bean.commun.Infermier;
import org.example.chu_back_v0.bean.intervention.gestion_medicale.Medicament;
import org.example.chu_back_v0.dao.intervention.gestion_medicale.MedicamentDao;
import org.example.chu_back_v0.service.facade.intervention.gestion_medicale.MedicamentService;
import org.example.chu_back_v0.service.impl.commun.InfermierServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicamentServiceimpl implements MedicamentService {
    @Autowired
    private MedicamentDao medicamentDao;
    @Autowired
    InfermierServiceimpl infermierService;

    @Override
    public Medicament findByRef(String ref) {
        return medicamentDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return medicamentDao.deleteByRef(ref);
    }

    @Override
    public List<Medicament> findAll() {
        return medicamentDao.findAll();
    }

    @Override
    public int save(Medicament medicament) {

            medicamentDao.save(medicament);
            return 1;
    }

}
