package org.example.chu_back_v0.service.impl.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.dossier_medical.TypeImage;
import org.example.chu_back_v0.dao.intervention.dossier_medical.TypeImageDao;
import org.example.chu_back_v0.service.facade.intervention.dossier_medical.TypeImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TymeImageServiceimpl implements TypeImageService {
    @Autowired
    private TypeImageDao typeImageDao;

    @Override
    public TypeImage findByRef(String ref) {
        return typeImageDao.findByRef(ref);
    }
    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return typeImageDao.deleteByRef(ref);
    }
    @Override
    public List<TypeImage> findAll() {
        return typeImageDao.findAll();
    }
    @Override
    public int save(TypeImage typeImage) {
        typeImageDao.save(typeImage);
        return 1;
    }
}
