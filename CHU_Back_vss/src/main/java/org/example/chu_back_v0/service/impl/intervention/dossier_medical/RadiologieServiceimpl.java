package org.example.chu_back_v0.service.impl.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.dossier_medical.Radiologie;
import org.example.chu_back_v0.bean.intervention.dossier_medical.TypeImage;
import org.example.chu_back_v0.dao.intervention.dossier_medical.RadiologieDao;
import org.example.chu_back_v0.service.facade.intervention.dossier_medical.RadiologieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RadiologieServiceimpl implements RadiologieService {
    @Autowired
    RadiologieDao radiologieDao;

    @Autowired
    TymeImageServiceimpl tymeImageService;

    @Override
    public Radiologie findByRef(String ref) {
        return radiologieDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return radiologieDao.deleteByRef(ref);
    }

    @Override
    public List<Radiologie> findAll() {
        return radiologieDao.findAll();
    }

    @Override
    public int save(Radiologie radiologie) {
        if (radiologie.getTypeImage() != null && radiologie.getTypeImage().getRef() != null) {
            String code = radiologie.getTypeImage().getRef();
            TypeImage typeImage = tymeImageService.findByRef(code);
            radiologie.setTypeImage(typeImage);
            radiologieDao.save(radiologie);
        } else {
            radiologie.setTypeImage(null);
            radiologieDao.save(radiologie);
        }
        return 1;
    }
}
