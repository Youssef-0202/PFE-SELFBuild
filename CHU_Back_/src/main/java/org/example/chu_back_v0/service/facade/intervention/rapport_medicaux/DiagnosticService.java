package org.example.chu_back_v0.service.facade.intervention.rapport_medicaux;

import org.example.chu_back_v0.bean.intervention.rapport_medicaux.Diagnostic;

import java.util.List;

public interface DiagnosticService {
    Diagnostic findByRef(String ref);

    int deleteByRef(String ref);

    List<Diagnostic> findAll();

    int save(Diagnostic diagnostic);
}
