package org.example.chu_back_v0.service.facade.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.dossier_medical.TypeImage;
import org.example.chu_back_v0.dao.intervention.dossier_medical.TypeImageDao;

import java.util.List;

public interface TypeImageService {


    TypeImage findByRef(String ref);

    int deleteByRef(String ref);

    List<TypeImage> findAll();

    int save(TypeImage typeImage);
}
