package org.example.chu_back_v0.service.impl.intervention.rapport_medicaux;

import org.example.chu_back_v0.bean.intervention.rapport_medicaux.Diagnostic;
import org.example.chu_back_v0.dao.intervention.rapport_medicaux.DiagnosticDao;
import org.example.chu_back_v0.service.facade.intervention.rapport_medicaux.DiagnosticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DiagnosticServiceimpl implements DiagnosticService {
    @Autowired
    DiagnosticDao diagnosticDao;

    @Override
    public Diagnostic findByRef(String ref) {
        return diagnosticDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return diagnosticDao.deleteByRef(ref);
    }

    @Override
    public List<Diagnostic> findAll() {
        return diagnosticDao.findAll();
    }

    @Override
    public int save(Diagnostic diagnostic) {
        diagnosticDao.save(diagnostic);
        return 1;
    }
}
