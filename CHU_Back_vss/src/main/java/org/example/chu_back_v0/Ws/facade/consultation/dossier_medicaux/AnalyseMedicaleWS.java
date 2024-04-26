package org.example.chu_back_v0.Ws.facade.consultation.dossier_medicaux;


import org.example.chu_back_v0.Ws.dto.intervention.dossier_medical.AnalyseMedicaleDto;
import org.example.chu_back_v0.bean.intervention.dossier_medical.AnalyseMedicale;
import org.example.chu_back_v0.service.facade.intervention.dossier_medical.AnalyseMedicaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analyseMedicale/")
@PreAuthorize("hasRole('Admin')")
public class AnalyseMedicaleWS {
    @Autowired
    private AnalyseMedicaleService AnalyseMedicaleService;
    @Autowired
     private org.example.chu_back_v0.Ws.converter.Consultation.dossier_medical.AnalyseMedicaleConverter analyseMedicaleConverter;

    @GetMapping("ref/{ref}")
    public AnalyseMedicaleDto findByRef(@PathVariable String ref) {
        AnalyseMedicale AnalyseMedicale = AnalyseMedicaleService.findByRef(ref);
        AnalyseMedicaleDto analyseMedicaleDto = analyseMedicaleConverter.toDto(AnalyseMedicale);
        return analyseMedicaleDto;
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {

        return AnalyseMedicaleService.deleteByRef(ref);
    }

    @GetMapping()
    public List<AnalyseMedicaleDto> findAll() {
        List<AnalyseMedicale> all = AnalyseMedicaleService.findAll();
        return analyseMedicaleConverter.toDto(all);
    }

    @PostMapping()
    public int save(@RequestBody AnalyseMedicaleDto analyseMedicaleDto) {
        AnalyseMedicale analyseMedicale = analyseMedicaleConverter.toBean(analyseMedicaleDto);
        return AnalyseMedicaleService.save(analyseMedicale);
    }
}
