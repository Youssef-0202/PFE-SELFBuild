package org.example.chu_back_v0.Ws.facade.convention.gestion_medicale;

import org.example.chu_back_v0.Ws.converter.consultation.gestion_medicale.MedicamentConverter;
import org.example.chu_back_v0.Ws.dto.intervention.gestion_medicale.MedicamentDto;
import org.example.chu_back_v0.bean.intervention.gestion_medicale.Medicament;
import org.example.chu_back_v0.service.facade.intervention.gestion_medicale.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicament/")
public class MedicamentWs {
    @Autowired
    private MedicamentService medicamentService;
    @Autowired
    private MedicamentConverter medicamentConverter;

    @GetMapping("/ref/{ref}")
    public MedicamentDto findByRef(@PathVariable String ref) {
        Medicament medicament = medicamentService.findByRef(ref);
        MedicamentDto medicamentDto = medicamentConverter.toDto(medicament);
        return medicamentDto;
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return medicamentService.deleteByRef(ref);
    }

    @GetMapping()
    public List<MedicamentDto> findAll() {
        List<Medicament> all = medicamentService.findAll();
        return medicamentConverter.toDto(all);
    }

    @PostMapping()
    public int save(@RequestBody MedicamentDto medicamentDto) {
       Medicament medicament = medicamentConverter.toBean(medicamentDto);
        return medicamentService.save(medicament);
    }
}
